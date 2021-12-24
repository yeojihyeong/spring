<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>회원목록 리스트</h1>
		</div>
		<table border="1">
			<tr onmouseover='this.style.background="blue";'
			onmouseleave='this.style.background="#FFFFFF";'>
				<th width="100">아이디</th>
				<th width="100">이름</th>
				<th width="100">전화번호</th>
				<th width="250">주소</th>
				<th width="100">권한</th>
			</tr>
			<c:forEach items="${members }" var="member">
				<tr onmouseover='this.style.background="#fcecae";'
			onmouseleave='this.style.background="#FFFFFF";'
			onclick="memberSelect('${member.id }')">
					<td align="center">${member.id }</td>
					<td align="center">${member.name }</td>
					<td align="center">${member.tel }</td>
					<td align="center">${member.address }</td>
					<td align="center">${member.author }</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<div>
			<button type="button" onclick="location.href='home.do'">홈으로</button>
		</div>
		<div>
			<form action="memberSelect.do" id="frm" method='post'>
				<input type="hidden" id="id" name="id"> <!--  id = js id=getparameter -->
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function memberSelect(str) {
			frm.id.value=str
			frm.submit();
		}
	</script>
</body>
</html>
