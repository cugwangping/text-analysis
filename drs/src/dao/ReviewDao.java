package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbConnection.DBConnection;

public class ReviewDao {
private DBConnection dbConn;
	
	
	//Constructor UserDAO
	public ReviewDao(){
		dbConn = new DBConnection();
	}
	
	 // <method>
	//根据评论的用户查询改用户的所有评论
	public List<String> findByUserName(String userName){
		//String countQuery = "select COUNT(*) FROM review WHERE user_id=(select user_id from user where name='" + userName + "');";
		String queryStr = "SELECT * FROM review WHERE user_id=(select user_id from user where name='"+ userName+"');";
		//System.out.println(queryStr);
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		//ResultSet countRs = dbConn.executeSelectQuery(stmt, countQuery);
		/*int count = 0;
		try {
			if(countRs.next()){
				count = countRs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		ResultSet rs = dbConn.executeSelectQuery(stmt, queryStr);
		List<String> viewInfo = new ArrayList<String>();
		try {	
			while(rs.next()){
				viewInfo.add("评论ID：" + rs.getString(1) + "	酒店ID：" + rs.getString(3) + "		评论星级：" + rs.getInt(4) +
						"★	评论时间：" + rs.getDate(5) + "	内容：" + rs.getString(6));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return viewInfo;
	}
	
	 // <method>
	//查找所有评论
	public String[] findAllReview(){
		String countQuery = "SELECT COUNT(*) FROM user, business, "
				+ "review where review.user_id=user.user_id and review.business_id=business.business_id order by review.date"
				+ " desc;";
		String queryStr = "SELECT review.review_id, review.date, user.name, business.name, review.stars, review.content FROM user, business, "
				+ "review where review.user_id=user.user_id and review.business_id=business.business_id order by review.date"
				+ " desc;";
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
		String[] viewInfo = new String[count];
		for(int i=0; i<count; i++){
			try {
				if(rs.next()){
					viewInfo[i] = "评论ID：" + rs.getString(1) + "	评论时间：" + rs.getDate(2) + "	评论用户：" + rs.getString(3) + "	所评论的酒店："
				+ rs.getString(4) + "	评论星级：" + rs.getInt(5) + "★	评论内容：" + rs.getString(6);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return viewInfo;
	}
	
	// <method>
	//添加评论
	public boolean addReview(String insertSql){
		Connection conn = dbConn.getConn();
		Statement stmt = dbConn.getStmt(conn);
		if(dbConn.executeInsertQuery(stmt, insertSql))
			return true;
		else {
			return false;
		}
	}
	
	//根据酒店名称删除已关闭的酒店
		public boolean delReview(String delReviewID){
			String delSql = "delete from review where review_id='"+ delReviewID +"';";
			Connection conn = dbConn.getConn();
			Statement stmt = dbConn.getStmt(conn);
			if(dbConn.executeDeleteQuery(stmt, delSql))
				return true;
			else {
				return false;
			}
		}
}
