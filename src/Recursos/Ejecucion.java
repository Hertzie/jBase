package Recursos;

import java.util.ArrayList;

import Bloque.Bloque;
import Bloque.Clase;
import Bloque.Metodo;
import Bloque.VariableBloque;
import Parser.ClaseParser;
import Parser.MetodoParser;
import Parser.Parser;
import Parser.VariableParser;
import Tokenizer.Tokenizer;

public class Ejecucion {
	
	private ArrayList<Clase> clases;
	
	public Ejecucion() {
		
		this.clases = new ArrayList<Clase>();
		String codigo = "clase holamundo" + "\n" + 
							"sub main param () retorna void" + "\n" + 
								"dim string algo = \"HolaMundo\"" + "\n" +
							"sub imprimeString param (string str) retorna void ";
		
		
		//Tokenizer tokenizer = new Tokenizer(codigo);
		Parser<?>[] parsers = new Parser<?>[] {new ClaseParser(), new MetodoParser(), new VariableParser()};
		Clase main = null;
		Bloque bloque = null;
		boolean correcto = false;
		
		for(String linea : codigo.split("\n")) {
			correcto = false;
			linea = linea.trim();
			Tokenizer tokenizer = new Tokenizer(linea);
			
			for(Parser<?> parser : parsers) {
				if(parser.puedeParsear(linea)) {
					Bloque nuevoBloque = parser.parse(bloque, tokenizer);
					
					if(nuevoBloque instanceof Clase) {
						clases.add((Clase)nuevoBloque);
					}
					
					else if(nuevoBloque instanceof Metodo) {
						bloque.getArbolDeBloques().get(0).agregarBloque(nuevoBloque);
					}
					else {
						bloque.agregarBloque(nuevoBloque);
					}
					bloque = nuevoBloque;
					correcto = true;
					break;
				}
			}
			
			if(!correcto){
				throw new IllegalArgumentException("Linea invalida: " + linea);
			}
		}
		
		for(Clase c : clases) {
			for(Bloque b : c.getBloquesHijos()) {
				System.out.println("Encontrado bloque de tipo: " + b.getClass().getSimpleName());
				if(b instanceof Metodo) {
					Metodo metodo = (Metodo)b;
					if(metodo.getNombre().equals("main") && metodo.getTipo().equals("void") && metodo.getParametros().length == 0) {
						main = c;
					}
					
					for(Bloque bl : metodo.getBloquesHijos()) {
						System.out.println(((VariableBloque) bl).getTipo());
					}
				}
			}
		}
		
		if(main == null) {
			throw new IllegalStateException("No se encontró método main en el código.");
		}
		
		main.correr();

	}
	
	public static void main(String...a) {
		new Ejecucion();
	}
}
