<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    // 쿠키 가져오기
    Cookie[] cookies = request.getCookies();
    
    String autoLogin = null;
    // JSESSIONIND 떄문에 겉에 if문 만듦
    if(cookies !=null){
    	// 쿠키가져온것 향상된 for문으로 autoLogin에 저장
	    for(Cookie cookie : cookies){
	    	autoLogin = cookie.getName();
	    	System.out.println(autoLogin);
	    	// 쿠키 가져온게 널이 아니고 autoLogin이라는 변수에 우리가 만든 쿠키 이름이 있을경우에만 if문 탐
	    	if(autoLogin!=null && autoLogin.equals("auto_login")){
	    		response.sendRedirect("cookie_welcome.jsp");
	    	}
	    }
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="cookie_login_ok.jsp">
		<input type="text" name="id" placeholder="아이디"/><br/>
		<input type="password" name="pw" placeholder="비밀번호"/><br/>
		자동로그인 : <input type="checkbox" name="auto" value="checked"/><br/>
		<input type="submit"/>
	</form>
</body>
</html>