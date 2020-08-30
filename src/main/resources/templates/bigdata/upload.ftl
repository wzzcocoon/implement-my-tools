<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- 1.引入文件 -->
    <link rel="stylesheet" type="text/css" href="/pub/css/webuploader.css">

    <script type="text/javascript" src="/pub/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="/pub/js/webuploader.js"></script>
    <style type="text/css">
        #dndArea {
            width: 200px;
            height: 100px;
            border-color: red;
            border-style: dashed;
        }
    </style>
</head>
<body>
<!-- 2.创建页面元素 -->
<div id="uploader">
    <!-- 创建用于拖拽的区域：
        把文件拖到这里，它就会自动上传 -->
    <div id="dndArea">
        <p style="font-size: 8px">把文件拖到这里，它就会自动上传</p>
    </div>

    <!-- 用于显示文件列表 -->
    <div id="fileListDiv" class="container">
        <table id="fileList" class="table table-striped" border="1" width="800px">
            <tr class="filelist-head">
                <th class="file-name">文件名称</th>
                <th class="file-size">大小</th>
                <th width="20%" class="file-pro">进度</th>
                <th class="file-status">状态</th>
                <th width="20%" class="file-manage">操作</th>
            </tr>
        </table>
    </div>

    <!-- 用于选择文件：
        手动选择文件
        filePicker这个控件ID是固定的-->
    <div id="filePicker">文件上传</div>
