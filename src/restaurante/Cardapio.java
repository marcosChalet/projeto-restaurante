package restaurante;

import java.util.ArrayList;
import java.util.List;

public class Cardapio {
	private int id;
	private String descricao;

	private List<Produto> produtos;
	
	public Cardapio() {
		produtos = new ArrayList<Produto>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProduto(Produto produto) {
		this.produtos.add(produto);
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return  "Id:        " + id + 
				"\nDescrição: " + descricao;
	}
}
