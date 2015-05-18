package hanoi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestHanoi {
	// ATRIBUTOS
	Tablero tableroFin;
	Tablero tablero1, tablero2;
	Torre torre1;
	
	@Before
	public void iniciar(){
		//Discos en la ultima torre
		tableroFin=new Tablero(4);
		tableroFin.moverDisco(0, 1);
		tableroFin.moverDisco(0, 2);
		tableroFin.moverDisco(1, 2);
		tableroFin.moverDisco(0, 1);
		tableroFin.moverDisco(2, 0);
		tableroFin.moverDisco(2, 1);
		tableroFin.moverDisco(0, 1);
		tableroFin.moverDisco(0, 2);
		tableroFin.moverDisco(1, 2);
		tableroFin.moverDisco(1, 0);
		tableroFin.moverDisco(2, 0);
		tableroFin.moverDisco(1, 2);
		tableroFin.moverDisco(0, 1);
		tableroFin.moverDisco(0, 2);
		
		//Inicializamos el tablero con 4 torres y con todos los discos en la primera torre
		tablero1=new Tablero(4);
		
		//Inicializamos una torre
		torre1=new Torre(1);
	}
	
	@Test
	public void testComprobarFin() {
		assertFalse(tableroFin.comprobarFin());
		tableroFin.moverDisco(1, 2);
		assertTrue(tableroFin.comprobarFin());
	}
	
	@Test
	public void testMoverDisco(){
		assertTrue(tablero1.moverDisco(0, 1));
	}
	
	@Test
	public void testGetSizeUltimoDisco(){
		assertEquals(torre1.getSizeUltimoDisco(),-1);
		Disco disco1=new Disco(3);
		torre1.introducir(disco1);
		assertEquals(torre1.getSizeUltimoDisco(),3);
	}

}

