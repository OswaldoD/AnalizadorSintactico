package tablaSimbolos;
/**
 * Clase para guardar las constantes en la tabla de símbolos
 * 
 * */
public class Constante extends DatoGuardado {
	
	
	
	public Constante(String queSoy, String ID, String tipo, String valorInicial){
		super(queSoy, ID, tipo, valorInicial);
		
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "variable atómica constante";
	}

	@Override
	public String queSoy() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
