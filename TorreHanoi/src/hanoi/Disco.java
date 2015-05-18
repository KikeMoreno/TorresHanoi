package hanoi;

/**
 *Autor: Enrique Moreno Agraso
 */

public class Disco {
	//ATRIBUTOS
	private int tama�o;

	//CONSTRUCTORES
	/**
	 * Constructo con el par�metro tama�o.
	 * @param tama�o Tama�o del disco.
	 */
	public Disco(int tama�o) {
		this.tama�o = tama�o;
	}
	
	/**
	 * Constructor vacio.
	 */
	public Disco(){	
	}
	
	//GETTERS & SETTERS
	/** 
	 * Devuelve el tama�o del Disco.
	 * @return tama�o Tama�o del disco.
	 */
	public int getTama�o() {
		return tama�o;
	}
	
	/**
	 * Establece el tama�o de un disco.
	 * @param tam Tama�o de un disco.
	 */
	public void setTama�o(int tam){
		tama�o=tam;
	}
}
