package com.sds.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.user.dao.UserDAO;
import com.sds.user.vo.UserVO;

@WebServlet("/UserInput")
public class UserInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserInputServlet() {
		super();
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		UserVO user = new UserVO();
		user.setID(request.getParameter("userID"));
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		user.setRole(request.getParameter("role"));
		String msg = null;
		UserDAO userDAO = new UserDAO();
		int result = userDAO.addUser(user);
		if (result == 1) {
			msg = "DB입력에 성공하셨습니다. 당신이 입력한 정보는" + user + " 입니다.";
		} else {
			msg = "DB입력에 실패하셨습니다. 당신이 입력한 정보는" + user + " 입니다.";
		}
		request.setAttribute("message", msg);
		RequestDispatcher rd = request.getRequestDispatcher("UserInput.jsp");
		rd.forward(request, response);

	}

}
