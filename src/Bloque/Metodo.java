package Bloque;
import java.util.Arrays;

import Recursos.Parametro;
import Recursos.Tipo;
import Recursos.TipoPreestablecido;
import Recursos.Valor;
import Recursos.Variable;


public class Metodo extends Bloque{
	
	private String nombre;
	private String tipo;
	private Parametro[] param;
	private Valor valorRetornado;

	public Metodo(Bloque bloquePadre, String nombre, String tipo, Parametro[] param) {
		super(bloquePadre);
		this.nombre = nombre;
		this.tipo = tipo;
		this.param = param;	
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public Parametro[] getParametros() {
		return param;
	}

	@Override
	public void correr() {
		invocar();
	}
	
	public Valor invocar(Valor...valores) {
		
		
		Tipo t = Tipo.emparejar(tipo);
		System.out.println("Invocando método: " + nombre + " de tipo " + t + " " + "con parámetros " + Arrays.toString(param) );
		
		if(valores.length != param.length)
			throw new IllegalArgumentException("Numero de valores equivocados");
		
		for(int i=0; i<valores.length && i<param.length; i++) {
			Parametro p = param[i];
			Valor v = valores[i];
			
			if(p.getTipo() != v.getTipo())
				throw new IllegalStateException("Parametro " + p.getNombre() + " deberia ser " + p.getTipo()+ ". " + "Encontrado: " + v.getTipo());
			
			agregarVariable(new Variable(this, p.getTipo(), p.getNombre(), v.getValor()));
		}
		
		for(Bloque b : getBloquesHijos()) {
			b.correr();
			
			if(valorRetornado != null)
				break;	
		}
		
		if(valorRetornado == null && t != TipoPreestablecido.VOID)
			throw new IllegalStateException("Valor de re");
		
		Valor valorLocal = valorRetornado;
		valorRetornado = null;
		return valorLocal;
	}

	

}
