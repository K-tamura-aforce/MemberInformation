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

@WebServlet(urlPatterns = { "/jp/co/aforce/action/UpdateAction" })
public class UpdateAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String member_id = request.getParameter("member_id");

		MemberInfoDAO dao = new MemberInfoDAO();
		try {
			MemberInfo memberInfo = dao.searchMember(member_id);

			if (memberInfo == null) {
				request.getRequestDispatcher("/views/update-error.jsp").forward(request, response);
			} else {

				session.setAttribute("member_id", member_id);
				session.setAttribute("last_name", memberInfo.getLast_name());
				session.setAttribute("first_name", memberInfo.getFirst_name());
				session.setAttribute("sex", memberInfo.getSex());
				session.setAttribute("birth_year", memberInfo.getBirth_year());
				session.setAttribute("birth_month", memberInfo.getBirth_year());
				session.setAttribute("birth_day", memberInfo.getBirth_year());
				session.setAttribute("job", memberInfo.getJob());
				session.setAttribute("phone_number", memberInfo.getPhone_number());
				session.setAttribute("mail_address", memberInfo.getMail_address());
				request.getRequestDispatcher("/views/update.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
