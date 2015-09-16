package logic;

import java.util.ArrayList;

public class Scanner {
	
	
	private String rutaTransiciones;
	private String rutaEFinales;
	private String rutaArchivo;
	private Automata automata;
	private ManejaArchivo archivo;
	private ArrayList<Token> Tokens = new ArrayList<Token>();
	
	
	public Scanner(String rutaArchivo, String rutaTransiciones, String rutaEFinales){
		
		this.rutaArchivo = rutaArchivo;
		this.rutaTransiciones = rutaTransiciones;
		this.rutaEFinales = rutaEFinales;
		
		
		automata = new Automata(this.rutaTransiciones, this.rutaEFinales);
		
		archivo = new ManejaArchivo(this.rutaArchivo);
		archivo.loadFile();
		
		archivo.demeSiguienteCaracter();
		
		System.out.println(automata.getTransiciones().get(0).getCaracter());
		System.out.println("Cargando transiciones...");
		System.out.println(automata.getTransiciones().size() + "transiciones cargadas");
		System.out.println("Cargando estados...");
		System.out.println(automata.getEstadosFinales().size() + " estados cargados");
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
		char caracter = archivo.demeSiguienteCaracter();
		String lexema = "";
		while( !(automata.isEstadoFinal(estado_actual)) ){
			// comenzamos a recorrer todo el automata
			for(int i = 0; i < automata.getTransiciones().size(); i++){
				if( (caracter == automata.getTransiciones().get(i).getCaracter()) &&
					(estado_actual == automata.getTransiciones().get(i).getEstadoInicial())){
					// 210,A,211
					estado_actual = automata.getTransiciones().get(i).getEstadoFinal();
					lexema += caracter;
					columna_fin++;
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
