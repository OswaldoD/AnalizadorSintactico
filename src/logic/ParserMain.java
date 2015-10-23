package logic;

import java.util.Hashtable;
import java.util.Stack;

import Gramatica.Gramatica;
import tablaSimbolos.DatoGuardado;
import tablaSimbolos.DatoGuardadoFactory;
/**
 * Clase que maneja el parser del compilador
 * Atributos:
 * 			 pila_parsing Pila para manejar el parsing
 * 	         scanner instancia del scanner, para acceder a los métodos de obtener tokens
 * Métodos:
 *         driverParsing
 *         isPuntoSeguro
 *         PuntoSeguro
 *         
 * El método driverParser corresponde al controlador que maneja el parser del compilador
 * */
public class ParserMain extends Gramatica {

	private Stack<Integer> pila_parsing;
	private Scanner scanner;
	//private Token token;
	
	private Hashtable<String, DatoGuardado> TablaSimbolosGlobal; //Tabla de símbolos
	private DatoGuardadoFactory dataFactory;
	private Stack<String> pilaParalelaDeTipos;
	
	public ParserMain(String rutaArchivo, String rutaTransiciones, String rutaEFinales){
		scanner = new Scanner(rutaArchivo, rutaTransiciones, rutaEFinales);
		
		
		TablaSimbolosGlobal = new Hashtable<String, DatoGuardado>();
		
		dataFactory = new DatoGuardadoFactory();
		
	}

	
	/**
	 * Método que corresponde al driver del Parser
	 * @param d
	 * @return r
	 * 
	 * */
	public void driverParser(){
		char[] ePuntoSeguro = {':',')','}',']'};
		//), } ]
		Token token_actual = new Token();
		
		token_actual = scanner.demeToken();
		
		pila_parsing = new Stack<Integer>();

		pila_parsing.push(NO_TERMINAL_INICIAL); //push del simbolo inicial
		
		while (!(token_actual.getLexema().equals("FIN DE ARCHIVO"))){ // fin de archivo
			
			System.out.println("Se genera el lexema " + token_actual.getLexema() + " con la familia " + token_actual.getFamilia());

			token_actual = scanner.demeToken();
			
			char caracter_seguro = scanner.getArchivo().demeSiguienteCaracter();
			
			int EAP = pila_parsing.pop();
			
			if(esTerminal(EAP)){
				if(match(EAP, token_actual.getFamilia())){
					token_actual = scanner.demeToken();
				}
				else{
					// Manejaremos errores en punto seguro
					/*
					 * Los posibles puntos seguros serán
					 * : ) } ] 
					 * 
					 * */
					System.out.println("ErrorSintáctico");
					
					puntoSeguro(ePuntoSeguro, caracter_seguro); // error punto seguro
				}	
			}
			/**
			 * Acá se implementa el analizador semántico
			 * 
			 * */
			else if (esSimboloSemantico(EAP)){
				switch(EAP){
					case 6:
						    break;
					case 7:
						    DatoGuardado datoGuardado = dataFactory.createDatoGuardado("variable", "x", "B", "30");
						    System.out.println(datoGuardado.getDescripcion());
							System.out.println("HOLA TENGO SUEÑO OCUPO SIMBOLOS SEMANTICOS GG YA FUE");
							
							TablaSimbolosGlobal.put("lexema", datoGuardado);
							
						    break;
					default:
							break;
				}
			}
			else{
				/*
				 * Si no es terminal, entonces es no-terminal
				 * Debemos buscar en las reglas de la gramática por que terminales se 
				 * debe cambiar el no terminal.
				 * */
				int Regla = getTablaParsing(EAP-NO_TERMINAL_INICIAL, token_actual.getFamilia());
				// Regla = TP[EAP-SímboloInicial][token_actual.getFamilia()
				if(Regla < 0 ){
					System.out.println("Error Sintactico " + Regla);
				}
				else{
					//.getLadosDerechos(Regla, i);
					int i = 0;
					
					  while( (getLadosDerechos(Regla, i) > -1) && (i < MAX_LADO_DER) ){
					  		pila_parsing.push( getLadosDerechos(Regla, i) );
					  		i++;
					  }
				}
			}
			if( !(pila_parsing.isEmpty()) ){
				System.out.println("Fin de Archivo inesperado");
			}
			else{
				System.out.println("Compilacion terminada");
			}	
		}
	}
	/**
	 * Metodo que evalua si hacen match
	 * @param int EAP 
	 * @param int familia_Actual
	 * */
	private boolean match (int EAP, int familia_Actual){
		if(EAP == familia_Actual ){
			return true;
		}
		else{
			return false;
		}
		
	}
	/**
	 * Retorna true si caracter es un elemento de punto seguro, es 
	 * decir si se está en un punto seguro
	 * @param char caracter caracter a revisar
	 * @return boolean true si esta en punto seguro, false en caso contrario
	 * 
	 * */
	private boolean isPuntoSeguro(char[] ePuntoSeguro, char caracter){
		boolean estado = false;
		for(int i = 0; i < ePuntoSeguro.length; i++){
			if(ePuntoSeguro[i] == caracter){
				estado = true;
			}
		}
		return estado;
	}
	/**
	 * Manejo de errores punto seguro
	 * Busca un punto seguro que puede ser : ) } ] 
	 * Para eso se mueve en el archivo de entrada
	 * @param char[] ePuntoSeguro arreglo de los posibles puntos seguros del programa
	 * @param char caracter_seguro caracter que se desea que sea seguro
	 * */
	private void puntoSeguro(char[] ePuntoSeguro, char caracter_seguro){
		while( !(isPuntoSeguro(ePuntoSeguro, caracter_seguro)) ){
			
			caracter_seguro = scanner.getArchivo().demeSiguienteCaracter();
		}
	}
}
