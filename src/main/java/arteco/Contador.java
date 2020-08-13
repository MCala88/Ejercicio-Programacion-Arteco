package arteco;

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

	@Override
	public String text(Lipsum enunciado) {
		// TODO Auto-generated method stub
		String texto = enunciado.getLipsum();
		return texto;
	}

}
