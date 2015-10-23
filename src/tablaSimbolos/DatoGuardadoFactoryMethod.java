/**
 * 
 */
package tablaSimbolos;

/**
 * @author Phoenix
 *
 */
public interface DatoGuardadoFactoryMethod {
	
	public DatoGuardado createDatoGuardado(String queSoy, String ID, 
			String tipo, String valorInicial);
	
	public DatoGuardado createDatoGuardado(String queSoy, String ID, 
			String tipo, String valorInicial, int tamanno, String tipoAlmacenado);
	
	public DatoGuardado createDatoGuardado(String queSoy, String ID, String tipo, String[] listaCampos);
	

}
