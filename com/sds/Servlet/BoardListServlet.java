package com.sds.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.board.dao.BoardDAO;
import com.sds.board.vo.BoardVO;
import com.sds.user.dao.UserDAO;
import com.sds.user.vo.UserVO;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardListServlet() {
		super();
	}
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BoardDAO boardDAO = new BoardDAO();
		ArrayList<BoardVO> boardList = boardDAO.getBoardList();

		request.setAttribute("boardList", boardList);
		RequestDispatcher rd = request.getRequestDispatcher("BoardList.jsp");
		rd.forward(request, response);

	}
}
