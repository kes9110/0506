package com.sds.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sds.board.vo.BoardVO;
import com.sds.user.dao.DBUtil;
import com.sds.user.vo.UserVO;

public class BoardDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rset = null;

	public int addBoard(BoardVO board) {
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into board values (board_no.nextval,?,?,?,sysdate,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, board.getTitle());
			pstm.setString(2, board.getNickname());
			pstm.setString(3, board.getContent());
			pstm.setInt(4, board.getCnt());
			pstm.setString(5, board.getUserID());

			count = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstm);
		}
		return count;
	}

	public BoardVO searchBoardByUserID(String userID) {
		BoardVO board = new BoardVO();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from board where userID = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, userID);

			rset = pstm.executeQuery();

			if (rset.next()) {
				board.setSeq(rset.getInt(1));
				board.setTitle(rset.getString(2));
				board.setNickname(rset.getString(3));
				board.setContent(rset.getString(4));
				board.setReg_date(rset.getString(5));
				board.setCnt(rset.getInt(6));
				board.setUserID(rset.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstm, rset);
			return board;
		}
	}
	public ArrayList<BoardVO> getBoardList(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		
		try{
			conn = DBUtil.getConnection();
			String sql = "select * from board";
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()){
				BoardVO board = new BoardVO();
				board.setSeq(rset.getInt(1));
				board.setTitle(rset.getString(2));
				board.setNickname(rset.getString(3));
				board.setContent(rset.getString(4));
				board.setReg_date(rset.getString(5));
				board.setCnt(rset.getInt(6));
				board.setUserID(rset.getString(7));
				list.add(board);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn,pstm,rset);
			return list;
		}
	}
}
