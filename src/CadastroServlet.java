import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws IOException{
		
	PrintWriter	out = response.getWriter();
	
	out.println("<html>");
	out.println("<head>");
	out.println("<link rel='stylesheet'href='https://www.w3schools.com/w3css/4/w3.css'>");
	out.println("<title>");
	out.println("Cadastro de Usuário");
	out.println("</title>");
	out.println("</head>");
	
	out.println("<body>");
	out.println("<header class='w3-container w3-black'>");
	out.println("<h1>");
	out.println("Cadastro");
	out.println("</h1>");
	out.println("</header>");
	
	out.println("<div class= 'w3-display-middle w3-half w3-margin-top' style='height:600px'>");
	out.println("<form class='w3-container w3-card-4' method='POST' >"); 

	out.println("NOME ");
	out.println("<input class='w3-input' type='text' name='txtNome' style='width:90%' required");
	out.println("<br>");
	
	out.println("E-MAIL ");
	out.println("<input class='w3-input' type='text' name='txtEmail' style='width:90%' required>");
	out.println("<br>");
	
	out.println("DATA DE NASCIMENTO ");
	out.println("<input class='w3-input' type='date' name='txtData' style='width:90%' required>");
	out.println("<br>");
	
	out.println("LOGIN ");
	out.println("<input class='w3-input' type='text' name='txtLogin' style='width:90%'required>");
	out.println("<br>");
	
	out.println("SENHA ");
	out.println("<input class='w3-input' type='password' name='txtSenha'style='width:90%' required>");
	out.println("<br>");

	out.println("<input class='w3-button w3-section w3-black w3-ripple' type='submit' value='CADASTRAR'>");
	
		
	out.println("</body>");
	out.println("</html>");	
	
		
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
	
		PrintWriter out = response.getWriter();		
		
		try {
			
			String nome = request.getParameter("txtNome");
			String email = request.getParameter("txtEmail");
			String idade = request.getParameter("txtData");
			String login = request.getParameter("txtLogin");
			String senha = request.getParameter("txtSenha");
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
			String SQL = "INSERT INTO new_table(nome, email, idade, login, senha)VALUES(?,?,?,?,?);";
			
			
			try {
			
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scc","root","");
				PreparedStatement pstm = conn.prepareStatement(SQL); 
			
				pstm.setString(1,nome);
				pstm.setString(2,email);				
				pstm.setString(3,idade);
				pstm.setString(4,login);
				pstm.setString(5,senha);
				
				
				pstm.execute();
				pstm.close();
				conn.close();
				
				response.sendRedirect("http://localhost:8080/ex_bnc/Login");
			
			} catch (SQLException e) {
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
				out.println("ERRO DE CADASTRO / USUARIO JÁ EXISTENTE");
				out.println("</h1>");
				out.println("</div>");
				
				out.println("</body>");
				out.println("</html>");
			} 
			
		
		} catch (ClassNotFoundException ex) {			
			out.println("Erro de conexão com o Driver");
		}		
		
	}
	
}

