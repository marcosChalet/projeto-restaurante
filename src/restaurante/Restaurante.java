package restaurante;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
	private int id;
	private String endereco;
	private String nome;
	private String descricao;
	private List<Pessoas> clientes;
	private List<Cardapio> cardapios;
	
	public Restaurante() {
		clientes = new ArrayList<Pessoas>();
		cardapios = new ArrayList<Cardapio>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<Pessoas> getClientes() {
		return clientes;
	}
	public void setCliente(Pessoas cliente) {
		this.clientes.add(cliente);
	}
	public List<Cardapio> getCardapios() {
		return cardapios;
	}
	public void setCardapio(Cardapio cardapio) {
		this.cardapios.add(cardapio);
	}
}
