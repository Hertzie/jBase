package Recursos;

import Bloque.Bloque;
import Recursos.TipoPreestablecido;
import Recursos.Tipo;

public class Variable extends Valor {
	
	private Bloque bloque;
	private String nombre;
	
	public Variable(Bloque bloque, Tipo tipo, String nombre, Object valor) {
		super(tipo, valor);
		this.bloque = bloque;
		this.nombre = nombre;
		
	}
	
	public Bloque getBloque() {
		return bloque;
	}
	
	public String getNombre() {
		return nombre;
	}
}
