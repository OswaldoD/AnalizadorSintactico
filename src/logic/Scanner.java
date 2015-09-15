package logic;

public class Scanner {
	
	
	private String rutaTransiciones;
	private String rutaEFinales;
	private String rutaArchivo;
	private Automata Automata;
	private ManejaArchivo Archivo;
	
	
	public Scanner(String rutaArchivo, String rutaTransiciones, String rutaEFinales){
		
		this.rutaArchivo = rutaArchivo;
		this.rutaTransiciones = rutaTransiciones;
		this.rutaEFinales = rutaEFinales;
		
		
		Automata automata = new Automata(rutaTransiciones, rutaEFinales);
		
		ManejaArchivo archivo = new ManejaArchivo(rutaArchivo);
		archivo.loadFile();
		
		archivo.demeSiguienteCaracter();
		
		System.out.println(automata.getTransiciones().get(0).getCaracter());
		
	}

}
