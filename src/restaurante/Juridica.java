package restaurante;

public class Juridica extends Pessoas{
	private String cnpj;
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nCnpj:     " + cnpj + "\n";
	}
}
