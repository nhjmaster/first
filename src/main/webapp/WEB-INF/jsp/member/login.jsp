<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btnLogin").on("click", function(){
			var userId = $("#userId").val();
			var userPw = $("#userPw").val();
			
			// ID Check
			if(!userId){
				alert("아이디를 입력 하세요");
				$("#userId").focus();
				return;
			}
			
			if(!userPw){
				alert("비밀번호를 입력 하세요");
				$("#userPw").focus();
				return;				
			}
			
			// 폼 내부의 데이터를 전송할 주소
			document.form1.action="${path}/member/loginCheck.do";
			
			//제출
			document.form1.submit();
			
		});
		
	});	
	
	</script>	


</head>
<body>
	<h2>로그인</h2>
	<form name="form1" method="post">	
		<table border="1" width="400px">
			<tr>
				<td>아이디</td>
				<td> <input name="userId" id="userId"> </td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td> <input type="password" name="userPw" id="userPw"> </td>		
			</tr>		
			<tr>
				<td colspan="2" align="center">
					<button type="button" id="btnLogin"> 로그인 </button>
					<c:if test="${msg == 'fail'}">
						<div style="color: red">
							아이디 또는 비밀번호가 일치하지 않습니다.
						</div>
					</c:if>
					<c:if test="${msg == 'logout'} }">
						<div style="color: red">
							로그아웃 되었습니다.
						</div>
					</c:if>		
				</td>
			</tr>
		</table>
	</form>
	<%@ include file="/WEB-INF/include/include-body.jspf" %>
	
</body>
</html>