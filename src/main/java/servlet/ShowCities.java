package servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CityUtils;
import bean.City;

/**
 * Servlet that uses MVC to send cities
 */
@WebServlet("/show-cities")
public class ShowCities extends HttpServlet {
	private CityUtils util = new CityUtils();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");

		// get the objects from the backend
		Collection<City> cities = util.getCityMap().values();
		// add them to the request
		request.setAttribute("cities", cities);
		String outputPage = "/WEB-INF/results/cities.jsp";
		// include the output page in the response
		RequestDispatcher dispatcher = request.getRequestDispatcher(outputPage);
		dispatcher.include(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
