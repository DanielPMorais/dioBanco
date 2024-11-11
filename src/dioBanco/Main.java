package dioBanco;

import exceptions.ContaInvalidaException;
import exceptions.SaldoInsuficienteException;

public class Main {
	
	public static void main(String[] args) {
		
		Banco banco = Banco.getInstance();
		
		try {
            @SuppressWarnings("unused")
			Conta conta = banco.buscarConta("123456");
        } catch (ContaInvalidaException e) {
            System.out.println(e.getMessage());
        }
		
		Cliente cliente1 = new Cliente("Daniel");
		
		Conta contaCorrente = new ContaCorrente(cliente1);
		Conta contaPoupanca = new ContaPoupanca(cliente1);
		
		contaCorrente.depositar(120);
		try {
			contaCorrente.transferir(10, contaPoupanca);
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
		try {
			contaCorrente.sacar(100);
		} catch (SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
		
		
		contaCorrente.imprimirExtrato();
		contaPoupanca.imprimirExtrato();
		
		contaCorrente.imprimirHistoricoTransacoes();
		contaPoupanca.imprimirHistoricoTransacoes();
//		System.out.println("Contas de " + cliente1.getNome() + ":");
//        for (Conta conta : cliente1.getContas()) {
//            conta.imprimirInfosComuns();
//        }
	}

}
