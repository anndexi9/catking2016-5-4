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
<script src="login.js"></script>

</head>
<body>
<div class="flex-container">
<header>
<h1><a style="text-decoration: none;" href="/catking/TopPage.jsp">猫の王様</a></h1>
</header>
<div id="nav01"><ul class="nav nav-pills">
<li><a href="/catking/ShowItemServlet?action=cat&cat=food">フード</a></li>
<li><a href="/catking/ShowItemServlet?action=cat&cat=toy">おもちゃ</a></li>
<li><a href="/catking/ShowItemServlet?action=cat&cat=home">家具</a></li>
<li><a href="/catking/ShowItemServlet?action=cat&cat=zakka">雑貨</a></li>
<li><a href="/catking/CartServlet">カート</a></li>
<li><a href="">ログイン</a></li></ul></div>

<div id="nav02" class="aside1 col-sm-12 col-md-4">
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
<section class="aside2 col-sm-12 col-md-8">
<%
/*
if (session != null)
response.sendRedirect("/catking/loginSuccess.jsp");*/
%>
<h2>ようこそ、猫の王様へ</h2>
<c:if test="${msg != null}">
        <h3 style="color:blue;">${msg}</h3>
    </c:if>
  <form action="" method="post" id="loginform">
 <h3>ログイン</h3><br>
 <a href="mem_reg.jsp">新規会員登録はこちら</a><br><br>
<div id="name-gp" class="form-group"><label class="col-sm-2 control-label">ユーザネーム</label>
	<div class="col-sm-10">
	<input class= "form-control" type="text" id="uname"></div></div><br><br>
    <div id="pw1-gp" class="form-group"><label class="col-sm-2 control-label">パスワード</label>
    <div class="col-sm-10">
    <input class= "form-control" type="password" id="pw1"></div></div><br><br>
<input class="btn btn-primary" type="submit" value="Login">
</form>

</section>

<footer>
<br>
Copyright c 猫の王様.com
</footer>

</div>
</body>
</html>