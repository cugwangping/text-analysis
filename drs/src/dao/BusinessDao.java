package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbConnection.DBConnection;

public class BusinessDao {
private DBConnection dbConn;
	
	
	//Constructor UserDAO
	public BusinessDao(){
		dbConn = new DBConnection();
	}
	
	//根据酒店名称查找酒店ID
	public String findBusinessID(String businessName){
		String queryStr = "SELECT business_id FROM business WHERE name = '" + businessName + 
				"';";
		//System.out.println(queryStr);
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		ResultSet rs = dbConn.executeSelectQuery(stmt, queryStr);
		String businessID = null;
		try {
			if(rs.next()){
				businessID = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return businessID;
	}
	
	 // <method>
	//根据酒店名称查找酒店信息
	public List<String> findByBusinessName(String businessName){
		String queryStr = "SELECT * FROM business WHERE name = '" + businessName + 
				"';";
		//System.out.println(queryStr);
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		ResultSet rs = dbConn.executeSelectQuery(stmt, queryStr);
		List<String> info = new ArrayList<String>();
		try {
			if(rs.next()){
				info.add("酒店名称：" + rs.getString(2) + "		酒店星级: " + rs.getString(6) + "★		酒店特色：" +
			rs.getString(9) + "		所在省份：" + rs.getString(5) + "		所在市区：" + rs.getString(4) +
			"		酒店详细地址: " + rs.getString(3) + "		好评数：" + rs.getInt(7) + "		酒店开业状态：" + rs.getString(8)
			 + "		酒店营业时间：" + rs.getString(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return info;
	}
	
	// <method>
		//根据酒店名称查找酒店信息
		public String findBusinessByID(String businessID){
			String queryStr = "SELECT * FROM business WHERE business_id = '" + businessID + 
					"';";
			//System.out.println(queryStr);
			Connection conn = dbConn.getConn();
			Statement stmt = dbConn.getStmt(conn);
			ResultSet rs = dbConn.executeSelectQuery(stmt, queryStr);
			String info = null;
			try {
				if(rs.next()){
					info = "酒店名称：" + rs.getString(2) + "		酒店星级: " + rs.getString(6) + "★		酒店特色：" +
				rs.getString(9) + "		所在省份：" + rs.getString(5) + "		所在市区：" + rs.getString(4) +
				"		酒店详细地址: " + rs.getString(3) + "		好评数：" + rs.getInt(7) + "		酒店开业状态：" + rs.getString(8)
				 + "		酒店营业时间：" + rs.getString(10);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return info;
		}
	
	 // <method>
		//根据酒店特色查找酒店信息
		public List<String> findByCategory(String queryStr){
			//System.out.println(queryStr);
			Connection conn = dbConn.getConn();
			Statement stmt = dbConn.getStmt(conn);
			ResultSet rs = dbConn.executeSelectQuery(stmt, queryStr);
			List<String> info = new ArrayList<String>();
			try {
				while(rs.next()){
					info.add("酒店名称：" + rs.getString(2) + "		酒店星级: " + rs.getString(6) + "★		酒店特色：" +
							rs.getString(9) + "		所在省份：" + rs.getString(5) + "		所在市区：" + rs.getString(4) +
							"		酒店详细地址: " + rs.getString(3) + "		好评数：" + rs.getInt(7) + "		酒店开业状态：" + rs.getString(8)
							+ "		酒店营业时间：" + rs.getString(10));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return info;
		}
	
	//查找所有酒店名称
		public String[] findBusinessName(){
			String countQuery = "select COUNT(*) from business;";
			String queryStr = "SELECT name FROM business;";
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
			String[] businessname = new String[count];
			for(int i=0; i<count; i++){
				try {
					if(rs.next()){
						businessname[i] = rs.getString(1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return businessname;
		}
	
	 // <method>
	//查找所有酒店信息
	public String[] findAllBusinessName(){
		String countQuery = "select COUNT(*) from business;";
		String queryStr = "SELECT * FROM business;";
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
		String[] businessInfo = new String[count];
		for(int i=0; i<count; i++){
			try {
				if(rs.next()){
					businessInfo[i] = "酒店名称：" + rs.getString(2) + "		酒店星级: " + rs.getString(6) + "★		酒店特色：" +
							rs.getString(9) + "		所在省份：" + rs.getString(5) + "		所在市区：" + rs.getString(4) +
							"		酒店详细地址: " + rs.getString(3) + "		好评数：" + rs.getInt(7) + "		酒店开业状态：" + rs.getString(8)
							+ "		酒店营业时间：" + rs.getString(10);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return businessInfo;
	}
	
	// <method>
	//添加酒店
	public boolean addBusiness(String insertSql){
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		if(dbConn.executeInsertQuery(stmt, insertSql))
			return true;
		else {
			return false;
		}
	}
	
	//更新酒店信息
	public boolean updatePassword(String updateSql){
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		if(dbConn.executeUpdateQuery(stmt, updateSql))
			return true;
		else {
			return false;
		}
	}
	
	//根据酒店名称删除已关闭的酒店
		public boolean delBusiness(String delBusinessName){
			String delSql = "delete from business where name='"+ delBusinessName +"';";
			Connection conn = dbConn.getConn();
			Statement stmt = dbConn.getStmt(conn);
			if(dbConn.executeDeleteQuery(stmt, delSql))
				return true;
			else {
				return false;
			}
		}
}
