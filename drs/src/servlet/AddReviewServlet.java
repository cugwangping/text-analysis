package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.*;

/**
 * Servlet implementation class AddReviewServlet
 */
@WebServlet(description = "用户进行评论", urlPatterns = { "/AddReviewServlet" })
public class AddReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String reviewID = request.getParameter("reviewID");		//获取评论ID
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");	//获取评论用户
		//获取用户ID
		String userID = new UserDao().findUserID(username);
		String businessname = request.getParameter("businessname");	//获取被评论的酒店
		String businessID = new BusinessDao().findBusinessID(businessname);
		String stars = request.getParameter("stars");	//获取评论星级
		Date dt = new Date(System.currentTimeMillis());
		String content = request.getParameter("content");		//获取评论内容
		ReviewDao vd = new ReviewDao();
		String insertSql = "insert into review(review_id, user_id, business_id, stars, date, content)"
				+ " values('" + reviewID + "', '" + userID + "', '" + businessID + "', " + stars
				+ ", '" + dt + "', '" + content +"');";
		if(vd.addReview(insertSql)){
			request.setAttribute("msg", "恭喜："+"，成功评论该酒店");  
	        request.getRequestDispatcher("/manager/review/addsuccess.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "恭喜："+"，提交评论失败");  
	        request.getRequestDispatcher("/manager/review/addfailed.jsp").forward(request, response);
		}
	}

}
