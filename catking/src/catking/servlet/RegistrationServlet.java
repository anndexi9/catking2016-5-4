package catking.servlet;

import catking.bean.CustomerBean;
import catking.dao.DAOException;
import catking.dao.MemSysDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		
		String user = request.getParameter("uname");
        String pw = request.getParameter("pw");
        String email = request.getParameter("email");
        String cus_name = request.getParameter("cus_name");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        
        MemSysDAO dao= new MemSysDAO();
        String Jres;
        response.setContentType("application/json;charset=UTF-8"); 
        PrintWriter out = response.getWriter();
        
        	if (dao.memExist(user,email)==false){
        		
        		dao.regMem(cus_name, email, address, tel, user, pw);
        		
        		CustomerBean bean = dao.getMemInfo(user,email);
				request.setAttribute("mem", bean);
        		gotoPage(request, response, "/catking/regSuccess.jsp");
        		
        	}else {Jres ="{\"memExist\":\"ご入力したユーザネームまたメールはすでに登録されました。\"}";
        	out.print(Jres);
        	}
        
		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/catking/errInternal.jsp");
		}
		
	}
	

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
