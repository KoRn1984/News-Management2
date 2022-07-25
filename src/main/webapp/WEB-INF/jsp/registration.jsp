<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="script/validation.js"></script>
<title><bean:message key="locale.linkname.headertitle" /></title>
<link rel="stylesheet" type="text/css" href="styles/newsStyle.css">
<title>Registration</title>
</head>
<body>
	<div class="page">
	
		<div class="header">
			<c:import url="/WEB-INF/pages/tiles/header.jsp" />
		</div>
				
		<div class="base-layout-wrapper">
			<div class="menu">
				<c:if test="${not (sessionScope.user eq 'active')}">							
				    <center><h1>Welcome to the news portal!</h1></center>
					<%-- <c:import url=""></c:import> --%>
				</c:if>
				<c:if test="${sessionScope.user eq 'active'}">
					<c:import url="/WEB-INF/pages/tiles/menu.jsp" />
				</c:if>
			</div>
		    <div class="content">
				<fieldset><legend><b><center>Enter your details:</center></b></legend>
				<form action="controller" method="post">
				<input type="hidden" name="command" value="do_registration" />
				Enter your name:<br/>
				<input type="text" name="name" value="" size=15 maxlength=30 required="required"/><br/>
				Enter your surname:<br/>
				<input type="text" name="surname" value="" size=15 maxlength=30 required="required"/><br/>
				Enter your email:<br/>
				<input type="email" name="email" value="" size=15 maxlength=30 required="required"/><br/>
				Enter login:<br/>
				<input type="text" name="login" value="" size=15 maxlength=30 required="required"/><br/>
				Enter password:<br/>
				<input type="password" name="password" value="" size=15 maxlength=30 required="required"/><br/><br/>
				<input class="button" type="submit" value="Register" /><br/>
				</form>
				</fieldset>
		    </div>
	    </div>

		<div class="footer">
			<c:import url="/WEB-INF/pages/tiles/footer.jsp" />
		</div>
		
	</div>
</body>
</html>