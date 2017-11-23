package Parser;
import Bloque.Bloque;
import Tokenizer.Tokenizer;

public abstract class Parser<T extends Bloque> {
	
	public abstract boolean puedeParsear(String linea);
	public abstract T parse(Bloque bloquePadre, Tokenizer tokenizer);
	
}
