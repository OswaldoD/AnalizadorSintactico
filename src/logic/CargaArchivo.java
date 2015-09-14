package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CargaArchivo {
	private ArrayList<String> file_load = new ArrayList<String>();
	private File file;
	
	public CargaArchivo(File file){
		this.file = file;
	}
	
	public boolean loadFile( ){
		try{
			String ruta = file.getPath();
			BufferedReader entrada = new BufferedReader(new FileReader(ruta));
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
}
