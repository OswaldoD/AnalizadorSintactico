package tablaSimbolos;
/**
 * 
 * Clase que se encarga de Fabricar los diferentes tipos de datos
 * que requiera la tabla de símbolos
 * 
 * */

public class DatoGuardadoFactory implements DatoGuardadoFactoryMethod{

	/**
	 * Construcción de variables y constantes
	 * 
	 * */
	public DatoGuardado createDatoGuardado(String queSoy, String ID,
			String tipo, String valorInicial) {
		// TODO Auto-generated method stub
		if (queSoy.equals("variable")){
			return new VarAtomica(queSoy, ID,
				tipo, valorInicial);
		}
		else{
			return new Constante(queSoy, ID,
					tipo, valorInicial);
		}
	}

	/**
	 * Construcción de Arreglos
	 * */
	public DatoGuardado createDatoGuardado(String queSoy, String ID,
			String tipo, String valorInicial, int tamanno, String tipoAlmacenado) {
		// TODO Auto-generated method stub
		return new VarArreglo(queSoy, ID,
			tipo, valorInicial, tamanno, tipoAlmacenado);
	}

	/**
	 * Construcción de Registros
	 * */
	public DatoGuardado createDatoGuardado(String queSoy, String ID,
			String tipo, String[] listaCampos) {
		// TODO Auto-generated method stub
		return new VarRegistro(queSoy, ID,
			tipo, listaCampos);
	}

	/**
	 * Construcción de Funciones y Rutinas
	 */
	public DatoGuardado createDatoGuardado(String queSoy, String ID,
			String tipo, Tuple<String, String>[] parametros) {
		// TODO Auto-generated method stub
		if(queSoy.equals("rutina")){
			return new Rutina(queSoy, ID,
			tipo, parametros);
		}
		else{
			return new Funcion(queSoy, ID,
			tipo, parametros);
		}
	}
	

}
