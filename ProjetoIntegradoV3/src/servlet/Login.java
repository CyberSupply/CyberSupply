package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import usuarios.Empresa;
import usuarios.Projeto;
import usuarios.Usuario;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String emailCNPJ = request.getParameter("email/cnpj");
		String senha = request.getParameter("senha");
		
		HttpSession session = request.getSession();
		
		// instanciar o javabean
		Usuario a = new Usuario();
		a.setEmail(emailCNPJ);
		a.setSenha(senha);

		// DAO
		UsuarioDAO login = new UsuarioDAO();
		Usuario c = new Usuario();
		c = login.carregar(a);
		
		String x = a.getNome();
		
		if (x.equals("")) {
			
			Empresa b = new Empresa();
			b.setCnpj(emailCNPJ);
			b.setSenha(senha);
			b.setNome("");
			
			b = login.carregarEmpresa(b);
			
			x = b.getNome();
			
			if(x.equals("")) {
				
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
				
			}else {
				
				session.setAttribute("email", emailCNPJ);
				session.setAttribute("senha", senha);
				session.setAttribute("logado", true);
				
				RequestDispatcher rd = request.getRequestDispatcher("Perfil.jsp");
				request.setAttribute("a", b);
				rd.forward(request, response);
				
			}
		} else {
			
			session.setAttribute("email", emailCNPJ);
			session.setAttribute("senha", senha);
			session.setAttribute("logado", true);
			c.setLogado(true);
			
			RequestDispatcher rd = request.getRequestDispatcher("Perfil.jsp");
			request.setAttribute("a", c);
			rd.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
