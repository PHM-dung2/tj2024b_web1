package clone;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/clone/admin")
public class ParkingAdminController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GET OKKKKK");
		ArrayList<ParkingDto> result = ParkingAdminDao.getInstance().findAll();
		ObjectMapper mapper = new ObjectMapper();
		String jsonResult = mapper.writeValueAsString(result);
		resp.setContentType("application");
		resp.getWriter().print(jsonResult);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DELETE OKKKKK");
		int cno = Integer.parseInt(req.getParameter("cno"));
		boolean result = ParkingAdminDao.getInstance().delete(cno);
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}

}
