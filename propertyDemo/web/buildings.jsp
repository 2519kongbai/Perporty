<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/12/16
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Buildings</title>
</head>
<body>
<div>
    <table border="1">
        <tr>
            <td>序号</td>
            <td>楼栋编号</td>
            <td>楼栋名称</td>
            <td>户数</td>
            <td>楼栋描述</td>
            <td>创建日期</td>
            <td>小区ID</td>
        </tr>
        <c:forEach items="${buildings}" var="building">
            <tr>
                <td>${building.bid}</td>
                <td>${building.buildingNum}</td>
                <td>${building.name}</td>
                <td>${building.roomNum}</td>
                <td>${building.buildingDesc}</td>
                <td>${building.buildHiredate}</td>
                <td>${building.cid}</td>
                <td>${building.pic}</td>
                <td>
<%--                    <input type="button" value="删除" onclick="${pageContext.request.contextPath}\building\delete?bid=${building.bid}"--%>
<%--                           onclick="return confirm('确认删除吗')">--%>
                    <a href="${pageContext.request.contextPath}/building/delete?bid=${building.bid}"
                       onclick="return confirm('确认删除吗')">删除</a>
                    <a href="${pageContext.request.contextPath}/building/update?bid=${building.bid}">更新</a>
                </td>
            </tr>
        </c:forEach>
        <a href="${pageContext.request.contextPath}/building/build_save">增加</a>
    </table>
</div>
</body>
</html>
