package arteco.domain;

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
	HashMap<String, Integer> tuplas = contar.tuplas(txt);
	
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
			assertEquals("{at=13, sed=11, lorem=10, orci=10, in=9}", contar.palabrasMasRepetidas(palabrasRepetidas).toString());
		}
		
	
	//Cuarto punto
			@Test
			public void tuplas_repetidas_test() {
				assertEquals("{sit amet=7, consectetur adipiscing=3, adipiscing elit=3, ipsum dolor=3, dolor sit=3}", contar.tuplasMasRepetidas(tuplas).toString());		
			}
		
	
	
}
