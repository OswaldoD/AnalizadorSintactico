package tablaSimbolos;

public class VarRegistro extends DatoGuardado {
	
	String[] listaCampos;

	public VarRegistro(String queSoy, String ID, String tipo, String[] listaCampos){
		super(queSoy, ID, tipo, listaCampos);
		setListaCampos(listaCampos);
	}
	
	@Override
	public String getDescripcion() {
		// TODO Auto-generated method stub
		return "variable estructural registro";
	}

	@Override
	public String queSoy() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setListaCampos(String[] listaCampos){
		this.listaCampos = listaCampos;
	}
	
	public String[] getListaCampos(){
		return this.listaCampos;
	}

}
