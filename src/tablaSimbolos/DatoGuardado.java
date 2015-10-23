package tablaSimbolos;

public abstract class DatoGuardado {
	
	private String queSoy;
	private String ID;
	private String tipo;
	private String valorInicial;

	
	/**
	 * constructor de Variables at�micas y constantes
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
	 * Constructor de las funciones
	 * @return
	 */
	public DatoGuardado(){
		
	}
	
	/**
	 * Constructor de las rutinas
	 * @return
	 */
	public DatoGuardado(String queSoy, String ID, String tipo, Tuple<String, String>[] parametros){
		
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
