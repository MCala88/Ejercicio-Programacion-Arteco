package arteco;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class ArtecoTest {
	private Lipsum user = new Lipsum();
	private Contador contar = new Contador();
	String texto = user.getLipsum();
	String[] txt = contar.separarPalabras(texto);
	List<String> palindromas = contar.palindromo(txt);
	HashMap<String, Integer> palabrasRepetidas = contar.totalPalabrasRepetidas(txt);
	
	//Primer punto
	@Test
	public void palabras_test() {
		assertEquals(498, contar.palabras(texto));
	}
	
	@Test
	public void frases_test() {
		assertEquals(60, contar.frases(texto));
	}
	
	@Test
	public void parragrafos_test() {
		assertEquals(5, contar.parrafos(texto));
	}
	
	
	//Segundo punto
	@Test
	public void palindromos_test() {
		assertEquals(4, contar.contarPalindromas(palindromas));
		assertEquals("[non, non, non, non]", contar.palindromo(txt).toString());
	}
	
	
	//Tercer punto
		@Test
		public void palabras_repetidas_test() {
			assertEquals("{at=11, ipsum=7, et=7, blandit=7, sit=7}", contar.palabrasMasRepetidas(palabrasRepetidas).toString());
			
		}
		
	
	
}
