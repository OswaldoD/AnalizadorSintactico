package tablaSimbolos;

/**
 * 
 * Clase para implementar tuplas de los parámetros de una rutina o función
 * 
 * */
public class Tuple<X, Y> {
	
	public final X x;
	public final Y y;
	
	public Tuple(X x, Y y){
		this.x = x;
		this.y = y;
	}
	/**
	 * Método que retorna el primer valor de la tupla
	 * @return X el primer valor de la tupla
	 * */
	public X getFirst(){
		return this.x;
	}
	
	/**
	 * Método que retorna el segundo valor de la tupla
	 * @return Y el segundo valor de la tupla
	 * */
	public Y getSecond(){
		return this.y;
	}
	
	/**
	 * Método que retorna los valores de la tupla como String
	 * @return String (x,y)
	 * */
	@Override
	public String toString(){
		return "(" + x + "," + y + ")";
	}
	
	/**
	 * Método que indica si una tupla es igual a otra.
	 * @param objeto una tupla válida
	 * @return true si la tupla es igual a otra, false en caso contrario
	 * */
	@Override
	public boolean equals(Object objeto){
		if(objeto == null){
			return false;
		}
		if(objeto == this){
			return true;
		}
		if( !(objeto instanceof Tuple) ){
			return false;
		}
		
		@SuppressWarnings("unchecked")
		Tuple<X,Y> objeto_ = (Tuple<X,Y>) objeto;
		return objeto_.x == this.x && objeto_.y == this.y;
	}

}
