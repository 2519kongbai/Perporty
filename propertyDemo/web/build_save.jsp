<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/12/17
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/building/build_save" method="post">
    <table>
        <tr>
            <td>楼栋编号</td>
            <td><input type="text" name="buildingNum"></td>
        </tr>
        <tr>
            <td>楼栋名称</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>户数</td>
            <td><input type="number" name="roomNum"></td>
        </tr>
        <tr>
            <td>楼栋描述</td>
            <td><input type="text" name="buildingDesc"></td>
        </tr>
        <tr>
            <td>创建日期</td>
            <td><input type="date" name="buildHiredate"></td>
        </tr>
        <tr>
            <td>小区ID</td>
            <td><input type="number" name="cid"></td>
        </tr>
        <tr>
            <td><input type="submit" value="新增"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
