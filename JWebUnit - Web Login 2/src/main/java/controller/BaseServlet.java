package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {
	protected String returnPage;
	protected String content;
	
	abstract public boolean redirect(HttpServletRequest req, HttpServletResponse resp ) throws ServletException,IOException;
	abstract void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Set to expire far in the past.
		resp.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
		// Set standard HTTP/1.1 no-cache headers.
		resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		resp.addHeader("Cache-Control", "post-check=0, pre-check=0");
		// Set standard HTTP/1.0 no-cache header.
		resp.setHeader("Pragma", "no-cache");
		if ( redirect(req, resp) == false ){
			doAction(req, resp);
		}
		
	}

	/**
     * Process the specified HTTP request for event.
     * @param req The HTTP request we are processing
     * @param resp The HTTP response we are creating
     *
     * @exception Exception if an input/output error or servlet exception occurs
     */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Set to expire far in the past.
		resp.setHeader("Expires", "Sat, 6 May 1995 12:00:00 GMT");
		// Set standard HTTP/1.1 no-cache headers.
		resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).
		resp.addHeader("Cache-Control", "post-check=0, pre-check=0");
		// Set standard HTTP/1.0 no-cache header.
		resp.setHeader("Pragma", "no-cache"); 
		if ( redirect(req, resp) == false ){
			doAction(req, resp);
		}
	}
	
	protected void setReturnPage(String page){
		this.returnPage = page;
		
	}
	
	protected void setContentPage(String page){
		this.content = page;
	}
	
	
	
	protected void dispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setAttribute("content", this.content);
		RequestDispatcher dispatcher = req.getRequestDispatcher( this.returnPage);
		if (dispatcher != null) {
			dispatcher.forward(req, resp);
		} else {
			throw new ServletException("Redirection failed because " + this.returnPage + " hasn't been found");
		}
	}


}
