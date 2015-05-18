package hanoi;

/**
 *Autor: Enrique Moreno Agraso
 */

public class Disco {
	//ATRIBUTOS
	private int tamaño;

	//CONSTRUCTORES
	/**
	 * Constructo con el parámetro tamaño.
	 * @param tamaño Tamaño del disco.
	 */
	public Disco(int tamaño) {
		this.tamaño = tamaño;
	}
	
	/**
	 * Constructor vacio.
	 */
	public Disco(){	
	}
	
	//GETTERS & SETTERS
	/** 
	 * Devuelve el tamaño del Disco.
	 * @return tamaño Tamaño del disco.
	 */
	public int getTamaño() {
		return tamaño;
	}
	
	/**
	 * Establece el tamaño de un disco.
	 * @param tam Tamaño de un disco.
	 */
	public void setTamaño(int tam){
		tamaño=tam;
	}
}
