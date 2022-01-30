package br.senai.ex04;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main04 {
	
	public static void main(String[] args) {
		
	    Scanner input = new Scanner(System.in);
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    
	    System.out.println("Data (formato: dd/MM/aaaa): ");
	    LocalDate data = LocalDate.parse(input.nextLine(), formatter);
	    input.close();
	    
	    if (data.getDayOfMonth() != 13) {
	    	throw new IllegalArgumentException("Não é dia 13!");
	    }
	    
	    if (data.getDayOfWeek() != DayOfWeek.FRIDAY) {
	    	throw new IllegalArgumentException("Não é uma Sexta-Feira!");
	    }
	    
	    System.out.println(data.format(formatter) + " cai em uma Sexta-Feira");
		
	}

}
