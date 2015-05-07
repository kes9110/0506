package com.sds.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sds.user.vo.UserVO;

public class UserDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rset = null;

	public int addUser(UserVO user) {
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into users values (?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getID());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getName());
			pstm.setString(4, user.getRole());

			count = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstm);
		}
		return count;
	}

	public UserVO searchUserByID(String ID) {
		UserVO user = new UserVO();
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from users where ID = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, ID);

			rset = pstm.executeQuery();

			if (rset.next()) {
				user.setID(rset.getString(1));
				user.setPassword(rset.getString(2));
				user.setName(rset.getString(3));
				user.setRole(rset.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstm, rset);
			return user;
		}
	}
	public ArrayList<UserVO> getUserList(){
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		
		try{
			conn = DBUtil.getConnection();
			String sql = "select * from users";
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()){
				UserVO user = new UserVO();
				user.setID(rset.getString(1));
				user.setPassword(rset.getString(2));
				user.setName(rset.getString(3));
				user.setRole(rset.getString(4));
				list.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn,pstm,rset);
			return list;
		}
	}
	public UserVO getUserVO(String id){
		UserVO user = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "select * from users where id = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			rset = pstm.executeQuery();
			while(rset.next()){
				 user = new UserVO(rset.getString(1),rset.getString(2),rset.getString(3),rset.getString(4));		
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(conn,pstm,rset);
			System.out.println(user);
			return user;
		}
	}
}
