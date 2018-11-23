<!DOCTYPE html>
<html>
<head>
    <title>文件上传</title>
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
	
	<#-- SELECT 标签 type 0:标准型 1:自定义型 -->
	<#macro select codeType="" type="0" fieldId="" fieldName="" defValue=""  whereCase="" paramName="" paramValue="" haveHead="true" headName="请选择"  props="" >
		<#if type=='0'>
			<select id="${fieldId!''}" name="${fieldName!''}"  ${props!' '}>
				${htmlUtil('select','${type}','${codeType}','${defValue}','${whereCase}','${haveHead}','${headName}')}
			</select>
		<#elseif type=='1'>
			<select id="${fieldId!''}" name="${fieldName!''}"  ${props!' '}>
				${htmlUtil('select','${type}','${codeType}','${defValue}','${paramName}','${paramValue}','${haveHead}','${headName}','${whereCase}')}
			</select>
		</#if>
	</#macro>
	
	<#-- 分页 标签 -->
	<#macro pages url="" pageCount="0" currentPage="1" >
		<input type="hidden" id="currenPage" name="currenPage" value="1">
		<div id="pagination" class="text-center" url="${url}" pageCount="${pageCount}" currentPage="${currentPage}" ></div>
	</#macro>
	
	<#-- 机构选择 标签 -->
	<#macro organ showLevel=""  defValue="" fieldId="" fieldName="" showAreaId='_organTag_'  props="">
		<select id="${fieldId!''}" name="${fieldName!''}"  ${props!' '}>
			${htmlUtil('organ','${showLevel}','${defValue}','${fieldId}','${fieldName}','${showAreaId}','${props}')}
		</select>
	</#macro>
	<#-- 授权用户 标签 -->
	<#macro userwithauth showLevel=""  defValue="" fieldId="" fieldName="" showAreaId='_organTag_'  props="">
		<select id="${fieldId!''}" name="${fieldName!''}"  ${props!' '}>
			${htmlUtil('user','${showLevel}','${defValue}','${fieldId}','${fieldName}','${showAreaId}','${props}')}
		</select>
	</#macro>
	<#-- 来源级联下拉列表 标签 -->
	<#macro fromtype showLevel=""  defValue="" fieldId="" fieldName="" showAreaId='_organTag_'  props="">
		${htmlUtil('fromtype','${showLevel}','${defValue}','${fieldId}','${fieldName}','${showAreaId}','${props}')}
	</#macro>
	<#macro queryselect codeType="" type="0" defValue="" whereCase="" paramName="" paramValue=""  >${htmlUtil('queryselect','${type}','${codeType}','${defValue}','${whereCase}','${paramName}','${paramValue}')}</#macro>
	<#-- token -->
	<#macro token >
		<input type="hidden"  name="_token_"  value="${_token_!''}">
	</#macro>

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