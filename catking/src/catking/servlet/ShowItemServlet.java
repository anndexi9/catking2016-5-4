package catking.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import catking.bean.ItemBean;
import catking.dao.DAOException;
import catking.dao.ItemDAO;

@WebServlet("/ShowItemServlet")
public class ShowItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			
			ItemDAO dao = new ItemDAO();
			//pagination 
			int page = 1;
	        int recordsPerPage = 10;
	        int offSet=(page-1)*recordsPerPage;
	        
	        int noRecords=0; 
	        
	        if(request.getParameter("page") != null)
	        {     
	        	page = Integer.parseInt(request.getParameter("page"));
	        	offSet=(page-1)*recordsPerPage;
	        }
	        
			String action = request.getParameter("action");
			
			if (action!=null){
				
			//show result by keyword
			if (action.equals("search")){
			String paraV = request.getParameter("txtfield");

			if (paraV == null || paraV.length() == 0) {
				List<ItemBean> list = dao.findAll(offSet,recordsPerPage);
				noRecords= dao.getNoOfRecords();
				request.setAttribute("items", list);
				request.setAttribute("noRecords", noRecords);
			} else if (paraV!= null) {
				List<ItemBean> list = dao.findByKeyword(paraV,offSet,recordsPerPage);
				noRecords= dao.getNoOfRecords();
				request.setAttribute("items", list);
				request.setAttribute("noRecords", noRecords);
			}}
			//show by category
			else if (action.equals("cat")){
				String cat = request.getParameter("cat");
				List<ItemBean> list = dao.findByCategory(cat,offSet,recordsPerPage);
				noRecords= dao.getNoOfRecords();
				request.setAttribute("items", list);
				request.setAttribute("noRecords", noRecords);
			}
			//show by subcatergory
			else if (action.equals("sub")){
				String sub = request.getParameter("cat");
				List<ItemBean> list = dao.findBySubcategory(sub,offSet,recordsPerPage);
				noRecords= dao.getNoOfRecords();
				request.setAttribute("items", list);
				request.setAttribute("noRecords", noRecords);
				}
			// show detail
			else if (action.equals("detail")){
				int item_id = Integer.parseInt(request.getParameter("id"));

				ItemBean bean = dao.findByPrimaryKey(item_id);
				request.setAttribute("item", bean);
				gotoPage(request, response, "/ItemDetail.jsp");
				}
			
	        int noOfPages = (int) Math.ceil(noRecords * 1.0 / recordsPerPage);
			
			request.setAttribute("noOfPages", noOfPages);
	        request.setAttribute("currentPage", page);
			
			gotoPage(request, response, "/ItemList.jsp");
		
			}
			//end action not null
			
			else {
				request.setAttribute("message", "正しく操作してください。");
				gotoPage(request, response, "/errInternal.jsp");
				}

		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/errInternal.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
