<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/13
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>计算BMI</title>
    <script>
        function calBMI() {
            //1. 创建异步对象
            let xmlHttp = new XMLHttpRequest();

            //2. 绑定对象
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState === 4 && xmlHttp.status === 200) {
                    document.getElementById("myBMI").innerText = xmlHttp.responseText;
                }
            }

            //3. 初始化请求数据
            let name = document.getElementById("name").value;
            let weight = document.getElementById("weight").value;
            let height = document.getElementById("height").value;
            let param = "name=" + name + "&weight=" + weight + "&height=" + height;
            xmlHttp.open("get", "bmi?" + param, true);

            //4. 发送请求数据
            xmlHttp.send();
        }
    </script>

</head>
<body>
<center>
    <table>
        <tr>
            <td>姓名</td>
            <td><label for="name"></label><input type="text" id="name"></td>
        </tr>
        <tr>
            <td>体重</td>
            <td><label for="weight"></label><input type="text" id="weight"></td>
        </tr>
        <tr>
            <td>身高</td>
            <td><label for="height"></label><input type="text" id="height"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="计算BMI" onclick="calBMI()"></td>
        </tr>
    </table>
    <div id="myBMI">您的BMI正在载入中...</div>
</center>
</body>
</html>
