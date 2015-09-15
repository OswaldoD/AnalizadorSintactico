package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ManejaArchivo {
	private int fila = -1;
	private int columna = 0;
	private ArrayList<String> file_load = new ArrayList<String>();
	private String rutaArchivo;
	
	public ManejaArchivo(String rutaArchivo){
		this.rutaArchivo = rutaArchivo;
		
	}
	/**
	 * Método que carga el archivo. 
	 * Retorna true si no hubo ningun error.
	 * Retorna false si existe error e imprime stack trace del error
	 * @return boolean Estado de carga del archivo
	 * */
	public boolean loadFile( ){
		try{
			
			BufferedReader entrada = new BufferedReader(new FileReader(rutaArchivo));
			String lectura;
			
			while((lectura = entrada.readLine()) != null){
				file_load.add(lectura);
			}
			
			entrada.close();
			
			return true;
			
		} catch(IOException e){
			e.printStackTrace();
			return false;
			
		}
	}
	/**
	 * Método deme el siguiente caracter.
	 * retorna el siguiente caracter de cada linea del archivo
	 * @return caracter El siguiente caracter del archivo
	 * */
	public char demeSiguienteCaracter(){
		char caracter = ' ';
		
		actualizaContadores();
		
		caracter = file_load.get(columna).charAt(fila);

		
		return caracter;
	}
	
	/**
	 * Método tome este caracter.
	 * retorna true si lo puede regresar al buffer, false en caso contrario
	 * @param caracter Caracter a regresar al buffer
	 * @return boolean Retorna estado del caracter
	 * 
	 * */
	public boolean tomeEsteCaracter(char caracter){
		
		if(file_load.get(columna).charAt(fila) == caracter){
			
			// actualiza contadores
			
			return true;
		}
		else{
			return false;
		}
		
//		fila--;
		// columna --;
		

	}
	private void actualizaContadores(){
		if(fila > (file_load.get(columna).length()) ){
			fila=-1;
			columna++;
			
		}
		else{
			fila++;
		}
	}
}
