<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>商品一覧</title>
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
<h1>商品一覧</h1>
<h3>検索結果： ${noRecords}件</h3>

<%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
        <td><a href="/catking/ShowItemServlet?page=${currentPage - 1}">Previous</a></td>
    </c:if>
 
    <%--For displaying Page numbers. 
    The when condition does not display a link for the current page--%>
    <table border="1">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="/catking/ShowItemServlet?page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>

<c:if test="${empty items}">
ご検索のキーワードと一致する件はありません。
</c:if>
<c:if test="${not empty items}">
<c:forEach items="${items}" var="item">
  <form action ="/catking/CartServlet?action=add"method="post">
  <input type ="hidden" name="item_code"value="${item.id}">
  <a href="/catking/ShowItemServlet?action=detail&id=${item.id}"><img src="./img/Catkingfoto/${item.id}.jpg" style="width:30%; height:30%;"></a><br><br>
  商品番号:<b>${item.id}</b><br><br>
  商品名:<a href="/catking/ShowItemServlet?action=detail&id=${item.id}"><b>${item.name}</b></a><br><br>
  価格（税込）:<b>${item.price } 円</b><br><br>

  個数:<input type ="text" name="quantity" size="1" value="1">個<br>
   <input type ="submit" value ="カートに追加">
  </form>
  <br>
  <br>
  <br>
</c:forEach>
</c:if>
</section>

<footer>
<br>
Copyright c 猫の王様.com
</footer>

</div>
</body>
</html>
