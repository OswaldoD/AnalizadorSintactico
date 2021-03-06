package logic;
/**
 * Clase que modela los Tokens
 * Atributos:
 *           Familia -> n�mero de familia al que pertenece el token
 *           Lexema -> string como viene en el archivo
 *           Informaci�n Adicional -> fila del token, columna inicio, columna fin del token
 *           C�digo de error -> si es un error se genera un n�mero, caso contrario es 0
 *           
 * */
public class Token {
	
	private int familia;
	private String lexema;
	private int[] inf_adicional;
	private int cod_error;
	
	public Token(){
		this.familia = 0;
		this.lexema = "";
		this.inf_adicional = new int[3];
		this.inf_adicional[0] = 0; //fila-linea
		this.inf_adicional[1] = 0; //columna-inicio
		this.inf_adicional[1] = 0; //columna-fin
		this.cod_error = 0;
		
	}
	public void setFamilia(int familia){
		this.familia = familia;
	}
	
	public void setLexema(String lexema){
		this.lexema = lexema;
	}
	public void setInfAdicional(int posicion, int informacion){
		this.inf_adicional[posicion] = informacion;
	}
	public void setCodError(int error){
		this.cod_error = error;
	}
	
	public int getFamilia(){
		return this.familia;
	}
	public String getLexema(){
		return this.lexema;
	}
	public int[] getInfAdicional(){
		return this.inf_adicional;
	}
	public int getSpecificInfAdicional(int posicion){
		return this.inf_adicional[posicion];
	}
	public int getCodeError(){
		return this.cod_error;
	}

}
