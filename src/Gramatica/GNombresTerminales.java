/*
 * GNombresTerminales.java
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
 * Esta clase contiene los nombres de los terminales
 * y los m�todos necesarios para acceder a ella
 */
abstract class GNombresTerminales
{
	/**
	 * Contiene los nombres de los terminales
	 */
	private static final String[] NombresTerminales =
	{
		"1",
		"0",
		" EOF "
	};

	/**
	 * M�todo getNombresTerminales
			Obtiene el nombre del terminal
	 * @param numTerminal
			N�mero del terminal
	 */
	static final String getNombresTerminales(int numTerminal)
	{
		return NombresTerminales[numTerminal];
	}
}
