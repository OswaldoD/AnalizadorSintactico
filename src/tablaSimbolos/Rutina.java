package tablaSimbolos;
/**
 * Clase que maneja las rutinas en la tabla de símbolos
 * 
 * Atributos:
 *           El atributo parametros es una lista de tuplas que representan
 *           los parámetros de las rutinas
 * 
 * */
public class Rutina extends DatoGuardado{
	
	Tuple<String, String> [] parametros; 
	
	public Rutina(String queSoy, String ID, 
			String tipo, Tuple<String, String>[] parametros){
		super(queSoy, ID, tipo, parametros);
		setParametros(parametros);
		
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "rutina";
	}
	
	/**
	 * Asigna los parametros.
	 * */
	public void setParametros(Tuple<String, String> [] parametros){
		this.parametros = parametros;
	}
	
	/**
	 * 
	 */
	public Tuple<String, String>[] getParametros(){
		return this.parametros;
	}

}
