package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import usuarios.Usuario;

/**
 * Servlet implementation class AlterarTransicao
 */
@WebServlet("/AlterarTransicao.do")
public class AlterarTransicao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario usuario = new Usuario();
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String senha = (String) session.getAttribute("senha");
		boolean logado = (boolean) session.getAttribute("logado");
		
		if(logado) {
			
			usuario.setLogado(logado);
			UsuarioDAO dao = new UsuarioDAO();
			usuario = dao.carregar(email);
			usuario.setLogado(true);
			usuario.setEmail(email);
			
		}
		
		String imagem = usuario.getImagem();
		String nome = usuario.getImagem();
		
		session.setAttribute("nome", nome);
		session.setAttribute("imagem", imagem);
		session.setAttribute("senha", senha);
		session.setAttribute("email", email);
		session.setAttribute("logado", logado);
		RequestDispatcher rd = request.getRequestDispatcher("PerfilAlterar.jsp");
		request.setAttribute("a", usuario);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
