package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ManejaArchivo {
	private int columna = -1;
	private int fila = 0;
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
			
			limpiaEnter();
			limpiaEnter();
			
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
		try{
			
		
			actualizaContadores();
		
			caracter = file_load.get(fila).charAt(columna);
			return caracter;
		}
		catch (Exception e){
			return '¨';
		}
		//return caracter;
		
	}
	
	/**
	 * Método tome este caracter.
	 * retorna true si lo puede regresar al buffer, false en caso contrario
	 * @param caracter Caracter a regresar al buffer
	 * @return boolean Retorna estado del caracter
	 * 
	 * */
	public boolean tomeEsteCaracter(char caracter){
		
		if(file_load.get(fila).charAt(columna) == caracter){
			
			// actualiza contadores
			
			return true;
		}
		else{
			return false;
		}
		
//		fila--;
		// columna --;
		

	}
	/**
	 * Método que retorna el arrayList del archivo cargado
	 * @return file loaded ArrayList del archivo cargado
	 * */
	
	public ArrayList<String> getFileLoades(){
		return this.file_load;
	}
	private void actualizaContadores(){
		if(columna == (file_load.get(fila).length()) -1 ){
			columna=0;
			fila++;
			
		}
		else{
			columna++;
		}
	}
	private void acualizaContadores(char caracter){
		if( (fila == 0) && (columna != 0) ){ // caso fila en 0 columa no 0
			// si la fila esta en 0, columna resta 1
			fila--;
			columna--;
		}
		else if( (fila!= 0) && (columna == 0) ){ //caso columa en 0 fila no 0
			// si la fila no esta en 0, solo se resta la fila
			fila--;
		}
	}
	
	
	private void limpiaEnter(){
		for(int i =0; i < this.file_load.size(); i++){
			String newline = ""
					+ "";
			if(file_load.get(i).equals(newline)){
				file_load.remove(i);
			}
		}
		
		for(int i =0; i < this.file_load.size(); i++){
			String newline = " "
					+ "";
			if(file_load.get(i).equals(newline)){
				file_load.remove(i);
			}
		}
	}
}
