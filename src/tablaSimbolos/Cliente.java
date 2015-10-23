package tablaSimbolos;

/**
 * Esta clase es para probar que los elementos de la tabla de símbolos
 * se creen de forma correcta
 * */
public class Cliente {
	
	public static void main (String[] args){
		
		Tuple<String, String> parametro = new Tuple<String, String>("int", "x");
		
		Tuple<String, String> [] parametros = new Tuple[3]; 
		parametros[0] = parametro;
		System.out.println(parametros[0].getFirst());
		
		DatoGuardadoFactory factory = new DatoGuardadoFactory();
		DatoGuardado datoGuardadoV = factory.createDatoGuardado("variable", "x", "B", "30");
		System.out.println(datoGuardadoV.getDescripcion());
		
		DatoGuardado datoGuardadoC = factory.createDatoGuardado("constante", "x", "B", "30");
		System.out.println(datoGuardadoC.getDescripcion());
		
		DatoGuardado datoGuardadoA = factory.createDatoGuardado("arreglo", "x", "A", "30", 10, "I");
		System.out.println(datoGuardadoA.getDescripcion());
		
		String[] hola = new String[3];
		
		DatoGuardado datoGuardadoR = factory.createDatoGuardado("arreglo", "x", "R", hola);
		System.out.println(datoGuardadoR.getDescripcion());
	}

}
