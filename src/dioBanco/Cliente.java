package dioBanco;

import java.util.ArrayList;

public class Cliente extends ContaHolderBase{
	
	private String nome;

	public Cliente(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	
}
