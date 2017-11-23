package Bloque;
import Recursos.Tipo;
import Recursos.TipoPreestablecido;
import Recursos.Variable;

public class VariableBloque extends Bloque {
	
	private String nombre, tipo;
	private Object valor;

	public VariableBloque(Bloque bloquePadre, String tipo, String nombre, Object valor) {
		super(bloquePadre);
		this.tipo = tipo;
		this.nombre = nombre;
		this.valor = valor;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getTipo() {
		return tipo;
	}

	@Override
	public void correr() {
		Tipo t = Tipo.emparejar(tipo);
		
		if(t == TipoPreestablecido.VOID)
			throw new IllegalStateException("No puede declarar variables de tipo VOID");
		
		getBloquePadre().agregarVariable(new Variable(getBloquePadre(), t, nombre, valor));
		
	}

}
