package Tokenizer;
import java.util.regex.Pattern;

public class TokenDatos {
	
	private TokenTipo tipo;
	private Pattern patron;
	
	
	
	public TokenDatos(Pattern patron, TokenTipo tipo) {
		// TODO Auto-generated constructor stub
		this.tipo = tipo;
		this.patron = patron;
	}

	public TokenTipo getTipo() {
		return tipo;
	}
	
	public Pattern getPatron() {
		return patron;
	}
}
