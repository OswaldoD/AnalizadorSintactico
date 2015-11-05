package generador;

import java.io.FileWriter;
import java.io.PrintWriter;

public class EscribeArchivo {
	
	String ruta;
	String segmentoPila;
	String segmentoDatos;
	String segmentoCodigo;
	
	public EscribeArchivo(String ruta){
		this.ruta = ruta;
		
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
			
			//for(int i=0;i<escribir.size(); i++){
				//archivo_escribir.println("\n"+escribir.get(i));
				archivo_escribir.println(segmentoPila);
				archivo_escribir.println(segmentoDatos);
				archivo_escribir.println(segmentoCodigo);
			//}
			//archivo_escribir.println("Hola modificado");
			
			
			archivo_escribir.close();
			
			return true;
			
		}catch (Exception e){
			e.printStackTrace();
			
			return false;
			
		}
	}
}
