package clone;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/clone")
public class ParkingUserController extends HttpServlet{
	// 입차
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ParkingDto parkingDto = mapper.readValue(req.getReader(), ParkingDto.class);
		
		boolean result = ParkingUserDao.getInstance().inCar(parkingDto);
		
		resp.setContentType("application/json");
		resp.getWriter().print(result);
	}
	
	// 개별조회
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int carNum = Integer.parseInt(req.getParameter("carNum"));
		ParkingDto parkingDto = ParkingUserDao.getInstance().printByid(carNum);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(parkingDto);
		resp.setContentType("application/json");
		resp.getWriter().print(jsonString);
	}
	
	
	
	// 출차(주차상태 변경) / 결제
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String carNum = req.getParameter("carNum");
		System.out.println(carNum);
		boolean result = ParkingUserDao.getInstance().outCar(carNum);
		
		resp.setContentType("text/plain");
		resp.getWriter().print(result);
		
	}
}


