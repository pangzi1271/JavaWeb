<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/22
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>省份信息查询</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn1").on("click", function () {
                var provinceId = $("#provinceId").val();
                $.ajax({
                    url: "province",
                    data: {
                        "provinceId": provinceId
                    },
                    dataType: "json",
                    success: function (resp) {
                        $("#provinceName").val(resp.provinceName);
                        $("#provinceShortName").val(resp.provinceShortName);
                        $("#capitalName").val(resp.capital);
                    },
                })
            })
        })
    </script>
</head>
<body>
<center>
    <table border="2">
        <tr>
            <td>省份编号</td>
            <td><input type="text" id="provinceId"></td>
            <td><input type="button" id="btn1" value="查询"></td>
        </tr>
        <tr colspan="2">
            <td>省份名称</td>
            <td><input type="text" id="provinceName"></td>
        </tr>
        <tr colspan="2">
            <td>省份简称</td>
            <td><input type="text" id="provinceShortName"></td>
        </tr>
        <tr colspan="2">
            <td>省会城市</td>
            <td><input type="text" id="capitalName"></td>
        </tr>
    </table>
</center>
</body>
</html>
