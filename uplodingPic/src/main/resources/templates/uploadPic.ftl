<!DOCTYPE html>
<html lang="en">

<head>
	<link href="${contextPath}/pub/webuploader/style.css" rel="stylesheet">
	<link href="${contextPath}/pub/webuploader/webuploader.css" rel="stylesheet">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
	<link href="${contextPath}/pub/css/bootstrap.min.css?v=3.4.0" rel="stylesheet">
	<link href="${contextPath}/pub/css/font-awesome.min.css?v=4.3.0" rel="stylesheet">
	<link href="${contextPath}/pub/css/animate.min.css" rel="stylesheet">
	<link href="${contextPath}/pub/css/style.min.css?v=3.0.0" rel="stylesheet">
	<link href="${contextPath}/pub/css/ziding.css?v=20160125" rel="stylesheet">
	<link href="${contextPath}/pub/css/validform.css" rel="stylesheet">
	<link href="${contextPath}/pub/css/bootstrap-select.min.css?v=1.12.4" rel="stylesheet">
	<link href="${contextPath}/pub/bootstrap-select/bootstrap-table.css" rel="stylesheet">
	<link rel="icon" type="image/x-icon" href="${contextPath}/pub/images/favicon.png">
	<link href="${contextPath}/pub/plugins/imageview/viewer.min.css" rel="stylesheet">
    <title>上传附件</title>
</head>
<body>
	<input id="id" type="hidden" name="id" value="${contextPath}">
    <div class="form-group">
        <label class="col-sm-2 control-label label_padding">图片<label style="color:red;">*</label></label>
        <div class="col-sm-8">
            <div class="col-sm-8" id="pic">
			<#if attachments??>
                <input type="hidden" id ="attachmentsSize" value="${attachments?size}"/>
				<#list attachments as attachment>
					<div class="col-md-2"><img class='thumbnail' style='height:100px;' src="${viewPath}${attachment.filePath}/${attachment.fileName}">&nbsp;&nbsp;
					<#if flag!=2>
						<a href="#" onclick="delPic('${attachment.id}');">删除</a>
                    </#if>
                    </div>
					<div class="col-md-1"></div>

                </#list>
            </#if>
            </div>
        </div>
    </div>
	<!-- end panel -->

	<div class="container-fluid">
		<div class="col-sm-4 col-sm-offset-8">
			<!--data-toggle指以什么事件触发，常用的如modal,popover,tooltips等；
				data-target指事件的目标，一起使用就是代表data-target所指的元素以data-toggle指定的形式显示。-->
			<input type="button" id="upload" data-toggle="modal" data-target="#myModal" value="上传附件" class="btn btn-primary btn-sm zd-btn-pd1">
		</div>
	</div>

	<form id="form1" action="" method="post" name="form1" class="form-horizontal">
		<input type="hidden" id="backUrl" value="${contextPath}/success">
	</form>
	
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="picRefresh();"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title" id="myModalLabel">上传附件</h4>
				</div>
				<form name='saveform' id='saveform' class="form-search" method="post" action="">
					<!-- 文件目录folderName -->
					<input type="hidden" value="pic" id="folderName">
					<div class="modal-body" style="height:500px;overflow-y:auto;">
						<div id="uploader">
							<div class="queueList">
								<div id="dndArea" class="placeholder">
									<div id="filePicker"></div>
									<p>最多可选20个</p>
								</div>
							</div>
							<div class="statusBar" style="display:none;">
								<div class="progress">
									<span class="text">0%</span>
									<span class="percentage"></span>
								</div>
								<div class="info"></div>
								<div class="btns">
									<div id="filePicker2"></div>
									<div class="uploadBtn">开始上传</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<input type="button" onclick="document.location.href = '${contextPath}/downloadDemo'"  value="下载模板" class="btn btn-danger btn-sm">&nbsp;&nbsp;
    <input type="button" onclick="exportXlsImport();" value="导入文件" class="btn btn-danger btn-sm">

	<!-- 弹出框 -->
	<div class="modal fade" id="messageModal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">提示信息</h4>
				</div>
				<div class="modal-body text-center">
					<p id="showAlertInfo"></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="closeTab();">确&nbsp;&nbsp;定</button>
				</div>
			</div>
		</div>
	</div>


	<script src="/pub/js/jquery-2.1.1.min.js" type="text/javascript"></script>
	<script src="/pub/js/bootstrap.min.js?v=3.4.0" type="text/javascript"></script>
	<script src="/pub/js/content.min.js?v=1.0.0"></script>
	<script src="/pub/js/plugins/layer/laydate/laydate.js"></script>
	<script src="/pub/js/public/public.js"></script>
	<script src="/pub/js/public/btPage.js"></script>
	<script src="/pub/js/plugins/layer/layer.min.js"></script>
	<script src="/pub/js/demo/layer-demo.min.js"></script>
	<script src="/pub/js/Validform_v5.3.2_ncr_min.js" type="text/javascript"></script>
	<script src="/pub/js/bootstrap-select.js" type="text/javascript"></script>
	<script src="/pub/bootstrap-select/bootstrap-table.js" type="text/javascript"></script>
	<script type="text/javascript">
	   var BASE_PATH='${contextPath}';
	</script>
	<script type="text/javascript" src="${contextPath}/pub/plugins/imageview/viewer.js"></script>
	<script type="text/javascript" src="${contextPath}/uploadPic/uploadPic.js"></script>
	
</body>

</html>

