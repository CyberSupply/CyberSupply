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
import usuarios.Projeto;
import usuarios.Usuario;

/**
 * Servlet implementation class VerProjeto
 */
@WebServlet("/VerProjeto.do")
public class VerProjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		int id = Integer.parseInt(request.getParameter("id"));
		Projeto projeto = new Projeto();
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String senha = (String) session.getAttribute("senha");
		boolean logado = (boolean) session.getAttribute("logado");
		
		if(logado) {
			
			usuario.setLogado(logado);
			usuario = dao.carregar(email);
			usuario.setLogado(true);
			usuario.setEmail(email);
			
		}
		
		
		if(acao.equals("Visualizar")) {
			Usuario b = new Usuario();
			projeto = dao.carregarProjeto(id);
			b = dao.carregar(projeto.getEmail());
			b.setEmail(projeto.getEmail());
			session.setAttribute("senha", senha);
			session.setAttribute("email", email);
			session.setAttribute("logado", logado);
			request.setAttribute("a", usuario);
			request.setAttribute("b", b);
			request.setAttribute("projeto", projeto);
			RequestDispatcher rd = request.getRequestDispatcher("Projeto.jsp");
			rd.forward(request, response);
			
		}else if(acao.equals("verDoNavegue")) {
			
			Usuario b = new Usuario();
			projeto = dao.carregarProjeto(id);
			b = dao.carregar(projeto.getEmail());
			b.setEmail(projeto.getEmail());
			session.setAttribute("senha", senha);
			session.setAttribute("email", email);
			session.setAttribute("logado", logado);
			request.setAttribute("a", usuario);
			request.setAttribute("b", b);
			request.setAttribute("projeto", projeto);
			RequestDispatcher rd = request.getRequestDispatcher("Projeto.jsp");
			rd.forward(request, response);
			
		}else if(acao.equals("Alterar")) {
			
			projeto = dao.carregarProjeto(id);
			
			session.setAttribute("senha", senha);
			session.setAttribute("email", email);
			session.setAttribute("logado", logado);
			session.setAttribute("id", id);
			request.setAttribute("a", usuario);
			request.setAttribute("projeto", projeto);
			RequestDispatcher rd = request.getRequestDispatcher("AlterarProjeto.jsp");
			rd.forward(request, response);
			
		}else if(acao.equals("Excluir")) {
			
			dao.excluirProjeto(id);
			
			RequestDispatcher rd = request.getRequestDispatcher("CarregaProjetosNoPerfil.do?email%2Fcnpj="+email+"&senha="+senha);
			rd.forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
