package Tokenizer;

public class TokenizerPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String codigo = "clase holamundo\n" +  
						"	sub main param()\n" + 
						"		imprime \"Hola mundo\"";
		
		Tokenizer t = new Tokenizer(codigo);
		
		while(t.tieneSiguienteToken()) {
			System.out.println(t.siguienteToken().getToken());
		}
	}	

}
