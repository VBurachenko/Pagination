<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="css/home.css" type="text/css" rel="stylesheet">
    <title>Main page</title>
</head>
<body>
<div class="content">
    <h2>Hello!</h2>
    <form action="main.do" method="get">
        <input type="hidden" name="command" value="sax"/>
        <input type="submit" value="SAX" class="button"/>
    </form>

    <form action="main.do" method="get">
        <input type="hidden" name="command" value="stax"/>
        <input type="submit" value="StAX" class="button" />
    </form>

    <form action="main.do" method="get">
        <input type="hidden" name="command" value="dom"/>
        <input type="submit" value="DOM" class="button"/>
    </form>
</div>
</body>
</html>