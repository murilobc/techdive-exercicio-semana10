package br.senai.ex08.util;

import java.util.Scanner;

import br.senai.ex08.bean.Conta;
import br.senai.ex08.service.Service;

public class Input {
	
	Scanner input = new Scanner(System.in);
	Service service = new Service();
	
	public void iniciar() {
		System.out.println("Escolha uma opção: ");
		System.out.println("1 - Cadastrar nova conta");
		System.out.println("2 - Fazer depósito");
		System.out.println("3 - Fazer saque");
		System.out.println("4 - Fazer transferencia");
		
		Integer opcao = Integer.valueOf(input.nextLine());
		if (opcao == null) {
			throw new IllegalArgumentException("Opção inválida");
		}
		
		switch (opcao) {
		case 1:
			efetuarCadastro();
			break;
		case 2:
			efetuarDeposito();
			break;
		case 3:
			efetuarSaque();
			break;
		case 4:
			efetuarTransferencia();
			break;
		}
	}

	private void efetuarTransferencia() {
		System.out.println("Informe o ID da conta origem");
		Conta origem = service.buscar(Integer.valueOf(input.nextLine()));
		System.out.println("Informe o ID da conta destino");
		Conta destino = service.buscar(Integer.valueOf(input.nextLine()));
		System.out.println("Informe o valor da transferencia: ");
		Double valor = Double.valueOf(input.nextLine());
		
		origem.transferencia(destino, valor);
		service.salvar(origem);
		service.salvar(destino);
		service.salvarTransacao(origem, destino, valor);
		
		iniciar();
	}

	private void efetuarSaque() {
		System.out.println("Informe o ID da conta");
		Conta conta = service.buscar(Integer.valueOf(input.nextLine()));
		System.out.println("Informe o valor do saque: ");
		Double valor = Double.valueOf(input.nextLine());
		
		conta.sacar(valor);
		service.salvar(conta);		
		service.salvarTransacao(conta, null, valor);
		
		iniciar();
	}

	private void efetuarDeposito() {
		System.out.println("Informe o ID da conta");
		Conta conta = service.buscar(Integer.valueOf(input.nextLine()));
		System.out.println("Informe o valor do depósito: ");
		Double valor = Double.valueOf(input.nextLine());
		
		conta.depositar(valor);
		service.salvar(conta);
		service.salvarTransacao(null, conta, valor);
		
		iniciar();
	}

	private void efetuarCadastro() {
		System.out.println("Informe o nome:");
		String nome = input.nextLine();
		System.out.println("Informe o saldo");
		Double saldo = Double.valueOf(input.nextLine());
		
		Conta conta = new Conta(service.gerarId(), nome, saldo);
		service.salvar(conta);
		
		iniciar();
	}
	
	

}
