package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class UserDelServlet
 */
@WebServlet(description = "delete user except admin", urlPatterns = { "/UserDelServlet" })
public class UserDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDelServlet() {
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
		String delName = request.getParameter("username");	//获取需要删除的用户的用户名
		//String path = request.getContextPath();
		if("admin".equals(delName)){
			request.setAttribute("msg", "管理员用户不可删除!");  
            request.getRequestDispatcher("/manager.jsp").forward(request, response);  
            return;  
		}
		UserDao ud= new UserDao(); 
		if(ud.delUser(delName)){
			request.setAttribute("msg", "用户删除成功!");  
            request.getRequestDispatcher("/manager/user/delsuccess.jsp").forward(request, response);  
            return;  
		}else{
			request.setAttribute("msg", "用户删除失败!");  
            request.getRequestDispatcher("/manager/user/delfailed.jsp").forward(request, response);  
            return; 
		}
	}

}
