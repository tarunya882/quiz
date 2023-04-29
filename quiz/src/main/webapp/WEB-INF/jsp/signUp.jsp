<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Custom Login Form</title>
<style> .error{color:red};</style>
</head>
<body>
<div class="center">
<h3>Sign Up Page</h3>
     <form:form action="addUser" modelAttribute="adduser">
           User Name:<form:input path="name" />
           <form:errors path="name" cssClass="error"/>
           <br><br>
           Password: <form:input path="password"/>
           <form:errors path="password" cssClass="error"/>
           <input type="submit" value="Submit"/>
     </form:form>


</div>
</body>
</html>