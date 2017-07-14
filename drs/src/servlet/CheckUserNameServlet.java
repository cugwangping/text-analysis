package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class CheckUserNameServlet
 */
@WebServlet(description = "check user name", urlPatterns = { "/CheckUserNameServlet" })
public class CheckUserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUserNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest request,HttpServletResponse resp) throws IOException
	{
		String username = request.getParameter("username");
		PrintWriter out = resp.getWriter();
		boolean flag = false;
		String psw =new UserDao().findUserName(username);
		if(psw==null)
			flag = true;
		out.print(flag);
		out.flush();
		out.close();
	}

}
