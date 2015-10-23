package tablaSimbolos;

public class Rutina extends DatoGuardado{
	
	Tuple<String, String> [] parametros; 
	
	public Rutina(String queSoy, String ID, String tipo, Tuple<String, String>[] parametros){
		super(queSoy, ID, tipo, parametros);
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "rutina";
	}

}
