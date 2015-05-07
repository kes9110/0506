package com.sds.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.board.dao.BoardDAO;
import com.sds.board.vo.BoardVO;

@WebServlet("/BoardInputServlet")
public class BoardInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardInputServlet() {
		super();
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardVO board = new BoardVO();
		board.setTitle(request.getParameter("title"));
		board.setNickname(request.getParameter("nickname"));
		board.setContent(request.getParameter("content"));
		board.setContent(request.getParameter("userID"));
		BoardDAO boardDAO = new BoardDAO();
		String msg = null;
		

		int result = boardDAO.addBoard(board);
		if (result == 1) {
			msg = "DB입력에 성공하셨습니다.";
		} else {
			msg = "DB입력에 실패하셨습니다.";
		}
		request.setAttribute("message", msg);
		RequestDispatcher rd = request.getRequestDispatcher("BoardInput.jsp");
		rd.forward(request, response);

	}

}
