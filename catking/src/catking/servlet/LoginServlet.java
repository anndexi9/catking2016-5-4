package catking.servlet;

import catking.dao.DAOException;
import catking.dao.MemSysDAO;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    	String action = request.getParameter("action");
    	
    	if (action.equals("login")){
    	try{
        
    		String user = request.getParameter("uname");
    		String pwd = request.getParameter("pw");
    		MemSysDAO dao = new MemSysDAO(); 
        
        if ((dao.validLogin(user,pwd))==true){
        	
        	HttpSession session = request.getSession();
        	session.setAttribute("loggedIn", "true");
        	session.setAttribute("username", user);
        	
            request.setAttribute("username", user);
            gotoPage(request, response, "/catking/loginSuccess.jsp");
        }else{
        request.setAttribute("msg", "ご入力したユーザネームまたパスワードが有効ではありません。");
        gotoPage(request, response, "/catking/login.jsp");}
    	}
    	catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/catking/errInternal.jsp");
		}}else if (action.equals("logout")){
            HttpSession session = request.getSession(false);
            if (session != null)
            	session.invalidate();
            
    		request.setAttribute("msg", "ログアウトしました。");
            gotoPage(request, response, "/catking/login.jsp");}
        
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
