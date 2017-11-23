package Bloque;
import java.util.ArrayList;
import java.util.Collections;

import Recursos.Variable;

public abstract class Bloque {
	
	private Bloque bloquePadre;
	private ArrayList<Bloque> bloquesHijos;
	private ArrayList<Variable> variables;
	
	public Bloque(Bloque bloquePadre) {
		this.bloquePadre = bloquePadre;
		this.bloquesHijos = new ArrayList<>();
		this.variables = new ArrayList<>();
	}
	
	public Bloque getBloquePadre() {
		return bloquePadre;
	}
	
	public ArrayList<Bloque> getArbolDeBloques(){
		ArrayList<Bloque> bloques = new ArrayList<Bloque>();
		Bloque bloque = this;
		
		do {
			bloques.add(bloque);
			bloque = bloque.getBloquePadre();
		}while(bloque != null);
		
		Collections.reverse(bloques);
		
		return bloques;
		
	}
	
	public Bloque[] getBloquesHijos() {
		return bloquesHijos.toArray(new Bloque[bloquesHijos.size()]);
	}
	
	public void agregarBloque(Bloque bloque) {
		bloquesHijos.add(bloque);
	}
	
	public void agregarVariable(Variable v) {
		variables.add(v);
	}
	
	public Variable getVariable(String nombre) {
		for(Variable v : variables) {
			if(v.getNombre().equals(nombre))
				return v;
		}
		return null;
	}
	
	public abstract void correr();
	
}
