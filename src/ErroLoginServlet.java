import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErroLoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter	out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='https://www.w3schools.com/w3css/4/w3.css'>");
		out.println("<title>");
		out.println("Pronto");
		out.println("</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<header class='w3-container w3-red'>");
		out.println("<h1>");
		out.println("ERRO");
		out.println("</h1>");
		out.println("</header>");
		
		out.println("<div class= 'w3-center w3-margin-top w3-display-middle'>");
		out.println("<h1>");
		out.println("LOGIN OU SENHA INVÁLIDO");
		out.println("</h1>");
		out.println("</div>");
		
		out.println("</body>");
		out.println("</html>");	
	}

}
