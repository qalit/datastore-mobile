package id.ac.unsyiah.jte.mobile;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;


@SuppressWarnings("serial")
public class DataServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, 
					  HttpServletResponse resp)
			throws IOException, ServletException{
		
		resp.setContentType("text/plain");
		RequestDispatcher jsp = req.getRequestDispatcher("nama.jsp");
		jsp.forward(req, resp);
	}
	public void doPost(HttpServletRequest req, 
			  HttpServletResponse resp)
	throws IOException, ServletException{
		String namaMasuk = req.getParameter("txtNama");
		String nimMasuk = req.getParameter("txtNim");
		
		Entity entity = new Entity("DataSaya");
		entity.setProperty("fieldNama", namaMasuk);
		entity.setProperty("fieldNim", nimMasuk);
		
		DatastoreService data = DatastoreServiceFactory.getDatastoreService();
		data.put(entity);
		resp.sendRedirect("/daftar");	
	}
}
