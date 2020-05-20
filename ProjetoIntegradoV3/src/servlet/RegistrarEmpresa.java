package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import usuarios.Empresa;

/**
 * Servlet implementation class LoginEmpresa
 */
@WebServlet("/RegistrarEmpresa.do")
public class RegistrarEmpresa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("emailEmpresa");
		String senha = request.getParameter("senhaEmpresa");
		String senha2 = request.getParameter("senha2Empresa");
		String nome = request.getParameter("nomeEmpresa");
		String cnpj = request.getParameter("cnpjEmpresa");
		String fone = request.getParameter("foneEmpresa");

		if (senha.equals(senha2)) {

			// Cria usuario a
			
			Empresa a = new Empresa();
			a.setCnpj(cnpj);
			
			// Cria usuario b
			
			Empresa b = new Empresa();
			
			// Preenche b
			
			UsuarioDAO login = new UsuarioDAO();
			
			b = login.carregarEmpresa(a);
			
			// Se email de b for diferente do email de a
			
			if (!b.getCnpj().equals(a.getCnpj())) {
				
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
				
			} else {
				
				a.setEmail(email);
				a.setSenha(senha);
				a.setNome(nome);
				a.setCnpj(cnpj);
				a.setFone(fone);
				login.criarEmpresa(a);
				a = login.carregarEmpresa(a);

				request.setAttribute("a", b);
				RequestDispatcher rd = request.getRequestDispatcher("Perfil.jsp");
				rd.forward(request, response);

			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
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
