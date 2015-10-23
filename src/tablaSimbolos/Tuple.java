package tablaSimbolos;

/**
 * 
 * Clase para implementar tuplas de los par�metros de una rutina o funci�n
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
	 * M�todo que retorna el primer valor de la tupla
	 * @return X el primer valor de la tupla
	 * */
	public X getFirst(){
		return this.x;
	}
	
	/**
	 * M�todo que retorna el segundo valor de la tupla
	 * @return Y el segundo valor de la tupla
	 * */
	public Y getSecond(){
		return this.y;
	}
	
	/**
	 * M�todo que retorna los valores de la tupla como String
	 * @return String (x,y)
	 * */
	@Override
	public String toString(){
		return "(" + x + "," + y + ")";
	}
	
	/**
	 * M�todo que indica si una tupla es igual a otra.
	 * @param objeto una tupla v�lida
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
