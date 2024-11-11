package dioBanco;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Correte ===");
		imprimirInfosComuns();
	}
	
	public void imprimirHistoricoTransacoes() {
		System.out.println("Histórico de Trasnsações Conta Correte:");
		imprimirInfosComunsHistorico();
	}

}
