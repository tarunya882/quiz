<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Custom Login Form</title>
<style> .failed{color:red};</style>
<style> .logged{color:green};</style>
<style>
   .center{
          text-align: center;
          margin: auto;
          width: auto;
          padding-top: 250px;
          margin-top: auto;
          height: -webkit-fill-available;

   }
   .main{
        background-color: lightblue;
   }
</style>
</head>
<body style="background-color:lightblue">
<div class="center">
<h3> Login Page</h3>
     <form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">

    <c:if test="${param.error!=null}">
       <i class="failed">Sorry! invalid username/password.</i>
    </c:if>

    <c:if test="${param.logout!=null}">
           <i class="logged">You have been logged out.</i>
    </c:if>

   <div class="form">
       <p>
          User name: <input type="text" name="username"/>
       </p>
        <p>
          Password: <input type="password" name="password"/>
        </p>
        <input type="submit" value="Login"/>
        <br><br>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
     </form>

       <a href="signup" class="btn btn-primary">Sign Up</a>
  </div>
</div>
</body>
</html>