package Recursos;
import Recursos.Tipo;

public class Valor {
	
	private Object valor;
	private Tipo tipo;
	
	public Valor(Tipo tipo, Object valor) {
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public Object getValor() {
		return valor;
	}
	
	public void setValor(Object valor) {
		this.valor = valor;
	}
}
