package Recursos;

public interface Tipo {
	
	
	public static Tipo emparejar(String str) {
		try {
			return TipoPreestablecido.valueOf(str.toUpperCase());
		}
		catch(Exception ex){
			return null;
		}
	}
}
