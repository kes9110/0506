package com.sds.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection() throws ClassNotFoundException,
	SQLException {
Connection conn = null;

Class.forName("oracle.jdbc.driver.OracleDriver");
String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
String user = "icto";
String password = "icto";
conn = DriverManager.getConnection(url, user, password);

return conn;
}

public static void close(Connection conn, PreparedStatement pstm,
	ResultSet rset) {
if (rset != null) {
	try {
		rset.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
close(conn,pstm);
}

public static void close(Connection conn, PreparedStatement pstm) {
if (pstm != null) {
	try {
		pstm.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
if (conn != null) {
	try {
		conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

}
}
