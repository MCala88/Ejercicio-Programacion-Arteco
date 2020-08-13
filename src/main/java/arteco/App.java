package arteco;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 System.out.println("\n" + "Cantidad de frases, palabras y parrafos del texto" + "\n" + 
                 "==============================================="        );
		 
		 
		 
		 Lipsum lip = new Lipsum();
		 Contador contar = new Contador();
		 String texto = lip.getLipsum();
		 
		 System.out.println("\n Cantidad de frases: \n " +  contar.frases(texto) + " frases");
		 System.out.println("\n Cantidad de palabras: \n " +  contar.palabras(texto) + " palabras");
		 System.out.println("\n Cantidad de parrafos: \n " +  contar.parrafos(texto) + " parrafos");
	}

}
