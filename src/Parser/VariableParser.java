package Parser;

import Bloque.Bloque;
import Bloque.VariableBloque;
import Recursos.Tipo;
import Recursos.TipoPreestablecido;
import Recursos.Variable;
import Tokenizer.Token;
import Tokenizer.TokenTipo;
import Tokenizer.Tokenizer;

public class VariableParser extends Parser<Bloque> {

	@Override
	public boolean puedeParsear(String linea) {
		return linea.matches("dim [a-zA-Z]+ [a-zA-Z]+ = (\")?[a-zA-Z0-9]*(\")?");
	}

	@Override
	public Bloque parse(Bloque bloquePadre, Tokenizer tokenizer) {
		tokenizer.siguienteToken();
		String tipo = tokenizer.siguienteToken().getToken();
			
		//if(tipo == TipoPreestablecido.VOID)
			//throw new IllegalStateException("No puede declarar variables de tipo VOID");
		
		
		String nombre = tokenizer.siguienteToken().getToken();
		tokenizer.siguienteToken();
		
		Token valorToken = tokenizer.siguienteToken();
		Object valor = null;
		
		if(valorToken.getTipo() == TokenTipo.INTEGER_LITERAL)
			valor = Integer.valueOf(valorToken.getToken());
		
		else if(valorToken.getTipo() == TokenTipo.STRING_LITERAL)
			valor = valorToken.getToken();
		
		else
			valor = bloquePadre.getVariable(valorToken.getToken()).getValor();
		
		return new VariableBloque(bloquePadre, tipo, nombre, valor);
			
		
		
	}

}
