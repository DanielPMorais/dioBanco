package dioBanco;

import java.util.ArrayList;
import java.util.List;

public abstract class ContaHolderBase {
	protected List<Conta> contas;

	public ContaHolderBase() {
		this.contas = new ArrayList<>();
	}
	
    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public List<Conta> getContas() {
        return contas;
    }
	
}
