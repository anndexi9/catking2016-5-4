<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>注文確認</title>
<link rel="stylesheet" href="catking.css">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script src="tree.js"></script>
</head>
<body>
<div class="flex-container">
<header>
<h1><a style="text-decoration: none;" href="/catking/TopPage.html">猫の王様</a></h1>
</header>
<div id="nav01"><ul>
<li><a href="/catking/ShowItemServlet?action=cat&cat=food">フード</a></li>
<li><a href="/catking/ShowItemServlet?action=cat&cat=toy">おもちゃ</a></li>
<li><a href="/catking/ShowItemServlet?action=cat&cat=home">家具</a></li>
<li><a href="/catking/ShowItemServlet?action=cat&cat=zakka">雑貨</a></li>
<li><a href="/catking/CartServlet">カート</a></li>
<li><a href="">ログイン</a></li></ul></div>

<div id="nav02" class="aside1">
<a href="javascript:tree('food');">フード</a><br>
<div id= "food" style="display:none;">
<a href="/catking/ShowItemServlet?action=sub&cat=dry" >ドライフード</a><br>
<a href="/catking/ShowItemServlet?action=sub&cat=wet" >ウェットフード</a><br>
<a href="/catking/ShowItemServlet?action=sub&cat=snack">スナック</a><br>
</div>
<br>
<a href="javascript:tree('toy');">おもちゃ</a><br>
<div id="toy" style="display:none;">
<a href="/catking/ShowItemServlet?action=sub&cat=tsume">爪とぎ</a><br>
<a href="/catking/ShowItemServlet?action=sub&cat=matatabi">またたびトイ</a><br>
</div>
<br>
<a href="javascript:tree('home');" title="家具">家具</a><br>
<div id="home" style="display:none;">
<a href="/catking/ShowItemServlet?action=sub&cat=tower">キャットタワー</a><br>
<a href="/catking/ShowItemServlet?action=sub&cat=bed">ベット</a><br>
<a href="/catking/ShowItemServlet?action=sub&cat=toilet">トイレ</a><br>
</div>
<br>
<a href="javascript:tree('zakka');" title="雑貨">雑貨</a><br>
<div id="zakka" style="display:none;">
<a href="/catking/ShowItemServlet?action=sub&cat=collar">首輪</a><br>
<a href="/catking/ShowItemServlet?action=sub&cat=sand">砂</a><br>
</div>
</div>
<section class="aside2">
<h3>下記の内容で注文を行いますか？</h3>
<h3>ご注文商品</h3>
<c:if test="${not empty cart.items}">
<table border="1">
<tr><td>商品番号</td><td>商品名</td><td>単価(税込)</td><td>個数</td><td>小計</td></tr>

<c:forEach items="${cart.items}" var="item">
<tr>
	<td align="center">${item.value.id}</td>
	<td align="center">${item.value.name}</td>
	<td align="right">${item.value.price}円</td>
	<td align="right">${item.value.qty}</td>
	<td align="right">${item.value.price * item.value.qty}円</td>
</tr>
</c:forEach>
<tr><td align="right" colspan="6">総計：${cart.total}円</td></tr>
</table>

<h3>お客様情報</h3>

<form action="/catking/OrderServlet?action=order" method="post">
	<table border="1">
	<tr>
	<td>お名前</td><td>${customer.name}</td>
	</tr>
	<tr>
	<td>住所</td><td>${customer.address}</td>
	</tr>
	<tr>
	<td>電話番号</td><td>${customer.tel}</td>
	</tr>
	<tr>
	<td>e-mail</td><td>${customer.email}</td>
	</tr>
	</table><br>
	<input type="submit" value="この内容で注文">
</form>

</c:if>
</section>

<footer>
<br>
Copyright c 猫の王様.com
</footer>

</div>




</body>
