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
 * Servlet implementation class CRUDExcluir
 */
@WebServlet("/CRUDExcluir.do")
public class CRUDExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String senha2 = request.getParameter("senha2");
		String acao = request.getParameter("acao");
		Usuario usuario = new Usuario();
		HttpSession session = request.getSession();
		String emailManter = (String) session.getAttribute("email");
		String senhaManter = (String) session.getAttribute("senha");
		boolean logado = (boolean) session.getAttribute("logado");
		
		if(logado) {
			
			usuario.setLogado(logado);
			UsuarioDAO dao = new UsuarioDAO();
			usuario = dao.carregar(emailManter);
			usuario.setLogado(true);
			usuario.setEmail(emailManter);
			
		}
		Usuario c = new Usuario();
		
		if (acao.equals("cancelar")) {
			
			session.setAttribute("senha", senhaManter);
			session.setAttribute("email", emailManter);
			session.setAttribute("logado", logado);
			request.setAttribute("a", usuario);
			RequestDispatcher rd = request.getRequestDispatcher("Login.do?email%2Fcnpj="+emailManter+"&senha="+senhaManter);
			rd.forward(request, response);
			
		}else if(acao.equals("excluir")) {
			
			if (senha.equals(senha2)) {

				// Cria usuario a

				Usuario a = new Usuario();
				a.setEmail(email);

				// Preenche b

				UsuarioDAO login = new UsuarioDAO();

				// Se email de b for diferente do email de a

				if (!a.getEmail().equals(emailManter)) {

					RequestDispatcher rd = request.getRequestDispatcher("Login.do?email%2Fcnpj="+ email + "&senha=" + senha);
					rd.forward(request, response);

				} else {

					login.excluir(email);
					
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);

				}
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("Login.do?email%2Fcnpj="+ email + "&senha=" + senha);
				rd.forward(request, response);
			}
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
