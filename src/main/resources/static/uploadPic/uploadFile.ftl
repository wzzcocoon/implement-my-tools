<!DOCTYPE html>
<html>
<head>
    <title>文件上传</title>
	<#include "/content/pub/header_res.ftl"/>
    <style>
        .fileInput{width:64px;height:64px;background:url("${contextPath}/pub/images/icon_add.png");overflow:hidden;position:relative;}
        .upfile{width:64px;height:64px;position:absolute;opacity:0;alpha(opacity=0);cursor:pointer;}
    </style>
</head>
<body>
<div class="container-fluid" style="padding-top: 30px">
    <form method="post" action="${contextPath}${uploadLocation}" enctype="multipart/form-data">
    <div id="uploadfileQueue" class="form-group">
        <div class="col-xs-3">
            <div class="fileInput">
                <input type="file" name="file" id="myfile" class="upfile" onchange="selectFileFn()">
            </div>
        </div>
        <div class="col-xs-6">
        	<div id="filenamediv" ></div>
        </div>
        <div class="col-xs-3" style="padding: 20px 0">
            <input type="submit" id="submitbtn" value="上传" class="btn btn-primary btn-sm" disabled="disabled">
        </div>
    </div>
    </form>
</div>

<#include "/content/pub/footer_res_detail.ftl"/>

<script type="text/javascript">
    var uploadLocation = '${uploadLocation}';
    
    function selectFileFn(){
    	var file = $("#myfile").val();
		var fileName = getFileName(file);
		$('#filenamediv').html(fileName);
    	$('#submitbtn').removeAttr("disabled");
    }
    
    function getFileName(o){
	    var pos=o.lastIndexOf("\\");
	    return o.substring(pos+1);  
	}
    
</script>
</body>
</html>