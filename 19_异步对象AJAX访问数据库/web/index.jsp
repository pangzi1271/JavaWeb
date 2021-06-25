<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>省份查询</title>
    <script type="text/javascript">
      function searchProvince(){

        //1. 创建异步对象
        let xmlHttp = new XMLHttpRequest();

        //2. 绑定异步对象
        xmlHttp.onreadystatechange = function (){
          if (xmlHttp.readyState === 4 && xmlHttp.status === 200){
            document.getElementById("provinceName").value = xmlHttp.responseText;
          }
        }

        //3. 初始化请求数据
        let provinceId = document.getElementById("provinceId").value;
        xmlHttp.open("get", "pro?provinceId=" + provinceId, true);

        //4. 发送请求数据
        xmlHttp.send();
      }
    </script>
  </head>
  <body>
  <center>
    <table border="2">
      <tr>
        <td>省份编号</td>
        <td><input type="text" id="provinceId"></td>
        <td><input type="submit" value="搜索" onclick="searchProvince()"></td>
      </tr>
      <tr>
        <td>省份名称</td>
        <td><input type="text" id="provinceName"></td>
      </tr>
    </table>
  </center>

  </body>
</html>
