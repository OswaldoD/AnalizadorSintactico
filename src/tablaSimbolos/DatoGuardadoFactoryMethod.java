/**
 * 
 */
package tablaSimbolos;

/**
 * Interfaz que define los métodos de la fábrica de tipos de DatosGuardados
 */
public interface DatoGuardadoFactoryMethod {
	
	/*Variables atómicas y constantes */
	public DatoGuardado createDatoGuardado(String queSoy, String ID, 
			String tipo, String valorInicial);
	/* Variable compuesta arreglo */
	public DatoGuardado createDatoGuardado(String queSoy, String ID, 
			String tipo, String valorInicial, int tamanno, String tipoAlmacenado);
	
	/* Variable compuesta registro */
	public DatoGuardado createDatoGuardado(String queSoy, String ID, String tipo, String[] listaCampos);
	
	/* Rutinas y Funciones */
	public DatoGuardado createDatoGuardado(String queSoy, String ID, 
			String tipo, Tuple<String, String>[] parametros);

}
