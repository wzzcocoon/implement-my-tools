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