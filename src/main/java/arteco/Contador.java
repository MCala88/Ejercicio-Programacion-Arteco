package arteco;

public class Contador implements Texto{

	
	public int palabra(String palabras) {
		int contador = 1, posicion;
	    palabras= palabras.trim();                               
	    if (palabras.isEmpty()) { 
	        contador = 0;
	    } else {
	            posicion = palabras.indexOf(" "); 
	            while (posicion != -1) {   
	                   contador++;    
	                   posicion = palabras.indexOf(" ", posicion + 1); 
	            }                                     
	    }
	    return contador;
		
	}

	@Override
	public String text(Lipsum enunciado) {
		// TODO Auto-generated method stub
		String palabras = enunciado.getLipsum();
		return palabras;
	}

}
