package clone;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/clone2")
public class ParkingUserController2 extends HttpServlet{
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ParkingDto parkingDto = mapper.readValue(req.getReader(), ParkingDto.class);
		
		boolean result = ParkingUserDao.getInstance().serchCar(parkingDto);
		
		resp.setContentType("application/json");
		resp.getWriter().print(result);
		
	}
}


















