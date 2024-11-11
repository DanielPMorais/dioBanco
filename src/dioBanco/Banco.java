package dioBanco;

import java.util.ArrayList;

import exceptions.ContaInvalidaException;

public class Banco extends ContaHolderBase{
	
	private static Banco instanciaUnica;

	public Conta buscarConta(String numeroConta) throws ContaInvalidaException {
		for(Conta conta : contas) {
			if(conta.getNumero().equals(numeroConta)) {
				return conta;
			}
		}
		throw new ContaInvalidaException("Conta com o número " + numeroConta + " não foi encontrada.");
	}
	
    // Construtor privado impede que a classe seja instanciada diretamente
    private Banco() {
    	contas = new ArrayList<>();
    }

    // Método estático para retornar a instância única
    public static Banco getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new Banco();
        }
        return instanciaUnica;
    }

}
