package br.senai.ex02;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main02 {
	
	public static void main(String[] args) {
		
	    Scanner input = new Scanner(System.in);
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	    
	    System.out.println("Região de origem: ");
	    String origemInput = input.nextLine();
	    System.out.println("Data e horário de saída (formato: dd/MM/aaaa HH:mm): ");
	    LocalDateTime saidaInput = LocalDateTime.parse(input.nextLine(), formatter);
	    
	    System.out.println("Região de destino: ");
	    String destinoInput = input.nextLine();
	    System.out.println("Data e horário de chegada (formato: dd/MM/aaaa HH:mm): ");
	    LocalDateTime chegadaInput = LocalDateTime.parse(input.nextLine(), formatter);
	    
	    ZonedDateTime origemVoo = ZonedDateTime.of(saidaInput, ZoneId.of(origemInput));
	    ZonedDateTime destinoVoo = ZonedDateTime.of(chegadaInput, ZoneId.of(destinoInput));
	    
	    System.out.println("Saida: " + origemVoo.format(formatter));
	    System.out.println("Chegada: " + destinoVoo.format(formatter));
	    
	    Duration duracao = Duration.between(origemVoo, destinoVoo);
	    
	    System.out.println("Duração: " + duracao.toHours() + ":" + duracao.toMinutesPart() + "h");
	    input.close();
	     
		
	}

}
