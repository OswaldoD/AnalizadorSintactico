package tablaSimbolos;
/**
 * Clase que implementa los diferentes datos que se van a almacenar
 * en la tabla de símbolos
 * 
 * @author Oswaldo Dávila - 201222296
 *         Josefina Molina - 201240133
 *         
 * Los tipos de datos son: 
 * 		                  Variables atómicas: Enteros, Chars, Strings, Booleanos, Conjuntos
 *                        Variables estructurales: Arreglos y Registros
 * 					      Constantes
 *                        Funciones
 * 	                      Rutinas 
 *
 */
public abstract class DatoGuardado {
	
	private String queSoy;
	private String ID;
	private String tipo;
	private String valorInicial;

	
	/**
	 * constructor de Variables atómicas y constantes
	 * */ 
	public DatoGuardado(String queSoy, String ID, 
			String tipo, String valorInicial){
		setQueSoy(queSoy);
		setID(ID);
		setTipo(tipo);
		setValorInicial(valorInicial);
	}
	/**
	 * Constructor de los arreglos
	 * 
	 * */
	public DatoGuardado(String queSoy, String ID, 
			String tipo, String valorInicial, int tamanno, String tipoAlmacenado){
		setQueSoy(queSoy);
		setID(ID);
		setTipo(tipo);
		setValorInicial(valorInicial);
	}
	
	/**
	 * Constructor de los registros
	 * */
	public DatoGuardado(String queSoy, String ID, 
			String tipo, String[] listaCampos){
		setQueSoy(queSoy);
		setID(ID);
		setTipo(tipo);
		setValorInicial(valorInicial);
	}
	
	/**
	 * Constructor de las funcines y rutinas
	 * @return
	 */
	public DatoGuardado(String queSoy, String ID, String tipo, Tuple<String, String>[] parametros){
		setQueSoy(queSoy);
		setID(ID);
		setTipo(tipo);
	}

	public abstract String getDescripcion();
	
	/*------------------------------------------------------------------------------------------------- */
	public void setQueSoy(String queSoy){
		this.queSoy = queSoy;
	}
	public String getQueSoy(){
		return this.queSoy;
	}
	
	public void setID(String ID){
		this.ID = ID;
	}
	public String getID(){
		return this.ID;
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	public String getTipo(){
		return this.tipo;
	}
	
	public void setValorInicial(String valorInicial){
		this.valorInicial = valorInicial;
	}
	public String getValorInicial(){
		return this.valorInicial;
	}

}
