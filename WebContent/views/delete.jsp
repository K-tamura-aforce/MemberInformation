<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../header.html"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>会員情報削除</h3>

<form action="../jp/co/aforce/action/DisplayAction2" method="post">

	<p>■会員番号</p>
	<p>
		<input type="text" size="20" name="member_id"
			value="${sessionScope.member_id}" required>
	</p>
	<p>
		<input type="submit" value="検索">
	</p>

</form>

<form action="../action/DeleteAction" method="post">

	<input type="hidden" name="member_id"
		value="${sessionScope.member_id }">

	<p>■名前</p>
	<p>
		姓<input type="text" size="32" name="last_name"
			value="${sessionScope.memberInfo.last_name}" disabled>名<input
			type="text" size="32" name="first_name"
			value="${sessionScope.memberInfo.first_name}" disabled>
	</p>
	<p>■性別</p>
	<p>
		<input type="radio" name="sex"
			<c:if test="${sessionScope.memberInfo.sex == '1'}">checked</c:if>
			disabled>男性 <input type="radio" name="sex"
			<c:if test="${sessionScope.memberInfo.sex == '2'}">checked</c:if>
			disabled>女性
	</p>
	<p>■生年月日</p>
	<select name="birth_year" disabled>
		<option value="" selected disabled></option>
		<c:forEach var="i" begin="1920" end="2020">>
			<option value="${i}"
				<c:if test="${sessionScope.memberInfo.birth_year == i }">selected</c:if>>${i}</option>年
</c:forEach>
	</select> <select name="birth_month" disabled>
		<option value="" selected disabled></option>
		<c:forEach var="i" begin="1" end="12">
			<option value="${i}"
				<c:if test="${sessionScope.memberInfo.birth_month == i }">selected</c:if>>${i}</option>月
</c:forEach>
	</select> <select name="birth_day" disabled>
		<option value="" selected disabled></option>
		<c:forEach var="i" begin="1" end="31">
			<option value="${i}"
				<c:if test="${sessionScope.memberInfo.birth_day == i }">selected</c:if>>${i}</option>日
</c:forEach>
	</select>

	<p>■職業</p>
	<select name="job" disabled>
		<option value="" selected disabled></option>
		<option value="100"
			<c:if test="${sessionScope.memberInfo.job == 100 }">selected</c:if>>会社員</option>
		<option value="200"
			<c:if test="${sessionScope.memberInfo.job == 200 }">selected</c:if>>自営業</option>
		<option value="300"
			<c:if test="${sessionScope.memberInfo.job == 300 }">selected</c:if>>学生</option>
		<option value="400"
			<c:if test="${sessionScope.memberInfo.job == 400 }">selected</c:if>>その他</option>
	</select>

	<p>■電話番号</p>
	<p>
		<input type="tel" size="32" name="phone_number"
			value="${sessionScope.memberInfo.phone_number}" disabled>
	<p>■メールアドレス</p>
	<p>
		<input type="text" size="32" name="mail_address"
			value="${sessionScope.memberInfo.mail_address}" disabled>
	<p>
		<input type="submit" value="戻る"><input type="submit"
			value="リセット"><input type="submit" value="削除">
	</p>
</form>

<%@include file="../footer.html"%>