/*
 * GTablaFollows.java
 *
 * 2015/09/17 19:21:20
 *
 * Archivo generado por GikGram 2.0
 *
 * Copyright � Olminsky 2011 Derechos reservados
 * Reproducci�n sin fines de lucro permitida
 */

package Gramatica;

/**
 * Esta clase contiene la tabla de follows
 * y los m�todos necesarios para acceder a ella
 */
abstract class GTablaFollows
{
	/**
	 * Tabla de follows
	 * Contiene los n�meros de los terminales
	 * de los follows de cada no-terminal (filas)
	 */
	private static final int[][] TablaFollows =
	{

/* S */ { Gramatica.MARCA_DERECHA,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
/* cuerpo */ { Gramatica.MARCA_DERECHA,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
/* preentrada */ { Gramatica.MARCA_DERECHA,28,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
/* const */ { Gramatica.MARCA_DERECHA,39,8,9,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
/* constAux */ { Gramatica.MARCA_DERECHA,39,8,9,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
/* literal */ { Gramatica.MARCA_DERECHA,16,104,105,99,101,97,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
/* type */ { Gramatica.MARCA_DERECHA,8,9,13,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
/* definirTipo */ { Gramatica.MARCA_DERECHA,8,9,13,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
/* definirTipoAux */ { Gramatica.MARCA_DERECHA,8,9,13,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
/* variable */ { Gramatica.MARCA_DERECHA,9,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
/* varAux */ { Gramatica.MARCA_DERECHA,9,40,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
/* mismoTipo */ { Gramatica.MARCA_DERECHA,21,26,51,43,18,3,59,16,9,40,105,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
	};

	/**
	 * M�todo getTablaFollows
			Obtiene el n�mero de terminal del follow del no-terminal
	 * @param numNoTerminal
			N�mero de no-terminal
	 * @param numColumna
			N�mero de columna
	 */
	static final int getTablaFollows(int numNoTerminal, int numColumna)
	{
		return TablaFollows[numNoTerminal][numColumna];
	}
}
