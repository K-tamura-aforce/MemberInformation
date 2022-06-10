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

@WebServlet(urlPatterns = { "/jp/co/aforce/action/DisplayAction" })
public class DisplayAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String member_id = request.getParameter("member_id");

		MemberInfoDAO dao = new MemberInfoDAO();
		try {
			MemberInfo memberInfo = dao.searchMember(member_id);

			if (memberInfo == null) {
				session.setAttribute("E_WKK0003", Messages.E_WKK0003);
				request.getRequestDispatcher("/views/display-error.jsp").forward(request, response);
			} else {
				session.setAttribute("member_id", member_id);
				session.setAttribute("memberInfo", memberInfo);
				request.getRequestDispatcher("/views/update2.jsp").forward(request, response);
			}

		} catch (Exception e) {
			session.setAttribute("E_WKK0004", Messages.E_WKK0004);
			request.getRequestDispatcher("/views/display-error2.jsp").forward(request, response);
		}
		session.invalidate();

	}

}
