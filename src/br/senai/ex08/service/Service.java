package br.senai.ex08.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import br.senai.ex08.bean.Conta;

public class Service {

	
	public Conta buscar(Integer id) {
		Conta conta = null;
		List<String> contas = null;
		try {
			contas = Files.readAllLines(Paths.get("contas.csv"));
			for (String linha : contas) {
				if (linha.isBlank()) {
					continue;
				}
				String[] split = linha.split(",");
				if (id == Integer.valueOf(split[0])) {
					conta = new Conta(Integer.valueOf(split[0]), split[1], Double.valueOf(split[2]));
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return conta;
	}
	
	public void salvar(Conta conta) {
		List<String> contas = null;
		try {
			contas = Files.readAllLines(Paths.get("contas.csv"));
			StringBuilder conteudo = new StringBuilder();
			String substituir = "";
			for (String linha : contas) {
				if (linha.isBlank()) {
					continue;
				}
				String[] split = linha.split(",");
				if (conta.getId() == Integer.valueOf(split[0])) {
					substituir = linha;
				}
				conteudo.append(linha).append(System.lineSeparator());
			}
			String imprime = conteudo.toString();
			String linhaNova = conta.getId() + "," + conta.getNome() + "," + conta.getSaldo() + System.lineSeparator();
			if (!substituir.isBlank()) {
				imprime = imprime.replaceAll(substituir, linhaNova);
			} else {
				imprime = imprime.concat(linhaNova);
			}
			
			FileWriter fw = new FileWriter("contas.csv");
			fw.append(imprime);
			fw.flush();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public Integer gerarId() {
		List<String> contas = null;
		Integer retorno = 1000;
		try {
			contas = Files.readAllLines(Paths.get("contas.csv"));
			if (!contas.isEmpty()) {
				String[] ultimo = contas.get(contas.size() - 1).split(",");
				retorno = Integer.valueOf(ultimo[0]) + 1; 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retorno; 
	}
	
	public void salvarTransacao(Conta origem, Conta destino, Double valor) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("transacoes.csv", true))) {
			StringBuilder linha = new StringBuilder();
			if (origem == null) {
				linha.append("D,").append("").append(",").append(destino.getId()).append(",").append(valor).append(System.lineSeparator());
			} else if (destino == null) {
				linha.append("S,").append(origem.getId()).append(",").append("").append(",").append(valor).append(System.lineSeparator());
			} else {
				linha.append("T,").append(origem.getId()).append(",").append(destino.getId()).append(",").append(valor).append(System.lineSeparator());
			}
			
			bw.append(linha);
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
