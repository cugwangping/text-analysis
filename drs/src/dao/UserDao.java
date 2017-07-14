package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import dbConnection.DBConnection;

public class UserDao {
	private DBConnection dbConn;
	
	
	//Constructor UserDAO
	public UserDao(){
		dbConn = new DBConnection();
	}
	
	 // <method>
		//根据用户名查找用户ID
		public String findUserID(String _userName){
			String queryStr = "SELECT user_id FROM user WHERE name = '" + _userName + 
					"';";
			//System.out.println(queryStr);
			Connection conn = dbConn.getConn();
			Statement stmt = dbConn.getStmt(conn);
			ResultSet rs = dbConn.executeSelectQuery(stmt, queryStr);
			String userID = null;
			try {
				if(rs.next()){
					userID = rs.getString(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return userID;
		}
	
	 // <method>
	//根据用户名查找密码
	public String findUserName(String _userName){
		String queryStr = "SELECT password FROM user WHERE name = '" + _userName + 
				"';";
		//System.out.println(queryStr);
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		ResultSet rs = dbConn.executeSelectQuery(stmt, queryStr);
		String password = null;
		try {
			if(rs.next()){
				password = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;
	}
	
	 // <method>
	//查找所有普通用户
	public String[] findAllUserName(){
		String countQuery = "select COUNT(*) from user;";
		String queryStr = "SELECT name FROM user;";
		//System.out.println(queryStr);
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		ResultSet countRs = dbConn.executeSelectQuery(stmt, countQuery);
		int count = 0;
		try {
			if(countRs.next()){
				count = countRs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = dbConn.executeSelectQuery(stmt, queryStr);
		String[] username = new String[count];
		for(int i=0; i<count; i++){
			try {
				if(rs.next()){
					username[i] = rs.getString(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return username;
	}
	
	// <method>
	//添加用户
	public boolean addUser(String insertSql){
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		if(dbConn.executeInsertQuery(stmt, insertSql))
			return true;
		else {
			return false;
		}
	}
	
	//根据用户名更新密码
	public boolean updatePassword(String updateSql){
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		if(dbConn.executeUpdateQuery(stmt, updateSql))
			return true;
		else {
			return false;
		}
	}
	
	//根据用户名删除用户
	public boolean delUser(String delName){
		String delSql = "delete from user where name='"+ delName +"';";
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		if(dbConn.executeDeleteQuery(stmt, delSql)){
			return true;
		}else {
			return false;
		}
	}
}

