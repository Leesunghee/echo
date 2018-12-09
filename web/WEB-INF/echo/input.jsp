<%--
  Created by IntelliJ IDEA.
  User: sunghee
  Date: 09/12/2018
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>입력 화면</h2>
    <form:form modelAttribute="echoForm">
        <div>텍스트를 입력해 주세요:</div>
        <div>
            <form:input path="text"></form:input>
            <form:errors path="text"></form:errors>
        </div>
        <div>
            <form:button>전송</form:button>
        </div>
    </form:form>
</body>
</html>
