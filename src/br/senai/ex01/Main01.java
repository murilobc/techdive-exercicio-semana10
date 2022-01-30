package br.senai.ex01;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main01 {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Informe sua data de nascimento (formato dd/MM/aaaa):");
		
		String dataEntrada = input.nextLine();
		LocalDate dataNascimento = LocalDate.parse(dataEntrada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		long idade = ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
		
		StringBuilder mensagem = new StringBuilder(String.format("Você tem %d anos", idade));
		if (idade >= 18) {
			mensagem.append(", seu acesso foi liberado.");
		} else {
			mensagem.append(", seu acesso foi negado.");
		}
		
		System.out.println(mensagem);
		input.close();
		
	}

}
