package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusinessDao;

/**
 * Servlet implementation class BusinessDelServlet
 */
@WebServlet(description = "delete business by name", urlPatterns = { "/BusinessDelServlet" })
public class BusinessDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessDelServlet() {
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
		String delBusinessName = request.getParameter("businessname");	//获取需要删除的用户的用户名
		//String path = request.getContextPath();
		BusinessDao bd= new BusinessDao(); 
		if(bd.delBusiness(delBusinessName)){
			request.setAttribute("msg", "酒店删除成功!");  
            request.getRequestDispatcher("/manager/business/delsuccess.jsp").forward(request, response);  
            return;  
		}else{
			request.setAttribute("msg", "酒店删除失败!");  
            request.getRequestDispatcher("/manager/business/delfailed.jsp").forward(request, response);  
            return; 
		}
	}

}
