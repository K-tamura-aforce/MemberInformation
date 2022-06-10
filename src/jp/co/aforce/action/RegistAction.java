package jp.co.aforce.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.MemberInfo;
import jp.co.aforce.dao.MemberInfoDAO;
import jp.co.aforce.java.NullCheck;
import jp.co.aforce.values.Messages;

@WebServlet(urlPatterns = { "/jp/co/aforce/action/RegistAction" })
public class RegistAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		String lastName = request.getParameter("last_name");
		String firstName = request.getParameter("first_name");
		String sex = request.getParameter("sex");
		String birthYear = request.getParameter("birth_year");
		String birthMonth = request.getParameter("birth_month");
		String birthDay = request.getParameter("birth_day");
		String job = request.getParameter("job");
		String phoneNumber = request.getParameter("phone_number");
		String mailAddress = request.getParameter("mail_address");

		String name="";
		try {
			name = NullCheck.getString(lastName, firstName, sex, birthYear, birthMonth, birthDay, job, phoneNumber,
					mailAddress);
		} catch (Exception e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		if (!name.equals("")) {

			session.setAttribute("W_CCM0001", Messages.W_CCM0001);
			request.getRequestDispatcher("/views/regist.jsp").forward(request, response);

		} else {

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
					session.setAttribute("E_WKK0001", Messages.E_WKK0001);
					request.getRequestDispatcher("/views/regist-error.jsp").forward(request, response);
				} else {

					Calendar calendar = Calendar.getInstance();

					SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");

					String formattedDate = format.format(calendar.getTime());

					String member_id = "A" + formattedDate;

					memberInfo.setMember_id(member_id);
					int line = dao.insert(memberInfo);

					if (line > 0) {
						session.setAttribute("I_WKK0001", Messages.I_WKK0001);
						request.getRequestDispatcher("/views/regist-in.jsp").forward(request, response);
					}

				}

			} catch (Exception e) {
				session.setAttribute("E_WKK0002", Messages.E_WKK0002);
				request.getRequestDispatcher("/views/regist-error2.jsp").forward(request, response);
			}
			session.invalidate();
		}

	}

}
