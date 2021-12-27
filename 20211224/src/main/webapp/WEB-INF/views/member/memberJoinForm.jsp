<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script> 
</head>
<body>
<div align="center">
	<div><h1>회원가입</h1></div>
	<div>
		<form id="frm" action="" method="post" enctype="multipart/form-data"> <!-- enctype -> 이건 텍스트 이외에 등록할때 있어야함 -->
			<div>
				<table border="1">
					<tr>
						<th width="150">* 아이디</th>
						<td width="300">
							<input type = "email" id="id" name="id" required="required" placeholder="Enter email...">
							&nbsp;&nbsp;<button type ="button" id="idCheck" value="No" onclick="ajaxIdCheck()">중복체크</button>
						</td>
					</tr>
					<tr>
						<th width="150">* 패스워드</th>
						<td width="300">
							<input type="password" id="password" name="password" required="required" placeholder="Enter password...">
						</td>
					</tr>
					<tr>
						<th width="150">* 패스워드 확인</th>
						<td width="300">
							<input type="password" id="password1" name="password1" required="required" placeholder="Enter check password...">
						</td>
					</tr>
					<tr>
						<th width="150">전화번호</th>
						<td width="300">
							<input type="tel" id="tel" name="tel" >
						</td>
					</tr>
					<tr>
						<th width="150">주 소</th>
						<td width="300">
							<input type="text" id="address" name="address">
						</td>
					</tr>
					<tr>
						<th width="150">사 진</th>
						<td width="300">
							<input type="file" id="file" name="file">
						</td>
					</tr>			
				</table>
			</div>
		
		</form>
	</div>
</div>
<script type="text/javascript"> /* 함수 호출에 의해서 나오는 펑션은 보통 body 하단부분에 작성  */
	function ajaxIdCheck() {
		$.ajax({
			url: "ajaxIdCheck.do",
			type : "post",
			data : {"id" : $("#id").val() }, /* 위의 input 에서 id의 값을 들고오는것  key, value*/
			dataType : "text",
			success : function(data){
				if(data = '0') {
				alert("이미 존재하는 아이디 입니다.");
				} else
					{
					alert("사용 가능한 아이디 입니다.");	
					}		
				}
		});
	
	}

</script>
</body>
</html>