package logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Automata {
	private String rutaTransiciones;
	private String rutaFinales;
	
	private ArrayList<Transicion> Matriz_Transiciones = new ArrayList<Transicion>();
	private int[][] Estados_Finales;
	
	/**
	 * Constructor de la clase
	 * @param rutaTransiciones
	 * 
	 * */
	public Automata(String rutaTransiciones, String rutaFinales){
		this.rutaTransiciones = rutaTransiciones;
		this.rutaFinales = rutaFinales;
		
		fillMatrizTransiciones();
		//fillMatrizEstadosFinales();
	}
	
	public void fillMatrizTransiciones(){
		
		try{
			int i = 0;
		//	rutaTransiciones = "G:/Documentos/Workspace - Eclipse/AnalizadorSintactico/src/data/matriz_transiciones.txt";
			BufferedReader entrada = new BufferedReader(new FileReader(rutaTransiciones));
			String lectura;
			
			while((lectura = entrada.readLine()) != null){
				String[] trans = lectura.split(",");
			
				
				
				int estado_inicial = Integer.parseInt(trans[0]);
				String caracter = trans[1];
				int estado_final = Integer.parseInt(trans[2]);
				Transicion transicion = new Transicion(estado_inicial, caracter, estado_final); 
				Matriz_Transiciones.add(transicion);
				/*
				this.Matriz_Transiciones[i] = transicion;
				*/
			}
			entrada.close();
			
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}
	
	public void fillMatrizEstadosFinales(){
		
	}
	
	public ArrayList<Transicion> getTransiciones(){
		return this.Matriz_Transiciones;
	}
}
