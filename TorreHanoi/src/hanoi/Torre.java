package hanoi;

/**
 *Autor: Enrique Moreno Agraso
 */

public class Torre {
	// ATRIBUTOS
	private Disco discos[];
	private int ocupacion = 0;
	
	// CONSTRUCTORES
	/**
	 * Constructor con el parametro nDiscos.
	 * @param nDiscos Numero de discos de la torre.
	 */
	public Torre(int nDiscos) {
		discos = new Disco[nDiscos];
	}
	
	/**
	 * Constructor vacio.
	 */
	public Torre(){
	}
	
	//GETTERS & SETTERS
	/**
	 * Devuelve la longitud del array discos de la torre.
	 * @return disc.length Longitud del array discos.
	 */
	public int getNumDiscos(){
		return discos.length;
	}
	
	/**
	 * Devuelve la ocupación del disco dentro de la torre.
	 * @return ocupacion Ocupacion del disco en la torre.
	 */
	public int getOcupacion(){
		return ocupacion;
	}
	
	/**
	 * Establece la ocupación del disco dentro de la torre.
	 * @param ocu Ocupacion del disco en la torre.
	 */
	public void setOcupacion(int ocu){
		ocupacion=ocu;
	}

	// MÉTODOS
	
	/**
	 * Introduce un disco en la torre.
	 * @param d Disco.
	 */
	public void introducir(Disco d){
		discos[ocupacion]=d;
		ocupacion++;
	}
	
	/**
	 * Saca un disco de la torre.
	 * @return Disco
	 */
	public Disco sacar(){
		ocupacion--;
		Disco d =discos[ocupacion];
		return d;
	}
	
	/**
	 * Devuelve el tamaño del último disco.
	 * @return tamaño Tamaño ultimo disco.
	 */
	public int getSizeUltimoDisco(){
		return (ocupacion==0)?-1:discos[ocupacion-1].getTamaño();
	}
	
	public int getSizeDisco(int pos){
		return(discos[pos].getTamaño());
	}
	
	public void setSizeDisco(int pos, int size){
		discos[pos].setTamaño(size);
	}
	
	/**
	 * Devuelve un string con lo que hay en la torre.
	 */
	public void imprimir(){
		String torre ="(";
		for (int i = 0; i < ocupacion; i++) {
			torre+= discos[i].getTamaño();
			
		}
		torre+=")";
		System.out.println(torre);
	}
}
