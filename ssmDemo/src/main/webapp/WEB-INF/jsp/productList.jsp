<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<body>
<%--<form action="${pageContext.request.contextPath }/queryitem.action" method="post">--%>
	<%--<form action="${pageContext.request.contextPath }/deleteAllItem.action" method="post">--%>
		<form action="${pageContext.request.contextPath }/updateAllItem.action" method="post">
查询条件：
<table width="100%" border=1>
<tr>
	<td>
		商品名称：<input type="text" name="product.name">
		商品价格：<input type="text" name="product.price">
		姓名 ：<input type="text" name="user.username">
		性别 ：<input type="text" name="user.sex">
	</td>
	<td>
		<%--<input type="submit" value="查询"/>--%>
		<%--<input type="submit" value="批量删除"/>--%>
		<input type="submit" value="批量修改"/>
	</td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<td></td>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
	<td>操作</td>
</tr>
<c:forEach items="${productList }" var="item" varStatus="status">
<tr>
	<td><input type="checkbox" name="ids" value="${item.id}"></td>
	<td><input type="text" name="products[${status.index}].name" value="${item.name }"></td>
	<td><input type="text" name="products[${status.index}].price" value="${item.price }"></td>
	<td><input type="text" name="products[${status.index}].createtime" value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></td>
	<td><input type="text" name="products[${status.index}].detail" value="${item.detail}"></td>
	
	<%--<td><a href="${pageContext.request.contextPath }/itemEdit.action?id=${item.id}">修改</a></td>--%>
	<td><a href="${pageContext.request.contextPath }/itemEdit/${item.id}">修改</a></td>

</tr>
</c:forEach>

</table>
</form>
</body>

</html>