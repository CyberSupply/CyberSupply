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
 * Servlet implementation class AlterarProjeto
 */
@WebServlet("/AlterarProjeto.do")
public class AlterarProjeto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String senha = (String) session.getAttribute("senha");
		int id = (int) session.getAttribute("id");
		boolean logado = (boolean) session.getAttribute("logado");
		String nome = request.getParameter("nome");
		String linguagem = request.getParameter("linguagem");
		String descricao = request.getParameter("descricao");
		String link = request.getParameter("link");
		double preco = Double.parseDouble(request.getParameter("preco"));
		
		if(logado) {
			
			usuario.setLogado(logado);
			UsuarioDAO dao = new UsuarioDAO();
			usuario = dao.carregar(email);
			usuario.setLogado(true);
			usuario.setEmail(email);
			
		}
		
		Projeto projeto = new Projeto();
		projeto.setId(id);
		projeto.setEmail(email);
		projeto.setDescricao(descricao);
		projeto.setNome(nome);
		projeto.setLinguagem(linguagem);
		projeto.setPreco(preco);
		projeto.setLink(link);
		
		UsuarioDAO dao = new UsuarioDAO();
		
		dao.alterarProjeto(projeto);
		
		session.setAttribute("senha", senha);
		session.setAttribute("email", email);
		session.setAttribute("logado", logado);
		request.setAttribute("a", usuario);
		request.setAttribute("b", usuario);
		request.setAttribute("projeto", projeto);
		RequestDispatcher rd = request.getRequestDispatcher("Projeto.jsp");
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
