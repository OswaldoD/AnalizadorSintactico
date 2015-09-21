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
		
		/*
		 * las asignaciones hay que quitarlas de aqui y hacerlas metodos que retornen
		 * para mostrar mensajes de exito al cargar N estados finales N transiciones
		 * */
		automata = new Automata(this.rutaTransiciones, this.rutaEFinales);
		
		archivo = new ManejaArchivo(this.rutaArchivo);
		archivo.loadFile();
		
		/*archivo.demeSiguienteCaracter();*/
		
		System.out.println(automata.getTransiciones().get(0).getCaracter());
		System.out.println("Cargando transiciones...");
		System.out.println(automata.getTransiciones().size() + "transiciones cargadas");
		System.out.println("Cargando estados...");
		System.out.println(automata.getEstadosFinales().size() + " estados cargados");
		System.out.println("Cargando archivo...");
		System.out.println(archivo.getFileLoades() + " lineas cargadas");
		/*
		for(int i = 0; i<automata.getTransiciones().size(); i++){
			System.out.println("Estado inicio " + automata.getTransiciones().get(i).getEstadoInicial() + 
					           " Caracter " + automata.getTransiciones().get(i).getCaracter() + 
					           " Estado final " + automata.getTransiciones().get(i).getEstadoFinal());
		}*/
		
		
		/*InicializaScanner();*/

		
	}
	public void InicializaScanner(){
		System.out.println("Inicializando Scanner");
		
		Token token = new Token();
		token = demeToken();
		
		System.out.println("Se genera el lexema " + token.getLexema() + " con la familia " + token.getFamilia());
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
					(estado_actual == automata.getTransiciones().get(i).getEstadoInicial())){
					// 210,A,211
					estado_actual = automata.getTransiciones().get(i).getEstadoFinal();
					lexema += caracter;
					columna_fin++;
					System.out.println("formando lexema " + lexema + " estado siguiente " + estado_actual);
					//caracter = archivo.demeSiguienteCaracter();
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

}
