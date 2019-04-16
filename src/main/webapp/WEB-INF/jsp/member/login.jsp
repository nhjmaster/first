<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/include/include-headerRyan.jspf" %>
<script type="text/javascript">
	$(document).ready(function(){
		// 로그인 
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
			//document.form1.action="${path}/member/loginCheck.do"; // 게시판 이동
			document.form1.action="${path}/home/home.do";
			
			//제출
			document.form1.submit();
			
		});
		
		// 회원가입
		$("#btnSignUp").on("click", function(){
			popupOpen();	//Popup Open 함수		
		});
		
		function popupOpen(){
			var url= "/member/signUp.do";    //팝업창 페이지 URL
			var winWidth = 500;
		    var winHeight = 400;
		    var popupOption= "width="+winWidth+", height="+winHeight;    //팝업창 옵션(optoin)
			window.open(url,"",popupOption);
		}
		
	});	
	
</script>
</head>
<body>
    <form name="form1" method="post">
        <svg id="ryan" viewBox="0 0 120 120" xmlns="http://www.w3.org/2000/svg">
            <path d="M0,150 C0,65 120,65 120,150" fill="#e0a243" stroke="#000" stroke-width="2.5" />
            <g class="ears">
                <path d="M46,32 L46,30 C46,16 26,16 26,30 L26,32" fill="#e0a243" stroke="#000" stroke-width="2.5" stroke-linecap="round" transform="rotate(-10,38,24)" />
                <path d="M74,32 L74,30 C74,16 94,16 94,30 L94,32" fill="#e0a243" stroke="#000" stroke-width="2.5" stroke-linecap="round" transform="rotate(10,82,24)" />
            </g>
            <circle cx="60" cy="60" r="40" fill="#e0a243" stroke="#000" stroke-width="2.5" />
            <g class="eyes">
                <!-- left eye and eyebrow-->
                <line x1="37" x2="50" y1="46" y2="46" stroke="#000" stroke-width="3" stroke-linecap="round" />
                <circle cx="44" cy="55" r="3" fill="#000" />
                <!-- right eye and eyebrow -->
                <line x1="70" x2="83" y1="46" y2="46" stroke="#000" stroke-width="3" stroke-linecap="round" />
                <circle cx="76" cy="55" r="3" fill="#000" />
            </g>
            <g class="muzzle">
                <path d="M60,66 C58.5,61 49,63 49,69 C49,75 58,77 60,71 M60,66 C61.5,61 71,63 71,69 C71,75 62,77 60,71" fill="#fff" />
                <path d="M60,66 C58.5,61 49,63 49,69 C49,75 58,77 60,71 M60,66 C61.5,61 71,63 71,69 C71,75 62,77 60,71" fill="#fff" stroke="#000" stroke-width="2.5" stroke-linejoin="round" stroke-linecap="round" />
                <polygon points="59,63.5,60,63.4,61,63.5,60,65" fill="#000" stroke="#000" stroke-width="5" stroke-linejoin="round" />
            </g>
            <path d="M40,105 C10,140 110,140 80,105 L80,105 L70,111 L60,105 L50,111 L40,105" fill="#fff" />
        </svg>
        <input type="text" name="userId" id="userId" placeholder="ID">
        <input type="password" name="userPw" id="userPw" placeholder="Password">
        <br>
        <button type="button" style="background-color:glay" id="btnLogin"> 로그인 </button>
    </form>    
</body>
</html>