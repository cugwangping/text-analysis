package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(description = "register user on the web", urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8");  
        String userID = request.getParameter("userID");
        String username = request.getParameter("username");  
        //String email = request.getParameter("email");
        String password = request.getParameter("password");  
        String rpsw = request.getParameter("againpassword");//得到表单输入的内容  
        if(username==null||username.trim().isEmpty()){  
            request.setAttribute("msg", "帐号不能为空");  
            request.getRequestDispatcher("/register.jsp").forward(request, response);  
            return;  
        }  
        if(password==null||password.trim().isEmpty()){  
            request.setAttribute("msg", "密码不能为空");  
            request.getRequestDispatcher("/register.jsp").forward(request, response);  
            return;  
        }  
        if(!password.equals(rpsw)){  
            request.setAttribute("msg", "两次输入的密码不同");  
            request.getRequestDispatcher("/register.jsp").forward(request, response);  
            return;  
        }  
        UserDao u = new UserDao();  
        //注册日期
        Date dt = new Date(System.currentTimeMillis());
        String strSql = "insert into user(user_id, name, password, yelping_since) values('" + userID
        		+ "', '" + username + "', '" + password + "', '" + dt + "');";
        if(u.addUser(strSql)){
        	//调用addUser（）方法 
        	request.setAttribute("msg", "恭喜："+username+"，注册成功");  
            request.getRequestDispatcher("/manager/user/addsuccess.jsp").forward(request, response);
        }else{
        	request.setAttribute("msg", "恭喜："+username+"，注册失败");  
            request.getRequestDispatcher("/manager/user/addfailed.jsp").forward(request, response);
        }
        	
	}
}
