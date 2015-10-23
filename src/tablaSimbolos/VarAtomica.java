package tablaSimbolos;
/**
 * Clase para manejar variables atómicas
 * 
 * */
public class VarAtomica extends DatoGuardado{
	
	
	
	public VarAtomica(String queSoy, String ID, String tipo, String valorInicial){
		super(queSoy, ID, tipo, valorInicial);
		
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "variable atómica";
	}

}
