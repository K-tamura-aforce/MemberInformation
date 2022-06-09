package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.MemberInfo;

public class MemberInfoDAO extends DAO {
	public int selectCount(MemberInfo memberInfo)
			throws Exception {
		int count = 0;

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"SELECT COUNT(*)  FROM  member_info WHERE last_name=? AND first_name=? AND sex=? AND birth_year=? AND birth_month=? AND birth_day=? AND job=? AND phone_number=? AND mail_address=?");
		st.setString(1, memberInfo.getLast_name());
		st.setString(2, memberInfo.getFirst_name());
		st.setString(3, memberInfo.getSex());
		st.setInt(4, memberInfo.getBirth_year());
		st.setInt(5, memberInfo.getBirth_month());
		st.setInt(6, memberInfo.getBirth_day());
		st.setString(7, memberInfo.getJob());
		st.setString(8, memberInfo.getPhone_number());
		st.setString(9, memberInfo.getMail_address());
		ResultSet rs = st.executeQuery();
		if (rs.next()) {
			count = rs.getInt(1);
		}

		st.close();
		con.close();

		return count;
	}

	public int insert(MemberInfo memberInfo) throws Exception {
		int line = 0;
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"INSERT INTO   member_info(member_id, last_name, first_name, sex, birth_year, birth_month, birth_day, job, phone_number,mail_address)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		st.setString(1, memberInfo.getMember_id());
		st.setString(2, memberInfo.getLast_name());
		st.setString(3, memberInfo.getFirst_name());
		st.setString(4, memberInfo.getSex());
		st.setInt(5, memberInfo.getBirth_year());
		st.setInt(6, memberInfo.getBirth_month());
		st.setInt(7, memberInfo.getBirth_day());
		st.setString(8, memberInfo.getJob());
		st.setString(9, memberInfo.getPhone_number());
		st.setString(10, memberInfo.getMail_address());
		line = st.executeUpdate();

		st.close();
		con.close();

		return line;

	}

	public MemberInfo searchMember(String member_id)
			throws Exception {
		MemberInfo memberInfo = null;

				Connection con = getConnection();

				PreparedStatement st = con.prepareStatement("SELECT member_info.last_name, member_info.first_name, member_info.sex, member_info.birth_year, member_info.birth_month, member_info.birth_day, member_info.job, member_info.phone_number,member_info.mail_address FROM member_info WHERE member_info.member_id=?");
				st.setString(1, member_id);
				ResultSet rs = st.executeQuery();

				while (rs.next()) {
					memberInfo = new MemberInfo();
					memberInfo.setLast_name(rs.getString("last_name"));
					memberInfo.setFirst_name(rs.getString("first_name"));
					memberInfo.setSex(rs.getString("sex"));
					memberInfo.setBirth_year(rs.getInt("birth_year"));
					memberInfo.setBirth_month(rs.getInt("birth_month"));
					memberInfo.setBirth_day(rs.getInt("birth_day"));
					memberInfo.setJob(rs.getString("job"));
					memberInfo.setPhone_number(rs.getString("phone_number"));
					memberInfo.setMail_address(rs.getString("mail_address"));
				}

				st.close();
				con.close();

				return memberInfo;
			}

	public int update(MemberInfo memberInfo) throws Exception{

		int line = 0;
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("UPDATE member_info SET member_info.last_name=?, member_info.first_name=?, member_info.sex=?, member_info.birth_year=?, member_info.birth_month=?, member_info.birth_day=?, member_info.job=?, member_info.phone_number=?,member_info.mail_address=? WHERE member_info.member_id=?");
		st.setString(1, memberInfo.getLast_name());
		st.setString(2, memberInfo.getFirst_name());
		st.setString(3, memberInfo.getSex());
		st.setInt(4, memberInfo.getBirth_year());
		st.setInt(5, memberInfo.getBirth_month());
		st.setInt(6, memberInfo.getBirth_day());
		st.setString(7, memberInfo.getJob());
		st.setString(8, memberInfo.getPhone_number());
		st.setString(9, memberInfo.getMail_address());
		st.setString(10, memberInfo.getMember_id());
		line = st.executeUpdate();

		st.close();
		con.close();

		return line;

	}

	public int deleate(MemberInfo memberInfo) throws Exception{
		int line = 0;
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("DELETE FROM member_info WHERE member_info.member_id=?");
		st.setString(1, memberInfo.getMember_id());
		line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}

}
