package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import usuarios.Usuario;

/**
 * Servlet implementation class Registrar
 */
@WebServlet("/RegistrarCliente.do")
public class RegistrarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String senha2 = request.getParameter("senha2");
		String nome = request.getParameter("nome");
		String imagem = "http://ssl.gstatic.com/accounts/ui/avatar_2x.png";
		
		if (senha.equals(senha2)) {

			// Cria usuario a
			
			Usuario a = new Usuario();
			a.setEmail(email);
			
			// Cria usuario b
			
			Usuario b = new Usuario();
			
			// Preenche b
			
			UsuarioDAO login = new UsuarioDAO();
			
			b = login.carregar(a);
			
			// Se email de b for diferente do email de a
			
			if (!b.getEmail().equals(a.getEmail())) {
				
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
				
			} else {
				
				a.setEmail(email);
				a.setSenha(senha);
				a.setNome(nome);
				a.setImagem(imagem);
				login.criar(a);

				request.setAttribute("a", a);
				RequestDispatcher rd = request.getRequestDispatcher("Perfil.jsp");
				rd.forward(request, response);

			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
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
