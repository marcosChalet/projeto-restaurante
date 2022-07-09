package restaurante;

import java.util.Date;

public class Fisica extends Pessoas{
	private String cpf;
	
	public void calculaIdade(Date dataNascimento) {
		System.out.println("A data de nascimento ainda será criada");
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nCpf:      " + cpf + "\n";
	}
}
