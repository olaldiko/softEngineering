package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginServiceFacade;
import model.User;
import model.UserDAOFactory;

public class LoginServlet extends BaseServlet { 
	public final static String PAGE_CONTENT = "welcome.jsp";
	public final static String PAGE_SELF = "/index.jsp"; 
	public final static String PAGE_NEXT = "/pages/private.jsp"; 
	public final static String PAGE_ERROR = "/pages/crossSiteError.jsp";//"/pages/error.jsp";

	@Override
	protected void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.login(req, resp);
	}

	/**
     * Process the specified HTTP request for <strong>connecter</strong> event.
     * @param req The HTTP request we are processing
     * @param resp The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Codigo para la vista
		setReturnPage(  PAGE_NEXT );
		setContentPage( PAGE_CONTENT);
		//Codigo logica
		int tipo = -1;
		
		User user = new User();
		user.setUserName( (String)req.getParameter("username") );
		LoginServiceFacade loginService = new LoginServiceFacade();
		loginService.setUserDAO( UserDAOFactory.getUserDAO() );
		
		if ( loginService.login( user.getUserName(), (String)req.getParameter("password")) ){
			//CREATE SESSION ATTRIBUTE.
			tipo = 1;
			System.out.println("Logeado!!");
			HttpSession sesion = req.getSession(true);
			sesion.setAttribute("isLogin", tipo);
			sesion.setAttribute("currentSessionUser", user);
		}else{
			setContentPage( PAGE_ERROR);
		}
		//End of user code		
		dispatch(req, resp);
	}
    
	@Override
	public boolean redirect(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException {
		// TODO Auto-generated method stub
		return false;
	}
}
