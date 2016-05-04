<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<div id="nav01"><ul class="nav nav-pills">
<li><a href="/catking/ShowItemServlet?action=cat&cat=food">フード</a></li>
<li><a href="/catking/ShowItemServlet?action=cat&cat=toy">おもちゃ</a></li>
<li><a href="/catking/ShowItemServlet?action=cat&cat=home">家具</a></li>
<li><a href="/catking/ShowItemServlet?action=cat&cat=zakka">雑貨</a></li>
<li><a href="/catking/CartServlet">カート</a></li>
<li><a href="">ログイン</a></li></ul></div>

<div id="nav02" class="aside1">
<h4><a id="foodCat" role="button" data-toggle="collapse" href="#food" 
aria-expanded="false" aria-controls="food">フード</a></h4><br>
<ul id= "food" class="collapse nav nav-pills nav-stacked">
<li><a href="/catking/ShowItemServlet?action=sub&cat=dry" >ドライフード</a></li>
<li><a href="/catking/ShowItemServlet?action=sub&cat=wet" >ウェットフード</a></li>
<li><a href="/catking/ShowItemServlet?action=sub&cat=snack">スナック</a></li>
</ul>
<br>
<h4><a id="toyCat" role="button" data-toggle="collapse" href="#toy" 
aria-expanded="false" aria-controls="toy">おもちゃ</a></h4><br>
<ul id= "toy" class="collapse nav nav-pills nav-stacked">
<li><a href="/catking/ShowItemServlet?action=sub&cat=tsume">爪とぎ</a></li>
<li><a href="/catking/ShowItemServlet?action=sub&cat=matatabi">またたびトイ</a></li>
</ul>
<br>
<h4><a id="homeCat" role="button" data-toggle="collapse" href="#home" 
aria-expanded="false" aria-controls="home">家具</a></h4><br>
<ul id= "home" class="collapse nav nav-pills nav-stacked">
<li><a href="/catking/ShowItemServlet?action=sub&cat=tower">キャットタワー</a></li>
<li><a href="/catking/ShowItemServlet?action=sub&cat=bed">ベット</a></li>
<li><a href="/catking/ShowItemServlet?action=sub&cat=toilet">トイレ</a></li>
</ul>
<br>
<h4><a id="zakkaCat" role="button" data-toggle="collapse" href="#zakka" 
aria-expanded="false" aria-controls="zakka">雑貨</a></h4><br>
<ul id= "zakka" class="collapse nav nav-pills nav-stacked">
<li><a href="/catking/ShowItemServlet?action=sub&cat=collar">首輪</a></li>
<li><a href="/catking/ShowItemServlet?action=sub&cat=sand">砂</a></li>
</ul>
</div>
<section class="aside2">

<h3>ご注文ありがとうございました。</h3>
お客様の注文番号は
<h3><font color="red">${orderNumber}</font></h3>
になります。

<br>
<br>
<br>
<a href="TopPage.jsp">トップページへ</a>




</section>

<footer>
<br>
Copyright c 猫の王様.com
</footer>

</div>
</body>
</html>



















