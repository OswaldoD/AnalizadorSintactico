package logic;
/**
 * Clase que modela las transiciones del autómata
 * Atributos:
 *           Estado Inicial
 *           Caracter
 *           Estado Final
 *           
 * */
public class Transicion{

	private int estado_inicial;
	private char caracter;
	private int estado_final;
	
	public Transicion(int estado_inicial, char caracter, int estado_final){
		this.estado_inicial = estado_inicial;
		this.caracter = caracter;
		this.estado_final = estado_final;
		
	}
	
	public int getEstadoInicial(){
		return this.estado_inicial;
	}
	public char getCaracter(){
		return this.caracter;
	}
	public int getEstadoFinal(){
		return this.estado_final;
	}
}
