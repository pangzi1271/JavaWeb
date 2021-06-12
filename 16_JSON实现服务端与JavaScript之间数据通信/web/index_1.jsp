<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/12
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSON数据通信</title>
    <script type="text/javascript">
        var stuObj =${requestScope.key};
        window.alert("学员编号：" + stuObj.stuId + "，学员姓名：" + stuObj.stuName);
    </script>
</head>
<body>

</body>
</html>
