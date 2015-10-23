package tablaSimbolos;

public class VarArreglo extends DatoGuardado {

	int tamanno;
	String tipoAlmacenado;
	
	public VarArreglo(String queSoy, String ID, String tipo, String valorInicial, int tamanno, String tipoAlmacenado){
		super(queSoy, ID, tipo, valorInicial, tamanno, tipoAlmacenado);
		
		setTamanno(tamanno);
		setTipoAlmacenado(tipoAlmacenado);
	}
	
	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "variable estructural arreglo";
	}

	@Override
	public String queSoy() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setTamanno(int tamanno){
		this.tamanno = tamanno;
	}
	
	public int getTamanno(){
		return this.tamanno;
	}
	
	public void setTipoAlmacenado(String tipoAlmacenado){
		this.tipoAlmacenado = tipoAlmacenado;
	}
	
	public String setTipoAlmacenado(){
		return this.tipoAlmacenado;
	}
	

}
