package restaurante;

public class Produto {
	private String descricao;
	private Double valor;
	private String imagem;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	@Override
	public String toString() {
		return  "Descrição: " + descricao +
				"\nValor:     R$ " + valor +
				"\nImagem:    " + imagem + "\n";
	}
}
