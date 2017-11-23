package Recursos;


public class Parametro {
	
	private String nombre;
	private Tipo tipo;
	
	public Parametro(Tipo tipo, String nombre) {
		this.tipo = tipo;
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
}
