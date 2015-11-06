package generador;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Clase que escribe el archivo asm 
 * El archivo file.asm puede encontrarse en el escritorio del usuario actual
 * */

public class EscribeArchivo {
	
	String ruta;
	ArrayList<String> segmentoPila = new ArrayList<String>();
	ArrayList<String> segmentoDatos = new ArrayList<String>();
	ArrayList<String> segmentoCodigo = new ArrayList<String>();
	
	public EscribeArchivo(){
		//this.ruta = ruta;
		//C:\Users\Oswaldo + \Desktop\file.asm
		this.ruta = System.getProperty("user.home");
		this.ruta += "\\Desktop\\file.asm"; // el archivo siempre se escribe en el escritorio
		
		this.segmentoPila.add("Pila Segment para Stack 'Stack'");
		this.segmentoPila.add(" db 64 Dup ('SegStack ')");
		this.segmentoPila.add("Pila EndS");
    
		this.segmentoDatos.add("Datos Segment para 'Data'");
		this.segmentoDatos.add("var1 db 7");
		this.segmentoDatos.add("Datos EndS");
		
		this.segmentoCodigo.add("Codigo Segment para public 'Code'");
		this.segmentoCodigo.add("Begin:");
		this.segmentoCodigo.add("Assume CS:Codigo, DS:Datos, SS:Pila ;Asignación de los segmentos a los registro de segmentos del CPU.");
		this.segmentoCodigo.add("xor    ax,ax       ;Pone en cero al reg ax.");
		this.segmentoCodigo.add("mov    ax,Datos    ;Mueve la posición de SData al reg ax.");
		this.segmentoCodigo.add("mov    DS,ax       ;Mueve la posición de ax (SData) al reg DS.");
		this.segmentoCodigo.add("mov    ES,ax       ;Mueve la posición de ax (SData) al reg ES.	");
		this.segmentoCodigo.add("; aqui va el codigo");
		this.segmentoCodigo.add("MiCodigo EndS 			;Fin del segmento de código.");
		this.segmentoCodigo.add("End Begin			;Fin del programa la etiqueta al final dice en que punto debe comenzar el programa.");
		

	}

	/**
	 * Método que imprime el archivo de salida del código
	 * @param
	 * @return boolean true exito al escribir el archivo
	 * */
	public boolean escribeArchivo(){
		
		try{
			FileWriter archivo = new FileWriter(ruta,true);
			PrintWriter archivo_escribir = new PrintWriter(archivo);
			
			for(int i=0;i<segmentoPila.size(); i++){
				archivo_escribir.println(segmentoPila.get(i));
			}
			
			
			for(int i=0;i<segmentoDatos.size(); i++){
				archivo_escribir.println(segmentoDatos.get(i));
			}
			
			for(int i=0;i<segmentoCodigo.size(); i++){
				archivo_escribir.println(segmentoCodigo.get(i));
			}
			
			
			
			archivo_escribir.close();
			
			return true;
			
		}catch (Exception e){
			e.printStackTrace();
			
			return false;
			
		}
	}
}
