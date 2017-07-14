package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BusinessDao;

/**
 * Servlet implementation class BusinessSearchServlet
 */
@WebServlet(description = "查找酒店，分为模糊查找和准确查找", urlPatterns = { "/BusinessSearchServlet" })
public class BusinessSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String search = request.getParameter("search");
		String searchType = request.getParameter("searchType");
		BusinessDao bd = new BusinessDao();
		HttpSession session = request.getSession();
		if("like".equals(searchType)){
			//模糊查找
			String[] likeSearch = search.split(",");
			String queryStr = "";
			if(likeSearch.length > 0){
				queryStr = "SELECT * FROM business WHERE categories like '%" + likeSearch[0] + 
						"%'";
			}
			if(likeSearch.length > 1){
				for(int i=1;i<likeSearch.length;i++){
					queryStr += " and categories like '%" + likeSearch[i] + "%'";
				}
			}
			queryStr += ";";
			//PrintWriter pt = response.getWriter();
			//pt.println(queryStr);
			List<String> result = bd.findByCategory(queryStr);
			session.setAttribute("result", result);  
            request.getRequestDispatcher("/manager/business/businesssearch.jsp").forward(request, response);
			return;
		}
		if("all".equals(searchType)){
			//准确查找查找
			List<String> result = bd.findByBusinessName(search);
			session.setAttribute("result", result);  
			//PrintWriter pt = response.getWriter();
			//pt.println(result);
            request.getRequestDispatcher("/manager/business/businesssearch.jsp").forward(request, response);  
			return;
		}
	}

}
