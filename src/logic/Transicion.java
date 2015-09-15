package logic;

public class Transicion{

	private int estado_inicial;
	private String caracter;
	private int estado_final;
	
	public Transicion(int estado_inicial, String caracter, int estado_final){
		this.estado_inicial = estado_inicial;
		this.caracter = caracter;
		this.estado_final = estado_final;
		
	}
	
	public int getEstadoInicial(){
		return this.estado_inicial;
	}
	public String getCaracter(){
		return this.caracter;
	}
	public int getEstadoFinal(){
		return this.estado_final;
	}
}
