package dioBanco;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupanca ===");
		imprimirInfosComuns();
	}
	
	public void imprimirHistoricoTransacoes() {
		System.out.println("Histórico de Trasnsações Conta Poupança:");
		imprimirInfosComunsHistorico();
	}
	
}
