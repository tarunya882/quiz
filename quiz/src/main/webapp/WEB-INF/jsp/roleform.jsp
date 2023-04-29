<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title> QUIZ </title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

<style>.error{color:red}</style>
</head>

<body>
  <form:form action="addRole" modelAttribute="role">
  <c:forEach var="temp" items="${role}">
         <li>${temp.roles}</li>
   </c:forEach>
   </form:form>
</body>
</html>