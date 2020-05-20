package usuarios;

public class Projeto {
	
	private int id;
	private String nome;
	private String email;
	private String descricao;
	private String link;
	private double preco;
	private String linguagem;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getLinguagem() {
		return linguagem;
	}
	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
	
	@Override
	public String toString() {
		return "Projeto [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao + ", link="
				+ link + ", preco=" + preco + ", linguagem=" + linguagem + "]";
	}
	
	
}
