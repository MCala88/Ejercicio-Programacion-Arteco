package arteco.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


//Implementamos la interfaz donde accedemos a la String lipsum
public class Contador implements Texto{

	/*Creamos un metodo frases en el que creamos un contador
	 *Primero nos aseguramos que no este vacio y que no tenga espacios al inicio y final de la String
	 *Buscamos un punto y espacio en blanco que nos indica el final de una frase 
	 *mientras que se busca se suma una frase al contador
	 *Cuando se encuentra busca la siguiente
	 */
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
	
	
	/*Creamos un metodo palabras en el que creamos un contador
	 *Primero nos aseguramos que no este vacio y que no tenga espacios al inicio y final de la String
	 *Buscamos un espacio en blanco, mientras que se busca se suma una palabra al contador
	 *Cuando se encuentra busca la siguiente
	 */
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
	
	
	/*Creamos un metodo parrafos en el que creamos un contador
	 *Primero nos aseguramos que no este vacio y que no tenga espacios al inicio y final de la String
	 *Buscamos un espacio del punto y aparte, mientras que se busca se suma un parrafo al contador
	 *Cuando se encuentra busca la siguiente
	 */
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
	
	
	/*Creamos este metodo para convertir nuestra String en una ArrayList 
	 *porque necesiamos tener acceso a las palabras de manera aislada
	 */
	public String[] separarPalabras(String texto) {
		texto = texto.replaceAll("[.,:;?!]", "").toLowerCase();
		String[] txt = texto.split(" ");
			return txt;
		}
		
	
	/*Creamos una ArrayList para introducir los palindromos
	 *Hacemos un bucle para recorrer la lista con las palabras
	 *Ponemos las letras en minuscula para que no interfieran
	 *Volteamos las palabras y comprobamos si son iguales
	 *Indicamos que la palabra sea mas larga de un caracter y la guardamos en la lista
	 */
	public List<String> palindromo(String[] txt) {
		List<String> palindromas = new ArrayList<String>();
		for(String palabra : txt) {
			palabra = palabra.toLowerCase();
			 String invertida = new StringBuilder(palabra).reverse().toString();
			 if (invertida.equals(palabra)) {
				 if(palabra.length() > 1) {
					 palindromas.add(palabra); 
				 } 
			 }
		}
		return palindromas;
	}
	
	
	//Le pasamos la ArrayList de los palindromos y comprueba la cantidad
	public int contarPalindromas(List<String> palindromas) {
		return palindromas.size();
	}
	
	
	/*Creamos un mapa con la palabra como key y la veces que ha salido como valor
	 *Usando los bucles recorremos la lista de las palabras, se comprueba si esta en el mapa
	 *Si está se suma en el valor y si no esta se guarda el nombre  
	 */
	public HashMap<String, Integer> totalPalabrasRepetidas(String[] txt) {
		HashMap<String, Integer> palabrasRepetidas = new HashMap<>();
		for (String palabra : txt) {
		    if (palabrasRepetidas.containsKey(palabra)) {
		        palabrasRepetidas.put(palabra, palabrasRepetidas.get(palabra) + 1);
		    } else {
		        palabrasRepetidas.put(palabra, 1);
		    }
		}
		return palabrasRepetidas;
	}

	
	/*Tomamos el HashMap del anterior metodo y creamos un mapa en el que meteremos el resultado del metodo
	 *Con una stream ordenamos el contenido de las palabras repetidas en orden descendiente en base a su valor 
	 *Lo limitamos a 5 y lo devolvemos en LinkedHashMap para que lo devuelva ordenado
	 */
	public HashMap<String, Integer> palabrasMasRepetidas(HashMap<String, Integer> palabrasRepetidas) {
		final HashMap<String, Integer> cincoPalabras = palabrasRepetidas.entrySet()
                .stream()
                .sorted((HashMap.Entry.<String, Integer>comparingByValue().reversed()))
                .limit(5)
                .collect(Collectors.toMap(HashMap.Entry::getKey, HashMap.Entry::getValue, (k, v) -> v, LinkedHashMap::new));
		return cincoPalabras;
	}
	
	
	
	/*Para encontrar las tuplas que mas se repiten hacemos algo muy parecido a las palabras
	 *en este caso creamos una String que es la palabraAnterior en la que al finalizar 
	 *el bucle la palabra que se estaba usando se guardara en esta variable
	 *Para que sean tuplas se concatena la palabra actual y se junta con la anterior
	 */
	public HashMap<String, Integer> tuplas(String[] txt) {
		HashMap<String, Integer> tuplas = new HashMap<>();
		String palabraAnterior = "";
		
		
		for (String palabra : txt) {
			if (palabraAnterior != "") {
				String tuplaRepetida = palabraAnterior.concat(" ").concat(palabra);
				if (tuplas.containsKey(tuplaRepetida)) {
					tuplas.put(tuplaRepetida, tuplas.get(tuplaRepetida) + 1);
				} else {
					tuplas.put(tuplaRepetida, 1);
				}
			}
			palabraAnterior = palabra;
		}
		return tuplas;
	}
	
		
	/*Tomamos el HashMap del anterior metodo y creamos un mapa en el que meteremos el resultado del metodo
	 *Con una stream ordenamos el contenido de las palabras repetidas en orden descendiente en base a su valor y lo militamos a 5
	 */
	public HashMap<String, Integer> tuplasMasRepetidas(HashMap<String, Integer> tuplas) {
		final HashMap<String, Integer> cincoTuplas = tuplas.entrySet()
                .stream()
                .sorted((HashMap.Entry.<String, Integer>comparingByValue().reversed()))
                .limit(5)
                .collect(Collectors.toMap(HashMap.Entry::getKey, HashMap.Entry::getValue, (k, v) -> v, LinkedHashMap::new));
		return cincoTuplas;
	}
	
	
	//Obtenemos el texto de la clase principal con la implementación de la interfaz
	@Override
	public String text(Lipsum enunciado) {
		String texto = enunciado.getLipsum();
		return texto;
	}

	
}
