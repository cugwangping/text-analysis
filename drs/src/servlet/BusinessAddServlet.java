package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BusinessDao;

/**
 * Servlet implementation class BusinessAddServlet
 */
@WebServlet(description = "add business", urlPatterns = { "/BusinessAddServlet" })
public class BusinessAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String businessID = request.getParameter("businessID");		//获取ID
		String businessname = request.getParameter("businessname");	//获取名称
		String address = request.getParameter("address");	//获取地址
		String province = request.getParameter("province");	//获取省份
		String city = request.getParameter("city");		//获取市区
		String stars = request.getParameter("stars");	//获取酒店星级
		String status = request.getParameter("status");	//获取酒店状态
		String categories = request.getParameter("categories");	//获取酒店特色信息
		BusinessDao bd = new BusinessDao();
		String insertSql = "insert into business(business_id, name, address, city, state, stars, "
				+ "status, categories) values('" + businessID + "', '" + businessname + "', '" + address + "', '" + city
				+ "', '" + province + "', " + stars +", '" + status + "', '" + categories +"');";
		if(bd.addBusiness(insertSql)){
			request.setAttribute("msg", "恭喜："+"，添加酒店成功");  
	        request.getRequestDispatcher("/manager/business/addsuccess.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "很遗憾："+"，添加酒店失败");  
	        request.getRequestDispatcher("/manager/business/addfailed.jsp").forward(request, response);
		}
	}
}
