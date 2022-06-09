package jp.co.aforce.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MemberInfo;
import jp.co.aforce.dao.MemberInfoDAO;

@WebServlet(urlPatterns = { "/jp/co/aforce/action/RegistAction" })
public class RegistAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//		HttpSession session = request.getSession();

		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setLast_name(request.getParameter("last_name"));
		memberInfo.setFirst_name(request.getParameter("first_name"));
		memberInfo.setSex(request.getParameter("sex"));
		memberInfo.setBirth_year(Integer.parseInt(request.getParameter("birth_year")));
		memberInfo.setBirth_month(Integer.parseInt(request.getParameter("birth_month")));
		memberInfo.setBirth_day(Integer.parseInt(request.getParameter("birth_day")));
		memberInfo.setJob(request.getParameter("job"));
		memberInfo.setPhone_number(request.getParameter("phone_number"));
		memberInfo.setMail_address(request.getParameter("mail_address"));

		MemberInfoDAO dao = new MemberInfoDAO();
		try {
			int count = dao.selectCount(memberInfo);

			if (count != 0) {
				//				session.setAttribute("memberInfo", memberInfo);
				request.getRequestDispatcher("/views/regist-error.jsp").forward(request, response);
			} else {

				Calendar calendar = Calendar.getInstance();

				SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");

				String formattedDate = format.format(calendar.getTime());

				String member_id = "A" + formattedDate;

				memberInfo.setMember_id(member_id);
				int line = dao.insert(memberInfo);

				if (line > 0) {

					request.getRequestDispatcher("/views/regist-in.jsp").forward(request, response);

				} else {

					request.getRequestDispatcher("/views/regist-error2.jsp").forward(request, response);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}