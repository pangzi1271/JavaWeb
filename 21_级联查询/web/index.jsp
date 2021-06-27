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
                $.ajax({
                    url: "province",
                    dataType: "json",
                    success: function (resp){
                        //载入数据前先清空数据以避免重复载入数据
                        $("#province").empty();

                        //遍历province数组并给select下拉选框赋值
                        $.each(resp, function (i, n){
                            // 获取“类Province”中的provinceId和provinceName
                            $("#province").append("<option value='" + n.provinceId + "'>" + n.provinceName + "</option>");
                        })
                    }
                })
            })
        })

        $(function (){
            $("#province").change(function (){
                var provinceId = $("#province>option:selected").val();
                $.ajax({
                    url:"cityQuery",
                    data:{"provinceId":provinceId},
                    dataType: "json",
                    success:function (resp){
                        $("#city").empty();
                        $.each(resp, function(i, n){
                            $("#city").append("<option value='" + n.provinceId + "'>" + n.cityName + "</option>")
                        })
                    }
                })
            })
        })
    </script>
</head>
<body>
<center>
    <table border="2">
        <tr>
            <td>省份名称</td>
            <td>
                <select id="province">
                    <option value="0">请选择...</option>
                </select>
            </td>
            <td><input type="button" id="btn1" value="载入数据"></td>
        </tr>
        <tr>
            <td>城市名称</td>
            <td>
                <select id="city">
                    <option value="0">请选择...</option>
                </select>
            </td>
        </tr>

    </table>
</center>
</body>
</html>
