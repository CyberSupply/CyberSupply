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
import usuarios.Projeto;
import usuarios.Usuario;

/**
 * Servlet implementation class ChamaProjetos
 */
@WebServlet("/ChamaProjetos.do")
public class ChamaProjetos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		ArrayList<Projeto> Lista = new ArrayList<>();
		UsuarioDAO carregar = new UsuarioDAO();
		Lista = carregar.carregarTodosProjetos();
		
		session.setAttribute("senha", senha);
		session.setAttribute("email", email);
		session.setAttribute("logado", logado);
		request.setAttribute("a", usuario);
		request.setAttribute("lista", Lista);
		RequestDispatcher rd = request.getRequestDispatcher("navegue.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