</div>
<!-- 3.添加js代码 -->
<script type="text/javascript">
    // 监听分块上传的时间点，断点续传
    var fileMd5;
    //文件名，用于最后合并时生成相同名字的文件，最好不用中文文件名
    var fileName;
    //注册事件函数
    WebUploader.Uploader.register({
            "before-send-file":"beforeSendFile",
            "before-send":"beforeSend",
            "after-send-file":"afterSendFile"
        },{
            //beforeSendFile先于beforeSend事件执行
            beforeSendFile:function(file) {
                fileName = file.name;
                console.info("上传文件：" + fileName);
                // 创建一个deffered,用于通知是否完成操作
                var deferred = WebUploader.Deferred();

                // 计算文件的唯一标识MD5值，用于断点续传和妙传
                (new WebUploader.Uploader()).md5File(file, 0, 5*1024*1024)
                    .progress(function(percentage){
                        $("#"+file.id).find("span.state").text("正在获取文件信息...");
                    })
                    .then(function(val) {
                        fileMd5 = val;
                        $("#" + file.id).find("span.state").text("成功获取文件信息");
                        //放行
                        deferred.resolve();
                    });
                // 通知完成操作
                return deferred.promise();
            },
            beforeSend:function(block) {
                var deferred = WebUploader.Deferred();

                // 支持断点续传，发送到后台判断是否已经上传过
                $.ajax({
                        type:"POST",
                        url:"/UploadActionServlet?action=checkChunk",//后台处理分块接口
                        data:{
                            // 文件唯一表示
                            fileMd5:fileMd5,
                            // 当前分块下标（插件会自动生成，至于生成多少块，插件决定）
                            chunk:block.chunk,
                            // 当前分块大小
                            chunkSize:block.end-block.start
                        },
                        dataType:"json",
                        success:function(response) {
                            if(response.ifExist) {
                                // 分块存在，跳过该分块
                                deferred.reject();
                            } else {
                                // 分块不存在或不完整，重新发送
                                deferred.resolve();
                            }
                        }
                    }
                );


                // 发送文件md5字符串到后台
                this.owner.options.formData.fileMd5 = fileMd5;
                return deferred.promise();
            },
            afterSendFile:function() {
                // 当所有分块都发送完毕之后，通知后台合并分块
                $.ajax({
                    type:"POST",
                    url:"/UploadActionServlet?action=mergeChunks",//调用后台合并分块的接口
                    data:{
                        fileMd5:fileMd5,
                        fileName:fileName //原文件名要传到后台，作为合并后文件的文件名
                    },
                    success:function(response){
                        console.info(response);
                    }
                });
            }
        }
    );

    // 上传基本配置--具体上传器，上传每个块
    var uploader = WebUploader.create({
        swf:"/js/Uploader.swf",
        server:"/FileUploadServlet",//后台的上传接口，用于接收每个块
        pick:"#filePicker",
        auto:true,
        dnd:"#dndArea", //拖拽区域
        disableGlobalDnd:true,
        paste:"#uploader",

        // 分块上传设置
        // 是否分块
        chunked:true,
        // 每块文件大小（默认5M）
        chunkSize:5*1024*1024,
        // 开启几个并行线程（默认3个）
        threads:3,
        // 在上传当前文件时，准备好下一个文件
        prepareNextFile:true
        //duplicate: false //是否支持重复上传
        // chunkRetry : 2, //如果某个分片由于网络问题出错，允许自动重传次数
    });

    // 生成缩略图和上传进度
    uploader.on("fileQueued", function(file) {

            //fileQueued事件
            // 把文件信息追加到fileList的div中

            var $list = $("#fileList");
            $list.append('<tr id="'+ file.id +'" class="file-item">'+
                '<td class="file-name">'+ file.name +'</td>'+
                '<td width="20%" class="file-size">'+ (file.size/1024/1024).toFixed(1)+'M' +'</td>' +
                '<td width="20%" class="file-pro">0%</td>'+
                '<td class="file-status">等待上传</td>'+
                '<td width="20%" class="file-manage"><a class="stop-btn" href="javascript:;">暂停 </a>' +
                '<a class="restart-btn" href="javascript:;">开始 </a>' + '<a class="remove-this" href="javascript:;">取消</a></td>'+
                '</tr>');

            //暂停上传的文件
            $list.on('click','.stop-btn',function(){
                uploader.stop(true);
            })
            //删除上传的文件(取消操作，这并不会重置进度，下次重传还是会从之前的进度开始)
            $list.on('click','.remove-this',function(){
                if ($(this).parents(".file-item").attr('id') == file.id) {
                    uploader.removeFile(file);
                    $(this).parents(".file-item").remove();
                }
            });
            //暂停后继续开始
            $list.on('click','.restart-btn',function(){
                // uploader.start();//用这个是错误的
                // uploader.startUpload(file);//也是错的
                //至于哪个函数才是正确的，看下源码就知道
                //正确的是：upload
                uploader.upload(file);
            });


        }
    );

    //重复添加文件
    var timer1;
    uploader.onError = function(code){
        clearTimeout(timer1);
        timer1 = setTimeout(function(){
            alert('该文件已存在');
        },250);
    };

    // 监控上传进度
    // percentage:代表上传文件的百分比

    // uploader.on("uploadProgress", function(file, percentage) {
    //     //更新进度的具体逻辑，可由自己实现
    // 	//最简单的就是展示数字,例如：87%
    // 	$("#" + file.id).find("span.percentage").text(Math.round(percentage * 100) + "%");
    // });

    //形象一点，可以展示滚动条，进度条

    // 文件上传过程中创建进度条实时显示
    uploader.on( 'uploadProgress', function( file, percentage ) {
        $("td.file-pro").text("");
        var $li = $( '#'+file.id ).find('.file-pro'),
            $percent = $li.find('.file-progress .progress-bar');

        // 避免重复创建
        if ( !$percent.length ) {
            $percent = $('<div class="progress progress-striped active">' +
                '<div class="progress-bar" role="progressbar" style="width: 0%">' +
                '<p class="per" style="line-height: 0px;">0%</p>' +
                '</div>' +
                '</div>' ).appendTo( $li ).find('.progress-bar');
        }

        $li.siblings('.file-status').text('上传中');
        //将百分比赋值到文本控件
        $li.find('.per').text((percentage * 100).toFixed(2) + '%');

        $percent.css('width', percentage * 100 + '%');


    });

    //其他事件
    // 文件上传成功
    uploader.on( 'uploadSuccess', function( file ) {
        $( '#'+file.id ).find('.file-status').text('已上传');
    });

    // 文件上传失败，显示上传出错
    uploader.on( 'uploadError', function( file ) {
        $( '#'+file.id ).find('.file-status').text('上传出错');
    });

</script>
</body>
</html>