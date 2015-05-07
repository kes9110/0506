package com.sds.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.user.dao.UserDAO;
import com.sds.user.vo.UserVO;

@WebServlet("/userList")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserListServlet() {
		super();
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		ArrayList<UserVO> userList = userDAO.getUserList();

		request.setAttribute("userList", userList);
		RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
		rd.forward(request, response);

	}

}
