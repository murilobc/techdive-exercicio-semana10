package br.senai.ex03;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class Main03 {
	
	public static void main(String[] args) {
		
	    TemporalAdjuster sexta = TemporalAdjusters.next(DayOfWeek.SATURDAY);
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    
	    for (int i = 1; i <= 12; i++) {
	    	LocalDate primeiroDoMes = LocalDate.of(2022, i, 1);
	    	if (primeiroDoMes.getDayOfWeek() == DayOfWeek.SATURDAY) {
	    		System.out.println(primeiroDoMes.format(formatter));
	    	} else {
	    		System.out.println(primeiroDoMes.with(sexta).format(formatter));
	    	}
			
		}
		
	}

}
