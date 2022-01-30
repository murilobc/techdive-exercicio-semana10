package br.senai.ex06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class Main06 {
	
	public static void main(String[] args) {
		
		try {
			
			double tamanho = Files.size(Path.of("teste.txt"));
			
			System.out.printf(Locale.US, "%.2f Bytes\n", tamanho);
			System.out.printf(Locale.US, "%.4f Kiloytes\n", tamanho / 1024);
			System.out.printf(Locale.US, "%.4f Megaytes\n", tamanho / (1024^2));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
