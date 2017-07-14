package servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import verify.VerifyCode;

/**
 * Servlet implementation class VerifyCodeServlet
 */
@WebServlet(description = "verify login page's code", urlPatterns = { "/VerifyCodeServlet" })
public class VerifyCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 VerifyCode vc = new VerifyCode();  
	     BufferedImage image = vc.getImage(85,23);//设置验证码图片大小  
	     request.getSession().setAttribute("sessionverify", vc.getText());//将验证码文本保存到session域  
	     VerifyCode.output(image, response.getOutputStream());
	}

}
