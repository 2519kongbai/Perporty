<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2021/12/17
  Time: 8:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改员工信息</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/building/update" method="post" onsubmit="return confirm('确认修改吗')">
    <table>
        <tr>
            <td>员工编号</td>
            <td>${building.bid}
                <input type="hidden" name="bid" value="${building.bid}">
            </td>
        </tr>
        <tr>
            <td>楼栋编号</td>
            <td><input type="text" name="buildingNum" value="${building.buildingNum}"></td>
        </tr>
        <tr>
            <td>楼栋名称</td>
            <td><input type="text" name="name" value="${building.name}"></td>
        </tr>
        <tr>
            <td>户数</td>
            <td><input type="number" name="roomNum" value="${building.roomNum}"></td>
        </tr>
        <tr>
            <td>楼栋描述</td>
            <td><input type="text" name="buildingDesc" value="${building.buildingDesc}"></td>
        </tr>
        <tr>
            <td>创建日期</td>
            <td><input type="date" name="buildHiredate" value="${building.buildHiredate}"></td>
        </tr>
        <tr>
            <td>小区ID</td>
            <td><input type="number" name="cid" value="${building.cid}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="修改"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
