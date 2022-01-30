package br.senai.ex07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main07 {
	
	public static void main(String[] args) {
		
		try {
			Scanner arquivo = new Scanner(new File("teste.txt"));
			int contagem = 0; 
			
			// Escolha o caracter para contar aqui
			char caracter = 'e';
			
			while (arquivo.hasNextLine()) {
				String linha = arquivo.nextLine();
				for (int i = 0; i < linha.length(); i++) {
					if (caracter == linha.charAt(i)) {
						contagem++;
					}
					
				}
			}
			
			arquivo.close();
			System.out.println("Contagem: " + contagem);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
