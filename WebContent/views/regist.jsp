<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報登録</title>
</head>
<body>

	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

<%try {%>
<% if(session.getAttribute("W_CCM0001").toString() !="") {%>
<p><h3 style="color:red"><%=session.getAttribute("W_CCM0001")%></h3>
<%}} catch(Exception e) {}%>
	<h3>会員情報登録</h3>

	<form action="../jp/co/aforce/action/RegistAction" method="post">
		<p>■名前</p>
		<p>
			姓<input type="text" size="32" name="last_name"> 名<input
				type="text" size="32" name="first_name">
		</p>
		<p>■性別</p>
		<p>
			<input type="radio" name="sex" value="1">男性 <input
				type="radio" name="sex" value="2">女性
		</p>
		<p>■生年月日</p>
		<select name="birth_year">
			<option value="" selected disabled></option>
			<c:forEach var="i" begin="1920" end="2020">>
			<option value="${i}">${i}</option>年
</c:forEach>
		</select> <select name="birth_month">
			<option value="" selected disabled></option>
			<c:forEach var="i" begin="1" end="12">
				<option value="${i}">${i}</option>月
</c:forEach>
		</select> <select name="birth_day">
			<option value="" selected disabled></option>
			<c:forEach var="i" begin="1" end="31">
				<option value="${i}">${i}</option>日
</c:forEach>
		</select>

		<p>■職業</p>
		<select name="job">
			<option value="" selected disabled></option>
			<option value="100">会社員</option>
			<option value="200">自営業</option>
			<option value="300">学生</option>
			<option value="400">その他</option>
		</select>

		<p>■電話番号</p>
		<p>
			<input type="tel" size="32" name="phone_number">
		<p>■メールアドレス</p>
		<p>
			<input type="text" size="32" name="mail_address">
		</p>

		<a href="../jp/co/aforce/transition/MenuRegist">
			<button type="button">戻る</button>
		</a> <a href="../jp/co/aforce/transition/MenuRegistReset">
			<button type="button">リセット</button>
		</a>
		<button type="submit">登録</button>
	</form>

	<%@include file="../footer.html"%>