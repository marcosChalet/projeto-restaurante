package restaurante;

import java.util.ArrayList;
import java.util.List;

public class Pedidos {
	private int id;
	List<Produto> produtos;
	
	public Pedidos() {
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
	
}
