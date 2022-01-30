package br.senai.ex05;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class Main05 {
	
	public static void main(String[] args) {
		
	    Scanner input = new Scanner(System.in);
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    TemporalAdjuster segunda = TemporalAdjusters.next(DayOfWeek.MONDAY);
	    
	    System.out.println("Informe mês e ano (formato: MM/aaaa): ");
	    LocalDate data = LocalDate.parse("01/" + input.nextLine(), formatter);
	    input.close();
	    
		Month mes = data.getMonth();
		
	    while (mes == data.getMonth()) {
	    	
	    	if (data.getDayOfWeek() == DayOfWeek.MONDAY) {
	    		System.out.println(data.format(formatter));
	    	} else {
	    		System.out.println(data.with(segunda).format(formatter));
	    	}
	    	
	    	data = data.plusWeeks(1);
	    }
	}

}
