<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title> Admin Page</title>
 <input type="button" value="Questions" onclick="window.location.href='admin/questions';return false;"/>
  <input type="button" value="Users" onclick="window.location.href='admin/users';return false;"/>
</head>

<body>
<h2>Admin Home Page</h2>
<hr>
<p>
  <br>You have all rights<br>
</p>
<hr>
<a href="${pageContext.request.contextPath}/">Back to Home page</a>
</body>
</html>