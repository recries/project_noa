<%@ page pageEncoding="utf-8"%>
<c:if test="${!empty alertMsg}">
	<script>
		alert("${alertMsg}");
	</script>
</c:if>
<iframe name="hiddenframe" style="display:none"></iframe>
<!-- base -->