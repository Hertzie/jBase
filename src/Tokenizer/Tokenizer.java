package Tokenizer;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
	
	private ArrayList<TokenDatos> tokenDatos;
	private Token ultimoToken;
	private boolean regresar;
	private String str;
	
	public Tokenizer(String str) {
		this.str = str;
		this.tokenDatos = new ArrayList<TokenDatos>();
		
		tokenDatos.add(new TokenDatos(Pattern.compile("^([a-zA-Z][a-zA-Z0-9]*)"), TokenTipo.IDENTIFICADOR));
		tokenDatos.add(new TokenDatos(Pattern.compile("^((-)?[0-9]+)"), TokenTipo.INTEGER_LITERAL));
		tokenDatos.add(new TokenDatos(Pattern.compile("^(\".*\")"), TokenTipo.STRING_LITERAL));
		
		for(String s : new String[] {"=", "\\(", "\\)", "\\.", "\\,"}) {
			tokenDatos.add(new TokenDatos(Pattern.compile("^(" + s + ")"), TokenTipo.TOKEN));
		}
	}
	
	public Token siguienteToken() {
		str = str.trim();
		
		if(regresar) {
			regresar = false;
			return ultimoToken;
		}
		if(str.isEmpty()) {
			return (ultimoToken = new Token("", TokenTipo.VACIO));
		}
		
		for(TokenDatos datos : tokenDatos) {
			Matcher matcher = datos.getPatron().matcher(str);
			if(matcher.find()) {
				String token = matcher.group().trim();
				str = matcher.replaceFirst("");
				
				if(datos.getTipo() == TokenTipo.STRING_LITERAL) {
					return (ultimoToken = new Token(token.substring(1, token.length()-1), TokenTipo.STRING_LITERAL));
				}
				else {
					return (ultimoToken = new Token(token, datos.getTipo()));
				}
			}
		}
		
		throw new IllegalStateException("No se pudo parsear: " + str);
	}
	
	public boolean tieneSiguienteToken() {
		return !str.isEmpty();
	}
	
	public void regresar() {
		if(ultimoToken != null)
			this.regresar = true;
	}
}
