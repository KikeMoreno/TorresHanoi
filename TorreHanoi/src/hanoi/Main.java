package hanoi;

import java.util.List;

/**
 *Autor: Enrique Moreno Agraso
 */

public class Main {
	public static void main(String[] args) {
		
		//PRUEBA ESCRITURA-GUARDAR
		Tablero tablero=new Tablero();
		//tablero.moverDisco(0, 1);
		//tablero.moverDisco(0, 2);
		//tablero.moverDisco(1, 2);
		//tablero.moverDisco(0, 1);
		//tablero.guardar();
		//tablero.imprimir();
		
		Tablero tableroFin=new Tablero(4);
		//tableroFin.moverDisco(0, 1);
		//tableroFin.moverDisco(0, 2);
		//tableroFin.moverDisco(1, 2);
		//tableroFin.moverDisco(0, 1);
		//tableroFin.moverDisco(2, 0);
		//tableroFin.moverDisco(2, 1);
		//tableroFin.moverDisco(0, 1);
		//tableroFin.moverDisco(0, 2);
		//tableroFin.moverDisco(1, 2);
		//tableroFin.moverDisco(1, 0);
		//tableroFin.moverDisco(2, 0);
		//tableroFin.moverDisco(1, 2);
		//tableroFin.moverDisco(0, 1);
		//tableroFin.moverDisco(0, 2);
		//tableroFin.moverDisco(1, 2);
		//tableroFin.imprimir();
		
		tableroFin.guardar();
		
		tablero.cargar("partida.xml");
		tablero.imprimir();
		
		
	}
}
