<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body>
    <h2>Hello World</h2>
    <hr>
    <div>
        현재 날짜와 시간은 <%=java.time.LocalDateTime.now()%>입니다.
    </div>
    <div>
        메세지 : ${msg}
    </div>
</body>
</html>