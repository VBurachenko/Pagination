<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Main page</title>
    <link href="css/main.css" type="text/css" rel="stylesheet">
</head>
<body>

<div class="table">
    <div class="column">
        <div class="cell">id</div>
        <div class="cell">manufacturer</div>
        <div class="cell">model</div>
        <div class="cell">origin</div>
        <div class="cell">type</div>
        <div class="cell">crew</div>
        <div class="cell">passengerCapacity</div>
        <div class="cell">cargoCapacity</div>
        <div class="cell">price</div>
        <div class="cell">engine amount</div>
        <div class="cell">engine model</div>
        <div class="cell">engine type</div>
        <div class="cell">color</div>
        <div class="cell">radar</div>
        <div class="cell">height</div>
        <div class="cell">length</div>
        <div class="cell">wingspan</div>
        <div class="cell">grossWeight</div>
    </div>

    <c:forEach var="plane" items="${items}">
        <div class="column">
            <div class="cell">${plane.id}</div>
            <div class="cell">${plane.manufacturer}</div>
            <div class="cell">${plane.model}</div>
            <div class="cell">${plane.origin}</div>
            <div class="cell">${plane.type}</div>
            <div class="cell">${plane.crew}</div>
            <div class="cell">${plane.passengerCapacity}</div>
            <div class="cell">${plane.cargoCapacity}</div>
            <div class="cell">${plane.price}</div>
            <div class="cell">${plane.engine.amount}</div>
            <div class="cell">${plane.engine.model}</div>
            <div class="cell">${plane.engine.type}</div>
            <div class="cell">${plane.parameters.color}</div>
            <div class="cell">${plane.parameters.radar}</div>
            <div class="cell">${plane.parameters.height}</div>
            <div class="cell">${plane.parameters.length}</div>
            <div class="cell">${plane.parameters.wingspan}</div>
            <div class="cell">${plane.parameters.grossWeight}</div>
        </div>

    </c:forEach>

</div>

<div class="table">
    <c:if test="${page ne 1}">
        <div class="column">
            <a href="/main.do?page=${page - 1}&command=${command}"> Previous </a>
        </div>
    </c:if>

    <div class="column">
        <c:choose>
            <c:when test="${countOfPages lt 10}">
                <c:forEach begin="1" end="${countOfPages}" var="i">
                    <div class="column">
                        <c:choose>
                            <c:when test="${page eq i}">
                                <div> ${i} </div>
                            </c:when>
                            <c:otherwise>
                                <div><a href="/main.do?page=${i}&command=${command}"> ${i} </a></div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <c:forEach begin="${page}" end="${page + 2}" var="i">
                    <div class="column">
                        <c:choose>
                            <c:when test="${page eq i}">
                                <div> ${i} </div>
                            </c:when>
                            <c:otherwise>
                                <div><a href="/main.do?page=${i}&command=${command}"> ${i} </a></div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </c:forEach>
                <div class="column"> ... </div>
                <c:forEach begin="${countOfPages - 2}" end="${countOfPages}" var="j">
                    <div class="column">
                        <c:choose>
                            <c:when test="${page eq j}">
                                <div> ${j} </div>
                            </c:when>
                            <c:otherwise>
                                <div><a href="/main.do?page=${j}&command=${command}"> ${j} </a></div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>


    <c:if test="${page lt countOfPages}">
        <div class="column">
            <a href="/main.do?page=${page + 1}&command=${command}"> Next </a>
        </div>
    </c:if>
</div>


</body>
</html>