package logic;

import java.util.ArrayList;

public class Scanner {
	
	
	private String rutaTransiciones;
	private String rutaEFinales;
	private String rutaArchivo;
	private Automata automata;
	private ManejaArchivo archivo;
	private ArrayList<Token> Tokens = new ArrayList<Token>();
	private ArrayList<String> SalidaEstandar = new ArrayList<String>();
	
	
	public Scanner(String rutaArchivo, String rutaTransiciones, String rutaEFinales){
		
		this.rutaArchivo = rutaArchivo;
		this.rutaTransiciones = rutaTransiciones;
		this.rutaEFinales = rutaEFinales;
		
		automata = new Automata(this.rutaTransiciones, this.rutaEFinales);
		
		archivo = new ManejaArchivo(this.rutaArchivo);
		archivo.loadFile();
		
		
		System.out.println("Cargando transiciones...");
		System.out.println(automata.getTransiciones().size() + " transiciones cargadas \n");
		System.out.println("Cargando estados...");
		System.out.println(automata.getEstadosFinales().size() + " estados cargados \n");
		System.out.println("Cargando archivo...");
		System.out.println(archivo.getFileLoades() + " lineas cargadas \n");
		
		/*
		for(int i = 0; i<automata.getTransiciones().size(); i++){
			System.out.println("Estado inicio " + automata.getTransiciones().get(i).getEstadoInicial() + 
					           " Caracter " + automata.getTransiciones().get(i).getCaracter() + 
					           " Estado final " + automata.getTransiciones().get(i).getEstadoFinal());
		}*/
		
		
		InicializaScanner();

		
	}
	public void InicializaScanner(){
		System.out.println("Inicializando Scanner");
		
		System.out.println("Estado Finales " + automata.getEstadosFinales());
		
		/*
		Token token = new Token();
		while(!(token.getLexema().equals("FIN DE ARCHIVO"))){
		token = demeToken();
		
		
		System.out.println("Se genera el lexema " + token.getLexema() + " con la familia " + token.getFamilia());
		}*/
	}
	/**
	 * Método demeToken
	 * @param ninguno
	 * @return token el token creado
	 * */
	public Token demeToken(){
		Token token = new Token();
		int estado_actual = 210;  //estado inicial
		int columna_fin=0;
		//char caracter = archivo.demeSiguienteCaracter();
		String lexema = "";
		while( !(automata.isEstadoFinal(estado_actual)) ){
			// comenzamos a recorrer todo el automata
			char caracter = archivo.demeSiguienteCaracter();
			for(int i = 0; i < automata.getTransiciones().size(); i++){
				if( (caracter == automata.getTransiciones().get(i).getCaracter()) &&
					(estado_actual == automata.getTransiciones().get(i).getEstadoInicial()) ){
					// 210,A,211
					estado_actual = automata.getTransiciones().get(i).getEstadoFinal();
					
					columna_fin++;
					if (caracter != ' ') lexema += caracter;
			
					//System.out.println("formando lexema " + lexema + " estado siguiente " + estado_actual);
					//caracter = archivo.demeSiguienteCaracter();
					break;
				}
				
				if(caracter == '¨'){
					// FIN DE ARCHIVO
					lexema = "FIN DE ARCHIVO";
					
					estado_actual = 114; // hay que cambiarlo por marcaderecha
					break;
				}
			}
			
		}
		token.setFamilia(estado_actual);
		token.setLexema(lexema);
		token.setCodError(0);
		token.setInfAdicional(2, columna_fin);
		
		
		return token;
	}
	public void setAutomata(String rutaArchivo){
		
	}
	
	/**
	 * Asigna la ruta del archivo a cargar
	 * 
	 * */
	public void setRutaArchivo(String rutaArchivo){
		this.rutaArchivo = rutaArchivo;
	}
	
	/**
	 * Asigna la ruta del archivo del autómata
	 * */
	public void setRutaTransiciones(String rutaTransiciones){
		this.rutaTransiciones = rutaTransiciones;
	}
	
	/**
	 * Asigna la ruta del archivo que tiene los estados finales del autómata
	 * */
	public void setRutaFinales(String rutaFinales){
		this.rutaEFinales = rutaFinales;
	}
	
	public ManejaArchivo getArchivo(){
		return this.archivo;
		
	}

}
