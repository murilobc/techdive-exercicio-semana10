package br.senai.ex08.bean;

public class Conta {
	private Integer id;
	private String nome;
	private Double saldo;
	
	public Conta(Integer id, String nome, Double saldo) {
		super();
		this.id = id;
		this.nome = nome;
		this.saldo = saldo;
	}
	
	public void sacar(Double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor inválido");
		}
		if ((getSaldo() - valor) < 0) {
			throw new IllegalArgumentException("Saldo insuficiente");
		}
		setSaldo(getSaldo() - valor);
	}
	
	public void depositar(Double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException("Valor inválido");
		}
		setSaldo(getSaldo() + valor); 
	}
	
	public void transferencia(Conta destino, Double valor) {
		this.sacar(valor);
		destino.depositar(valor);
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Double getSaldo() {
		return saldo;
	}


	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
