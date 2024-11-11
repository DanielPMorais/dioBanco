package dioBanco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacao {
	private String tipo;
	private double valor;
	private LocalDateTime dataHora;
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	public Transacao(String tipo, double valor) {
		this.tipo = tipo;
		this.valor = valor;
		this.dataHora = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return String.format("%s - R$ %.2f - %s", tipo, valor, dataHora.format(FORMATTER));
	}

	public String getTipo() {
		return tipo;
	}

	public double getValor() {
		return valor;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}
	
}
