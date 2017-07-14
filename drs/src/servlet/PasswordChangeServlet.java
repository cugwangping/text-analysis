package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

/**
 * Servlet implementation class IDConfirmServlet
 */
@WebServlet(name = "PasswordChangeServlet", description = "change password", urlPatterns = { "/PasswordChangeServlet" })
public class PasswordChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PasswordChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=(String)request.getSession().getAttribute("username");
		if(username==null){
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		request.setCharacterEncoding("utf-8");  
        response.setContentType("text/html;charset=utf-8");  
        String password = request.getParameter("password");  
        String passwordAgain = request.getParameter("passwordAgain");
        if(password==null||password.trim().isEmpty()){  
        	request.setAttribute("msg", "请登录");
        	request.setAttribute("msg", "密码不能为空");  
            request.getRequestDispatcher("/chpasswd.jsp").forward(request, response);  
            return;  
        }  
        if(!password.equals(passwordAgain)){  
            request.setAttribute("msg", "两次输入的密码不同");  
            request.getRequestDispatcher("/chpasswd.jsp").forward(request, response);  
            return;  
        }  
        UserDao u = new UserDao();  
        String strSql = "update user set password='" + password + "' where name='" + username + "';";
        if(u.updatePassword(strSql)){
        	//调用addUser（）方法  
        	HttpSession session = request.getSession(false);//防止创建Session  
            if(session == null){  
            	request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;  
            }  
              
            session.removeAttribute("username");  
        	request.setAttribute("msg", "恭喜："+username+"，密码更新成功");  
            request.getRequestDispatcher("/manager/user/chpwdsuccess.jsp").forward(request, response);
        }else{
        	request.setAttribute("msg", "很遗憾："+username+"，密码修改失败");  
            request.getRequestDispatcher("/manager/user/chpwdfailed.jsp").forward(request, response);
        }
        
	}

}
