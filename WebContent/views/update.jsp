<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.html"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>会員情報更新</h3>

<form action="../jp/co/aforce/action/UpdateAction" method="post">

<p>■会員番号</p>
<p><input type="text" size="20" name="last_name" required></p>
<p><input type="submit" value="検索"></p>

	<p>■名前</p>
	<p>
		姓<input type="text" size="32" name="last_name" required>名<input
			type="text" size="32" name="first_name" required>
	</p>
	<p>■性別</p>
	<p>
		<input type="radio" name="sex" value="男性" required>男性 <input
			type="radio" name="sex" value="女性" required>女性
	</p>
	<p>■生年月日</p>
	<select name="birth_year" required>
		<option value="" selected disabled></option>
		<c:forEach var="i" begin="1920" end="2020">>
			<option value="${i}">${i}</option>年
</c:forEach>
	</select> <select name="birth_month" required>
		<option value="" selected disabled></option>
		<c:forEach var="i" begin="1" end="12">
			<option value="${i}">${i}</option>月
</c:forEach>
	</select> <select name="birth_day" required>
		<option value="" selected disabled></option>
		<c:forEach var="i" begin="1" end="31">
			<option value="${i}">${i}</option>日
</c:forEach>
	</select>

	<p>■職業</p>
	<select name="job" required>
		<option value="" selected disabled></option>
		<option value="会社員">会社員</option>
		<option value="自営業">自営業</option>
		<option value="学生">学生</option>
		<option value="その他">その他</option>
	</select>

	<p>■電話番号</p>
	<p>
		<input type="number" size="32" name="phone_number" required>
	<p>■メールアドレス</p>
	<p>
		<input type="text" size="32" name="mail_address" required>
	<p>
		<input type="submit" value="戻る"><input type="submit"
			value="リセット"><input type="submit" value="登録">
	</p>
</form>

<%@include file="../footer.html"%>