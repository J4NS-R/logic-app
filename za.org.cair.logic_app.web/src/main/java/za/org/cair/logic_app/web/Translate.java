package za.org.cair.logic_app.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

// Code for this endpoint adapted from https://dzone.com/articles/develop-a-rest-api-using-java-and-jetty
@WebServlet(name = "TranslateServlet", urlPatterns = {"translate"}, loadOnStartup = 1)
public class Translate extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		String input = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		// String inputText = request.getParameter("inputText");
        response.getWriter().print("Hello");
        response.getWriter().print(input);
    }
    
}