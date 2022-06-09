package jp.co.aforce.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.MemberInfo;
import jp.co.aforce.dao.MemberInfoDAO;
import jp.co.aforce.values.Messages;

@WebServlet(urlPatterns = { "/jp/co/aforce/action/UpdateAction" })
public class UpdateAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setMember_id(request.getParameter("member_id"));
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
				session.setAttribute("E_WKK0001", Messages.E_WKK0001);
				request.getRequestDispatcher("/views/regist-error.jsp").forward(request, response);
			} else {

				int line = dao.update(memberInfo);

				if (line > 0) {
					session.setAttribute("I_WKK0002", Messages.I_WKK0002);
					request.getRequestDispatcher("/views/update-in.jsp").forward(request, response);
				}

			}

		} catch (Exception e) {
			session.setAttribute("E_WKK0005", Messages.E_WKK0005);
			request.getRequestDispatcher("/views/update-error.jsp").forward(request, response);
		}
		session.invalidate();

	}

}
