package arteco;

import java.util.ArrayList;
import java.util.List;



public class Contador implements Texto{

	public int frases(String texto) {
		int contador = 1, posicion;
		texto= texto.trim();                               
	    if (texto.isEmpty()) { 
	        contador = 0;
	    } else {
	    	posicion = texto.indexOf(". "); 
            while (posicion != -1) {   
                   contador++;    
                   posicion = texto.indexOf(". ", posicion + 1); 
            }
	    }
	    
		return contador;
	}
	
	
	public int palabras(String texto) {
		int contador = 1, posicion;
	    texto= texto.trim();                               
	    if (texto.isEmpty()) { 
	        contador = 0;
	    } else {
	            posicion = texto.indexOf(" "); 
	            while (posicion != -1) {   
	                   contador++;    
	                   posicion = texto.indexOf(" ", posicion + 1); 
	            }                                     
	    }
	    return contador;
		
	}
	
	public int parrafos(String texto) {
		int contador = 1, posicion;
		texto= texto.trim();                               
	    if (texto.isEmpty()) { 
	        contador = 0;
	    } else {
	    	posicion = texto.indexOf("\r\n"); 
            while (posicion != -1) {   
                   contador++;    
                   posicion = texto.indexOf("\r\n" + "\r\n", posicion + 1); 
            }
	    }
	    
		return contador;
	}
	
	public String[] separarPalabras(String texto) {
		String[] txt = texto.split(" ");
			return txt;
		}
		
	
	public List<String> palindromo(String[] txt) {
		List<String> palindromas = new ArrayList<String>();
		for(String palabra : txt) {
			palabra = palabra.toLowerCase();
			 String invertida = new StringBuilder(palabra).reverse().toString();
			 if (invertida.equals(palabra)) {
				 if(palabra.length() > 1) {
					 palindromas.add(palabra); 
				 }
				  
			 } else { 
				 
			 }
		}
		return palindromas;
		
	}
	
	public int contarPalindromas(List<String> palindromas) {
		return palindromas.size();
	}
	

	
	@Override
	public String text(Lipsum enunciado) {
		String texto = enunciado.getLipsum();
		return texto;
	}

	
}
