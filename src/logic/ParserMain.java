package logic;

import java.util.Stack;

public class ParserMain {

	private Stack<String> pila_parsing;
	private Scanner scanner;
	private Token token;
	
	public ParserMain(String rutaArchivo, String rutaTransiciones, String rutaEFinales){
		scanner = new Scanner(rutaArchivo, rutaTransiciones, rutaEFinales);
	}

	
	/**
	 * Método que corresponde al driver del Parser
	 * @param d
	 * @return r
	 * 
	 * */
	public void driverParser(){
		Token token_actual = new Token();
		
		token_actual = scanner.demeToken();
		
		pila_parsing = new Stack<String>();

		pila_parsing.push("S"); //push del simbolo inicial
		
		while (token_actual.getLexema() != "EOF"){ // fin de archivo
			
			
			
		}
			
			
		
		
		

		
	}
}
