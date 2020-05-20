package test;

import usuarios.Usuario;

import javax.swing.JOptionPane;

import dao.UsuarioDAO;

public class Teste {

	public static void main(String[] args) {
		
		String email = "rozeronii@gmail.com";
		
		Usuario jorge = new Usuario();
		
		jorge.setEmail(email);
		jorge.setSenha("KKKK");
		
		UsuarioDAO B = new UsuarioDAO();
		B.criar(jorge);
		
		jorge = B.carregar(jorge);
		
		JOptionPane.showMessageDialog(null, "nome: " + jorge.getNome() + "\n" + "email: " + jorge.getEmail() + "\n" + "senha: " + jorge.getSenha() + "\n");
		
	}
}