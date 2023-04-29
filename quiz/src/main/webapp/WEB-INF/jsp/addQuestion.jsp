<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title> QUIZ </title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

<style>.error{color:red}</style>
</head>

<body>
  <form:form action="saveQuestion" modelAttribute="addquestion">
  Enter Question:<br><br>
  <form:input path="question"/>
  <form:errors path="question" cssClass="error"/>
  <br><br>
  Enter Option1:<br><br>
    <form:input path="option1"/>
    <form:errors path="option1" cssClass="error"/>
    <br><br>
    Enter Option2:<br><br>
        <form:input path="option2"/>
        <form:errors path="option2" cssClass="error"/>
    <br><br>
    Enter Option3:<br><br>
            <form:input path="option3"/>
            <form:errors path="option3" cssClass="error"/>
        <br><br>
    Enter Option4:<br><br>
                <form:input path="option4"/>
                <form:errors path="option4" cssClass="error"/>
            <br><br>
    Enter Correct Answer:<br><br>
                    <form:input path="correctanswer"/>
                    <form:errors path="correctanswer" cssClass="error"/>
                <br><br>
  <input type="submit" value="Save"/>
  </form:form>
  <br><br>
  <a href="questions">Back to Quesions</a>
</body>
</html>