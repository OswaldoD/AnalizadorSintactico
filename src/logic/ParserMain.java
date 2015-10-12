package logic;

import java.util.Stack;

public class ParserMain {

	private Stack<String> pila_parsing;
	private Scanner scanner;
	private Token token;
	
	public ParserMain(String rutaArchivo, String rutaTransiciones, String rutaEFinales){
		scanner = new Scanner(rutaArchivo, rutaTransiciones, rutaEFinales);
/*
.setRutaArchivo(rutaArchivo);
		scanner.setRutaTransiciones(rutaTransiciones);
		scanner.setRutaFinales(rutaEFinales);*/

		
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
		
		
		while (!(token_actual.getLexema().equals("FIN DE ARCHIVO"))){ // fin de archivo
			System.out.println("Se genera el lexema " + token_actual.getLexema() + " con la familia " + token_actual.getFamilia());

			token_actual = scanner.demeToken();
			String EAP = pila_parsing.pop();
			
			if(terminal(EAP)){
				if(match(EAP, token_actual.getLexema())){
					token_actual = scanner.demeToken();
				}
				else{
					System.out.println("ErrorSintáctico");
				}	
			}
			else{
				int Regla = 0;
				// Regla = TP[EAP-SímboloInicial][token_actual.getFamilia()
				if(Regla < 0 ){
					System.out.println("Error Sintactico " + Regla);
				}
				else{
					int i = 0;
					/*
					  while( (TLD[Regla][i] > -1) and (i < MAXLADODER) ){
					  		push(TLD[Regla][i]
					  		i++;
					  
					  }
					  
					 * */
				}
			}
			if( !(pila_parsing.isEmpty()) ){
				System.out.println("Fin de Archivo inesperado");
			}

			
		}
		System.out.println("Compilacion terminada");
			
			
		
		
		

		
	}
	private boolean terminal(String EAP){
		return true;
	}
	private boolean match (String EAP, String token_Actual){
		return true;
	}
}
