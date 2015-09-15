package logic;

public class Scanner {
	
	private Automata Automata;
	private ManejaArchivo Archivo;
	
	
	public Scanner(){
		
		Automata automata = new Automata();
		
		
		System.out.println(automata.getTransiciones().get(0).getCaracter());
		
	}

}
