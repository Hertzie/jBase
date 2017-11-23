package Bloque;

import Recursos.Tipo;

public class Clase extends Bloque implements Tipo{
	
	private String nombre;

	public Clase(String nombre) {
		super(null);
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	@Override
	public void correr() {
		for(Bloque b : getBloquesHijos()) {
			if(b instanceof Metodo) {
				Metodo metodo = (Metodo)b;
				if(metodo.getNombre().equals("main") && metodo.getTipo().equals("void") && metodo.getParametros().length == 0) {
					metodo.correr();
				}
			}
		}

	}
	
	
}
