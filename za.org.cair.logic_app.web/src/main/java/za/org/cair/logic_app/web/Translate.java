package za.org.cair.logic_app.web;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Injector;

import za.org.cair.logic_app.LogicLangStandaloneSetup;
import za.org.cair.logic_app.generator.Main;


// Code for this endpoint adapted from https://dzone.com/articles/develop-a-rest-api-using-java-and-jetty
@WebServlet(name = "TranslateServlet", urlPatterns = {"translate"}, loadOnStartup = 1)
public class Translate extends HttpServlet {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
		String input = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		File inputFile = new File("inputFile.logic");
		inputFile.createNewFile();
		FileWriter fileWriter = new FileWriter("inputFile.logic");
		fileWriter.write(input);
		fileWriter.close();
        response.getWriter().print(Main.generateToStringFromFile("inputFile.logic"));
    }
    
}