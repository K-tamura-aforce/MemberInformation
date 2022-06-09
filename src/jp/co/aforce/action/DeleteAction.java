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

@WebServlet(urlPatterns = { "/jp/co/aforce/action/DeleteAction" })
public class DeleteAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setMember_id(request.getParameter("member_id"));

		MemberInfoDAO dao = new MemberInfoDAO();
		try {

			int line = dao.deleate(memberInfo);

			if (line > 0) {
				session.setAttribute("I_WKK0003", Messages.I_WKK0003);
				request.getRequestDispatcher("/views/delete-in.jsp").forward(request, response);

			}

		} catch (Exception e) {
			session.setAttribute("E_WKK0006", Messages.E_WKK0006);
			request.getRequestDispatcher("/views/delete-error.jsp").forward(request, response);
		}
		session.invalidate();

	}

}
