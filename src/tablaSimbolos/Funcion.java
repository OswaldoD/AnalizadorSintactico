package tablaSimbolos;
/**
 * Clase que maneja las rutinas en la tabla de símbolos
 * 
 * Atributos:
 *           El atributo parametros es una lista de tuplas que representan
 *           los parámetros de las funciones
 * 
 * */
public class Funcion extends DatoGuardado{
	
	Tuple<String, String> [] parametros; 
	
	public Funcion(String queSoy, String ID, 
			String tipo, Tuple<String, String>[] parametros){
		super(queSoy, ID, tipo, parametros);
	}

	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "funcion";
	}
	
	public void setParametros(Tuple<String, String> [] parametros){
		this.parametros = parametros;
	}
	
	public Tuple<String, String> [] getParametros(){
		return this.parametros;
	}
	
}
