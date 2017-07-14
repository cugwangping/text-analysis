package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;

/**
 * Servlet implementation class ReviewDelServlet
 */
@WebServlet(description = "删除评论", urlPatterns = { "/ReviewDelServlet" })
public class ReviewDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String del_review_id = request.getParameter("review_id");	//获取需要删除的用户的用户名
		//String path = request.getContextPath();
		ReviewDao vd= new ReviewDao(); 
		if(vd.delReview(del_review_id)){
			request.setAttribute("msg", "评论删除成功!");  
            request.getRequestDispatcher("/manager/review/delsuccess.jsp").forward(request, response);  
            return;  
		}else{
			request.setAttribute("msg", "评论失败成功!");  
            request.getRequestDispatcher("/manager/review/delfailed.jsp").forward(request, response);  
            return; 
		}
	}


}
