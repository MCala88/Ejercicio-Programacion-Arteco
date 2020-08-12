package arteco;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 System.out.println("\n" + "Cantidad de frases, palabras y parrafos del texto" + "\n" + 
                 "==============================================="        );
		 
		 
		 
		 Lipsum lip = new Lipsum();
		 Contador contar = new Contador();
		 String palabras = lip.getLipsum();
		 
		 System.out.println("\n Cantidad de palabras: \n" +  contar.palabra(palabras));
	}

}
