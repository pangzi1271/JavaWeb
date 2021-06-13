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
    <script type="text/javascript">
      function calBMI(){
        //1. 创建异步对象
        var xmlHttp = new XMLHttpRequest();
        //2. 给异步对象绑定事件
        xmlHttp.onreadystatechange = function(){
          //处理服务器端返回的数据，更新当前页面
          if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
            var data = xmlHttp.responseText;
            document.getElementById("bmidata").innerText = data;
          }
          //3. 初始化请求数据
          var name = document.getElementById("name");
          var weight = document.getElementById("weight");
          var height = document.getElementById("height");
          var param = "name=" + name + "&weight=" + weight + "&height=" + height;
          xmlHttp.open(get, "bmi?" + param, true);

          //4. 发送数据
          xmlHttp.send();
        }
      }
    </script>
  </head>
<body>
  <center>
    <table>
      <tr>
        <td>姓名</td>
        <td><input type="text" id="name"></td>
      </tr>
      <tr>
        <td>身高</td>
        <td><input type="text" id="height"></td>
      </tr>
      <tr>
        <td>体重</td>
        <td><input type="text" id="weight"></td>
      </tr>
      <tr align="center">
        <td colspan="2"><input type="submit" value="计算BMI" onclick="calBMI()"></td>
      </tr>
    </table>
    <div id="bmidata">您的BMI数据加载中...</div>
  </center>
</body>
</html>
