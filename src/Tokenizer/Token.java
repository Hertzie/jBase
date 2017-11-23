package Tokenizer;

public class Token {
	
	private String token;
	private TokenTipo tipo;
	
	public Token(String token, TokenTipo tipo) {
		this.token = token;
		this.tipo = tipo;
	}
	
	public String getToken() {
		return token;
	}
	
	public TokenTipo getTipo() {
		return tipo;
	}

}
