package restaurante;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pessoas {
	private int id;
	private String nome;
	private String email;
	private String senha;
	private Date dataNascimento;
	private String telefone;
	private String cidade;
	private List<Pedidos> pedidos;
	SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");

	Pessoas() {
		pedidos = new ArrayList<Pedidos>();
	}
	
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public List<Pedidos> getPedidos() {
		return pedidos;
	}
	public void setPedido(Pedidos pedido) {
		this.pedidos.add(pedido);
	}
	
	@Override
	public String toString() {
		return  "Id:       " + id     +
				"\nNome:     " + nome   +
			    "\nEmail:    " + email  +
			    "\nSenha:    " + senha  +
			    "\nData:     " + f.format(dataNascimento) +
			    "\nCidade:   " + cidade +
			    "\nTelefone: " + telefone;
	}
}
