package id.ac.unsyiah.jte.mobile;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Entity;


@SuppressWarnings("serial")
public class DaftarServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, 
					  HttpServletResponse resp)
			throws IOException, ServletException{
		
		Query query = new Query("DataSaya");
		DatastoreService data = DatastoreServiceFactory.getDatastoreService();
		PreparedQuery preQuery = data.prepare(query);
		FetchOptions fetchOption = FetchOptions.Builder.withOffset(0);
		List<Entity> daftarNama = preQuery.asList(fetchOption);
		List<Entity> daftarNim = preQuery.asList(fetchOption);	
		
		req.setAttribute("daftarNama", daftarNama);
		req.setAttribute("daftarNim", daftarNim);
		resp.setContentType("text/plain");
		RequestDispatcher jsp = req.getRequestDispatcher("listnama.jsp");
		jsp.forward(req, resp);
	}
}
