package Parser;

import Bloque.Bloque;
import Bloque.Clase;
import Tokenizer.Tokenizer;

public class ClaseParser extends Parser<Clase> {

	@Override
	public boolean puedeParsear(String linea) {
		return linea.matches("clase [a-zA-Z][a-zA-Z0-9]*");
	}

	@Override
	public Clase parse(Bloque bloquePadre, Tokenizer tokenizer) {
		tokenizer.siguienteToken();
		String nombre = tokenizer.siguienteToken().getToken();
		
		return new Clase(nombre);
	}

}
