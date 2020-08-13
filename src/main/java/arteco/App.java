package arteco;

import java.util.HashMap;
import java.util.List;

import arteco.domain.Contador;
import arteco.domain.Lipsum;

public class App {

	public static void main(String[] args) { 
		 
		 Lipsum lip = new Lipsum();
		 Contador contar = new Contador();
		 String texto = lip.getLipsum();
		 String[] txt = contar.separarPalabras(texto);
		 List<String> palindromas = contar.palindromo(txt);
		 HashMap<String, Integer> palabrasRepetidas = contar.totalPalabrasRepetidas(txt);
		
		
		 System.out.println("\n" + "Cantidad de frases, palabras y parrafos del texto" + "\n" + 
                 "==============================================="        );
		 
		
		 System.out.println("\n Cantidad de frases: \n " +  contar.frases(texto) + " frases");
		 System.out.println("\n Cantidad de palabras: \n " +  contar.palabras(texto) + " palabras");
		 System.out.println("\n Cantidad de parrafos: \n " +  contar.parrafos(texto) + " parrafos");
	
	
		 System.out.println("\n" + "Palindromos" + "\n" + 
                 "==============================================="        );
		 
	
		 System.out.println("\n Cantidad de palindromos: \n "  + contar.contarPalindromas(palindromas) + " palindromos: \n" + " " +  contar.palindromo(txt));
		 
		
		 
		 
		 System.out.println("\n" + "5 palabras mas repetidas" + "\n" + 
                 "==============================================="        );
	
		 System.out.println("\n 5 palabras que mas aparecen: \n "  + contar.palabrasMasRepetidas(palabrasRepetidas));
	
	
		
	}

}
