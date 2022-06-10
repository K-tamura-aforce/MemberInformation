<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー</title>
</head>
<body>

<h3>メニュー</h3>

<form action="../jp/co/aforce/transition/MenuRegist" method="post">
<p><input type="submit" value="会員情報登録"></p>
</form>

<form action="../jp/co/aforce/transition/MenuUpdate" method="post">
<p><input type="submit" value="会員情報更新"></p>
</form>

<form action="../jp/co/aforce/transition/MenuDelete" method="post">
<p><input type="submit" value="会員情報削除"></p>
</form>

<%@include file="../footer.html"%>