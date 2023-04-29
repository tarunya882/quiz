<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
<style>
   .form{

   }
</style>
</head>
<body style="background-color:cadetblue">
<div class="form">
<div>
   Welcome to Home page
</div>
<hr>
<p>
   User: <security:authentication property="principal.username"/>
   <br><br>
   Role(s): <security:authentication property="principal.authorities"/>
</p>
<hr>
<security:authorize access="hasRole('ADMIN')">
   <p>
     <a href="${pageContext.request.contextPath}/admin">Admin meetings</a>
     (only for admin peeps)
   </p>
   </security:authorize>
<hr>
   <p>
     <a href="processForm">User Page</a>
     (only for admin and user peeps)
   </p>
<hr>



<form:form action="${pageContext.request.contextPath}/logout" method="POST">
     <input type="submit" value="Logout"/>
</form:form>
</div>
</body>
</html>