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
 * Servlet implementation class CarregaProjetosNoPerfil
 */
@WebServlet("/CarregaProjetosNoPerfil.do")
public class CarregaProjetosNoPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioDAO dao = new UsuarioDAO();
		ArrayList<Projeto> Lista = new ArrayList<>();
		
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String senha = (String) session.getAttribute("senha");
		
		Lista = dao.carregarTodosProjetos(email);
		
		session.setAttribute("email", email);
		session.setAttribute("senha", senha);
		
		request.setAttribute("projeto", Lista);
		RequestDispatcher rd = request.getRequestDispatcher("Login.do?email%2Fcnpj="+email+"&senha="+senha);
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
