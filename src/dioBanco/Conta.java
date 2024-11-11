package dioBanco;

import java.util.ArrayList;
import java.util.List;

import exceptions.SaldoInsuficienteException;

public abstract class Conta implements IConta {
	
	private static int SEQUENCIAL = 1;
	private static final int AGENCIA_PADRAO = 1;
	 
	protected Integer agencia;
	protected Integer numero;
	protected double saldo;
	protected Cliente cliente;
	protected List<Transacao> historicoTransacoes;

	public Conta(Cliente cliente) {
		this.agencia = AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.cliente.adicionarConta(this);
		this.historicoTransacoes = new ArrayList<>();
	}
	
	public void sacar(double valor) throws SaldoInsuficienteException {
		if(valor > saldo) {
			throw new SaldoInsuficienteException("Saldo insuficiente para realizar o saque.");
		}
		saldo -= valor;
		
		Transacao transacao = new Transacao("Saque", valor);
		historicoTransacoes.add(transacao);
		
	}
	
	public void depositar(double valor) {
		saldo += valor;
		
		Transacao transacao = new Transacao("Depósito", valor);
		historicoTransacoes.add(transacao);
	}
	
	public void transferir(double valor, IConta contaDestino) throws SaldoInsuficienteException {
		if(valor > saldo) {
			throw new SaldoInsuficienteException("Saldo insuficiente para realizar a transferencia.");
		}
		this.sacar(valor);
		contaDestino.depositar(valor);
		
		Transacao transacao = new Transacao("Transferência", valor);
		historicoTransacoes.add(transacao);
	}
	
	public List<Transacao> getHistoricoTransacoes(){
		return historicoTransacoes;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	protected void imprimirInfosComunsHistorico() {
		for(Transacao transacao : historicoTransacoes) {
			System.out.println(transacao);
		}
	}
	
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	
}
