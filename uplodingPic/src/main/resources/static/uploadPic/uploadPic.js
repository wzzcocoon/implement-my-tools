$(document).ready(function() {
});

$('#pic').viewer();

$("#myModal").on("shown.bs.modal", function() {
	$.getScript(BASE_PATH + '/pub/webuploader/webuploader.min.js', function() {
		$.getScript(BASE_PATH + '/pub/webuploader/upload.js');
	});
});

function delPic(id) {
    layer.confirm("确认删除？", function(idx) {
        $.ajax({
            url : BASE_PATH + "/attachment/removeFile.do?id=" + id,
            success : function(data) {
                if (data == 'ok') {
                    location.reload();
                }
            }
        })
    })
}

function exportXlsImport(){
	if (layer.confirm("请确保导入正确数据",function(index) {
		// 关闭当前window
		layer.close(index);
		layer.open({
			type : 2,
			title : '文件导入',
			shadeClose : false,
			shade : 0.4,
			area : [ '450px', '200px' ],
			content : BASE_PATH+ "/file/upload"
		});
	}));
}