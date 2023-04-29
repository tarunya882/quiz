<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title> QUIZ </title>
<style>
 .quiz{
     background-color: lightgray;
     display:flex;
     margin-left: 300px;
     margin-right: 300px;
    padding-left: 350px;
  }
  .align-center {
    display: flex;
    justify-content: center;
  }
  .submit{
      display: flex;
      margin: auto;
      margin-bottom: 50px;
      width: 150px;
      align-items: center;
      padding-left: 35px;
  }
  .head{
      margin-top: 30px;
      margin-left: 630px;
      color: firebric
      background-color: lavenderblush;
      display:flex;
      text-align:center
      background-color: darkgray;
      padding-left: 85px;
  }
  .form{
         background-color: lavenderblush;
         margin-left: 300px;
         margin-right: 300px;
          display:flex;
         text-align:justify
  }
</style>
</head>

<body>



 <form:form action="answerForm" className="d-flex justify-content-center" modelAttribute="questionPaper">
   <div class="quiz">
   <h3>Take Quiz</h3>
   </div>
   <div class="form">
  <br><br>
  <div class="align-center">
  <ol>
     <c:forEach var="temp" varStatus="loop" items="${questionPaper.qustns}">
     <div>
        <li> ${temp.question} </li>
        <br><br>
         <form:input path="qustns[${loop.index}].correctanswer" type="hidden"/>
        Choose one option:
         <div class="opt">
        <br><br>
               <form:radiobutton path="qustns[${loop.index}].useranswer"  value="${temp.option1}" id="${temp.question}"/>
               <div>${temp.option1}</div>
               <br><br>
                <form:radiobutton path="qustns[${loop.index}].useranswer" value="${temp.option2}" id="${temp.question}"/>
                 <div>${temp.option2}</div>
                              <br><br>
                <form:radiobutton path="qustns[${loop.index}].useranswer" value="${temp.option3}" id="${temp.question}"/>
                 <div>${temp.option3}</div>
                              <br><br>

                <form:radiobutton path="qustns[${loop.index}].useranswer" value="${temp.option4}" id="${temp.question}"/>
                              <br><br>
                 <div>${temp.option4}</div>
         <br><br>

         </div>
     </div>
     </c:forEach>
  </ol>
  </div>
  <input type="submit" value="Submit Quiz" class="submit"/>
  </div>
  </form:form>
</body>
</html>