package jp.co.aforce.transition;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/jp/co/aforce/transition/MenuRegistReset" })
public class MenuRegistReset extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("/MemberInformation/views/regist.jsp");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		}

}
