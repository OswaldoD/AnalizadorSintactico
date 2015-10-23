package tablaParsing;

public abstract class DatoGuardado {
	
	private String queSoy;
	private String ID;
	private String tipo;
	private String valorInicial;
	/*
	private
	*/
	
	public DatoGuardado(){
		
	}
	
	public abstract String getDescripcion();
	
	public abstract String queSoy();

}
