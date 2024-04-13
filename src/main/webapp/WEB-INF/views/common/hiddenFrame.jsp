<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<title>Select</title>
<%@ include file="../../includeFiles/include_source.jsp" %>
</head>
<body>
<script>
<c:if test="${!empty
alertMsg}">
	alert("${alertMsg}");
</c:if>
<c:if test="${!empty scriptContent}">
${scriptContent}
</c:if>
<c:if test="${!empty goPostUrl}">
	go_post('${goPostUrl}','_parent');
</c:if>
</script>
</body>
</html>