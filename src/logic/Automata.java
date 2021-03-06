package logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que modela el aut�mata del scanner
 * Atributos:
 *           rutaTransiciones
 *           rutaFinales
 *           Matriz_Transiciones
 *           Estados_Finales
 * 
 * */
public class Automata {
	private String rutaTransiciones;
	private String rutaFinales;
	
	private ArrayList<Transicion> Matriz_Transiciones = new ArrayList<Transicion>();
	private ArrayList<Integer> Estados_Finales = new ArrayList<Integer>();
	
	/**
	 * Constructor de la clase
	 * @param rutaTransiciones
	 * 
	 * */
	public Automata(String rutaTransiciones, String rutaFinales){
		this.rutaTransiciones = rutaTransiciones;
		this.rutaFinales = rutaFinales;
		
		fillMatrizTransiciones();
		fillMatrizEstadosFinales();
	}
	
	public void fillMatrizTransiciones(){
		
		try{
		//	rutaTransiciones = "G:/Documentos/Workspace - Eclipse/AnalizadorSintactico/src/data/matriz_transiciones.txt";
			BufferedReader entrada = new BufferedReader(new FileReader(rutaTransiciones));
			String lectura;
			
			while((lectura = entrada.readLine()) != null){
				String[] trans = lectura.split(",");
			
				
				
				int estado_inicial = Integer.parseInt(trans[0]);
				char caracter = (char) trans[1].charAt(0);
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
		try{
			BufferedReader entrada = new BufferedReader(new FileReader(rutaFinales));
			String lectura;
			
			while((lectura = entrada.readLine()) != null){
				int estado_guardar = Integer.parseInt(lectura);
				
				Estados_Finales.add(estado_guardar);
				
			}
			entrada.close();
			
		} catch (IOException e){
			
		}
		
	}
	
	public ArrayList<Transicion> getTransiciones(){
		return this.Matriz_Transiciones;
	}
	public ArrayList<Integer> getEstadosFinales(){
		return this.Estados_Finales;
	}
	
	public boolean isEstadoFinal(int estado){
		return Estados_Finales.contains(estado);
		
	}
}
