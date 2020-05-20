package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import usuarios.Empresa;
import usuarios.Projeto;
import usuarios.Usuario;

public class UsuarioDAO {

	// USUARIO

	public void criar(Usuario usuario) {

		String sqlInsert = "INSERT INTO usuarios(nome, senha, email) VALUES (?, ?, ?)";

		try (Connection conn = conexao.ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, usuario.getNome());
			stm.setString(2, usuario.getSenha());
			stm.setString(3, usuario.getEmail());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Usuario cliente) {

		String sqlUpdate = "UPDATE usuarios SET nome=?, imagens=? WHERE email=?";

		try (Connection conn = conexao.ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getImagem());
			stm.setString(3, cliente.getEmail());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(String email) {

		String sqlDelete = "DELETE FROM usuarios WHERE email = ?";

		try (Connection conn = conexao.ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setString(1, email);
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Usuario carregar(Usuario usuario) {

		String sqlSelect = "SELECT nome, senha, imagens FROM usuarios WHERE email = ? and senha = ?";

		try (Connection conn = conexao.ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, usuario.getEmail());
			stm.setString(2, usuario.getSenha());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setNome(rs.getString("nome"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setEmail(usuario.getEmail());
					usuario.setImagem(rs.getString("imagens"));
				} else {
					usuario.setEmail("");
					usuario.setNome("");
					usuario.setSenha("");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}

	public Usuario carregar(String email) {

		Usuario usuario = new Usuario();
		String sqlSelect = "SELECT nome, senha, imagens FROM usuarios WHERE email = ?";

		try (Connection conn = conexao.ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, email);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					usuario.setNome(rs.getString("nome"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setEmail(usuario.getEmail());
					usuario.setImagem(rs.getString("imagens"));
				} else {
					usuario.setEmail("");
					usuario.setNome("");
					usuario.setSenha("");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return usuario;
	}

	public ArrayList<Usuario> carregarTodos() {

		String sqlSelect = "SELECT nome, imagens FROM usuarios";
		ArrayList<Usuario> lista = new ArrayList<>();

		try (Connection conn = conexao.ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Usuario usuario = new Usuario();
					usuario.setNome(rs.getString("nome"));
					usuario.setImagem(rs.getString("imagens"));
					lista.add(usuario);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	// EMPRESA

	public String criarEmpresa(Empresa empresa) {

		String sqlInsert = "INSERT INTO empresa(nomeEmpresa, senha, emailContato, FoneContato, cnpj) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = conexao.ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, empresa.getNome());
			stm.setString(2, empresa.getSenha());
			stm.setString(3, empresa.getEmail());
			stm.setString(4, empresa.getFone());
			stm.setString(5, empresa.getCnpj());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					empresa.setEmail(rs.getString(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empresa.getCnpj();
	}

	public Empresa carregarEmpresa(Empresa empresa) {

		String sqlSelect = "SELECT nomeEmpresa, senha, emailContato, foneContato FROM empresa WHERE cnpj = ? and senha = ?";

		try (Connection conn = conexao.ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, empresa.getCnpj());
			stm.setString(2, empresa.getSenha());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					empresa.setNome(rs.getString("nomeEmpresa"));
					empresa.setSenha(rs.getString("senha"));
					empresa.setCnpj(empresa.getCnpj());
					empresa.setFone(rs.getString("foneContato"));
					empresa.setEmail(rs.getString("emailContato"));
				} else {
					empresa.setEmail("");
					empresa.setNome("");
					empresa.setSenha("");
					empresa.setFone("");
					empresa.setCnpj("");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return empresa;
	}

	public void criarProjeto(Projeto projeto) {

		String sqlInsert = "INSERT INTO projetos(nome, descricao, link, linguagem, preco, emailUsuario) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection conn = conexao.ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, projeto.getNome());
			stm.setString(2, projeto.getDescricao());
			stm.setString(3, projeto.getLink());
			stm.setString(4, projeto.getLinguagem());
			stm.setDouble(5, projeto.getPreco());
			stm.setString(6, projeto.getEmail());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Projeto> carregarTodosProjetos() {

		String sqlSelect = "SELECT nome, emailUsuario, id, link, descricao, preco, linguagem FROM projetos";
		ArrayList<Projeto> lista = new ArrayList<>();

		try (Connection conn = conexao.ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Projeto projeto = new Projeto();
					projeto.setNome(rs.getString("nome"));
					projeto.setEmail(rs.getString("emailUsuario"));
					projeto.setId(rs.getInt("id"));
					projeto.setLink(rs.getString("link"));
					projeto.setPreco(rs.getDouble("preco"));
					projeto.setDescricao(rs.getString("descricao"));
					projeto.setLinguagem(rs.getString("linguagem"));
					lista.add(projeto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public ArrayList<Projeto> carregarTodosProjetos(String email) {

		String sqlSelect = "SELECT * FROM projetos WHERE emailUsuario = ?";
		ArrayList<Projeto> lista = new ArrayList<>();

		try (Connection conn = conexao.ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, email);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Projeto projeto = new Projeto();
					projeto.setEmail(email);
					projeto.setNome(rs.getString("nome"));
					projeto.setId(rs.getInt("id"));
					projeto.setLink(rs.getString("link"));
					projeto.setPreco(rs.getDouble("preco"));
					projeto.setDescricao(rs.getString("descricao"));
					projeto.setLinguagem(rs.getString("linguagem"));
					lista.add(projeto);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}

	public Projeto carregarProjeto(int id) {

		String sqlSelect = "SELECT * FROM projetos WHERE id = ?;";
		Projeto projeto = new Projeto();
		try (Connection conn = conexao.ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					projeto.setNome(rs.getString("nome"));
					projeto.setEmail(rs.getString("emailUsuario"));
					projeto.setLink(rs.getString("link"));
					projeto.setPreco(rs.getDouble("preco"));
					projeto.setDescricao(rs.getString("descricao"));
					projeto.setLinguagem(rs.getString("linguagem"));
					projeto.setId(id);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return projeto;
	}

	public void excluirProjeto(int id) {

		String sqlSelect = "delete FROM projetos WHERE id = ?;";
		try (Connection conn = conexao.ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
	}

	public void alterarProjeto(Projeto projeto) {
		
		String sqlSelect = "update projetos SET nome = ?, linguagem = ?, link = ?, preco = ?, descricao = ? WHERE id = ?;";
		try (Connection conn = conexao.ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, projeto.getNome());
			stm.setString(5, projeto.getDescricao());
			stm.setString(3, projeto.getLink());
			stm.setString(2, projeto.getLinguagem());
			stm.setDouble(4, projeto.getPreco());
			stm.setInt(6, projeto.getId());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}