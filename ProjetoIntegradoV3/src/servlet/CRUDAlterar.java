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
 * Servlet implementation class CRUDAlterar
 */
@WebServlet("/CRUDAlterar.do")
public class CRUDAlterar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String nome = request.getParameter("nome");
		String imagem = request.getParameter("imagem");
		String acao = request.getParameter("acao");
		
		Usuario usuario = new Usuario();
		HttpSession session = request.getSession();
		String emailManter = (String) session.getAttribute("email");
		String senhaManter = (String) session.getAttribute("senha");
		String nomeManter = (String) session.getAttribute("nome");
		String imagemManter = (String) session.getAttribute("imagem");
		boolean logado = (boolean) session.getAttribute("logado");
		
		if(logado) {
			
			usuario.setLogado(logado);
			UsuarioDAO dao = new UsuarioDAO();
			usuario = dao.carregar(emailManter);
			usuario.setLogado(true);
			usuario.setEmail(emailManter);
			
		}
		Usuario c = new Usuario();

		if (acao.equals("salvar")) {

			if (imagem.equals("") && !nome.equals("")) {

				Usuario a = new Usuario();
				a.setEmail(emailManter);
				a.setNome(nome);
				a.setImagem(imagemManter);
				UsuarioDAO login = new UsuarioDAO();
				login.atualizar(a);
				c.setNome(a.getNome());
				c.setEmail(a.getEmail());
				c.setImagem(a.getImagem());
				session.setAttribute("senha", senhaManter);
				session.setAttribute("email", emailManter);
				session.setAttribute("logado", logado);
				request.setAttribute("a", usuario);
				RequestDispatcher rd = request.getRequestDispatcher("Login.do?email%2Fcnpj="+ emailManter + "&senha=" + senhaManter);
				rd.forward(request, response);
				
			}else if (!imagem.equals("") && nome.equals("")) {

				Usuario a = new Usuario();
				a.setEmail(emailManter);
				a.setNome(nomeManter);
				a.setImagem(imagem);
				UsuarioDAO login = new UsuarioDAO();
				login.atualizar(a);
				c.setNome(a.getNome());
				c.setEmail(a.getEmail());
				c.setImagem(a.getImagem());
				session.setAttribute("senha", senhaManter);
				session.setAttribute("email", emailManter);
				session.setAttribute("logado", logado);
				request.setAttribute("a", usuario);
				RequestDispatcher rd = request.getRequestDispatcher("Login.do?email%2Fcnpj="+ emailManter + "&senha=" + senhaManter);
				rd.forward(request, response);
				
			}else if (!imagem.equals("") && !nome.equals("")) {

				Usuario a = new Usuario();
				a.setEmail(emailManter);
				a.setNome(nome);
				a.setImagem(imagem);
				UsuarioDAO login = new UsuarioDAO();
				login.atualizar(a);
				c.setNome(a.getNome());
				c.setEmail(a.getEmail());
				c.setImagem(a.getImagem());
				session.setAttribute("senha", senhaManter);
				session.setAttribute("email", emailManter);
				session.setAttribute("logado", logado);
				request.setAttribute("a", usuario);
				RequestDispatcher rd = request.getRequestDispatcher("Login.do?email%2Fcnpj="+ emailManter + "&senha=" + senhaManter);
				rd.forward(request, response);
				
			}else if (imagem.equals("") && nome.equals("")) {

				Usuario a = new Usuario();
				a.setEmail(emailManter);
				a.setNome(nomeManter);
				a.setImagem(imagemManter);
				UsuarioDAO login = new UsuarioDAO();
				login.atualizar(a);
				c.setNome(a.getNome());
				c.setEmail(a.getEmail());
				c.setImagem(a.getImagem());
				session.setAttribute("senha", senhaManter);
				session.setAttribute("email", emailManter);
				session.setAttribute("logado", logado);
				request.setAttribute("a", usuario);
				RequestDispatcher rd = request.getRequestDispatcher("Login.do?email%2Fcnpj="+ emailManter + "&senha=" + senhaManter);
				rd.forward(request, response);
				
			}
		} else if (acao.equals("cancelar")) {

			session.setAttribute("senha", senhaManter);
			session.setAttribute("email", emailManter);
			session.setAttribute("logado", logado);
			request.setAttribute("a", usuario);
			RequestDispatcher rd = request.getRequestDispatcher("Login.do?email%2Fcnpj="+ emailManter + "&senha=" + senhaManter);
			rd.forward(request, response);
			
		}else if(acao.equals("excluir")) {
			
			session.setAttribute("senha", senhaManter);
			session.setAttribute("email", emailManter);
			session.setAttribute("logado", logado);
			request.setAttribute("a", usuario);
			RequestDispatcher rd = request.getRequestDispatcher("ConfirmaExclusao.jsp");
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
