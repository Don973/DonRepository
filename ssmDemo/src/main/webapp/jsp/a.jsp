<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/11/6
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="../js/jquery-2.1.0.min.js"></script>

    <script>
        $(document).ready(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/test.action",
                    data:{"name":"小背包","price":10.10},
                    contentType:"application/json;charset=utf-8",
                    success:function (data) {
                        alert(data);

                        alert(data.name);
                        alert(data.price);
                    }
                })
            });
        });
    </script>
</head>
<body>


<button id="btn">发送ajax请求</button>
</body>
</html>
