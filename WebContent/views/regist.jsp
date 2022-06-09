<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body>

	<h3>会員情報登録</h3>

	<form action="../jp/co/aforce/action/RegistAction" method="post">
		<p>■名前</p>
		<p>
			姓<input type="text" size="32" name="last_name" required> 名<input
				type="text" size="32" name="first_name" required>
		</p>
		<p>■性別</p>
		<p>
			<input type="radio" name="sex" value="1" required>男性 <input
				type="radio" name="sex" value="2" required>女性
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
			<option value="100">会社員</option>
			<option value="200">自営業</option>
			<option value="300">学生</option>
			<option value="400">その他</option>
		</select>

		<p>■電話番号</p>
		<p>
			<input type="tel" size="32" name="phone_number" required>
		<p>■メールアドレス</p>
		<p>
			<input type="text" size="32" name="mail_address" required>
		<p>
			<input type="button" onclick="window.history.back();" value="戻る"><input
				type="reset" value="リセット"><input type="submit" value="登録">
		</p>
	</form>

	<%@include file="../footer.html"%>