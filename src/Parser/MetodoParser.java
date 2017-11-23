package Parser;

import java.util.ArrayList;

import Bloque.Bloque;
import Bloque.Metodo;
import Recursos.Parametro;
import Recursos.TipoPreestablecido;
import Tokenizer.Tokenizer;
import Tokenizer.Token;

public class MetodoParser extends Parser<Metodo> {

	@Override
	public boolean puedeParsear(String linea) {
		return linea.matches("sub [a-zA-Z][a-zA-Z0-9]* param \\(([a-zA-Z][a-zA-Z0-9]* [a-zA-Z][a-zA-Z0-9]*)*\\) retorna [a-zA-Z][a-zA-Z0-9]*");
	}

	@Override
	public Metodo parse(Bloque bloquePadre, Tokenizer tokenizer) {
		tokenizer.siguienteToken();
		String nombre = tokenizer.siguienteToken().getToken();
		tokenizer.siguienteToken();
		tokenizer.siguienteToken();
		Token primero = tokenizer.siguienteToken();
		
		ArrayList<Parametro> params = new ArrayList<>();
		
		if(!primero.getToken().equals(")")) {
			String[] datos = new String[] {primero.getToken(), null};
			
			while(tokenizer.tieneSiguienteToken()) {
				Token token = tokenizer.siguienteToken();
				if(token.getToken().equals(")"))
					break;
				
				if(datos[0] == null) 
					datos[0] = token.getToken();
				
				else {
					datos[1] = token.getToken();
					params.add(new Parametro(TipoPreestablecido.valueOf(datos[0].toUpperCase()), datos[1]));
					datos = new String[2];
				}
			}
			
		}
		
		tokenizer.siguienteToken();
		String tipoRetorno = tokenizer.siguienteToken().getToken();
		
		return new Metodo(bloquePadre, nombre, tipoRetorno, params.toArray(new Parametro[params.size()]));
		
	}

}
