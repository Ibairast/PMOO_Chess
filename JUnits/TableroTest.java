import static org.junit.Assert.*;

import org.junit.Test;

public class TableroTest {
	//Los metodos y atributos han sido publicados para realizar estas pruebas
	Jugador j1 = new Jugador(Color.WHITE, "1");
	Jugador j2 = new Jugador(Color.BLACK, "2");
	Tablero tablero = Tablero.getTablero();

	
	@Test
	public void testGetTablero() {
		assertNotNull(Tablero.getTablero());
	}




	@Test
	public void testRealizarMovimiento() {
		Tablero.getTablero().inicializarPiezas();
		Tablero.getTablero().turnoJugador=j1;
		Tablero.getTablero().jugador1=j1;
		Tablero.getTablero().jugador2=j2;
		
		//Mover el peon una posición
		Posicion posfin = new Posicion(2, 0);
		Ficha ficha = Tablero.getTablero().matrix[1][0];
	
		ficha.realizarMovimiento(posfin);
		
		assertNull(Tablero.getTablero().matrix[1][0]);
		assertNotNull(Tablero.getTablero().matrix[2][0]);
	
		//Mover el peon dos posiciones
		posfin = new Posicion(3, 1);
		ficha = Tablero.getTablero().matrix[1][1];

		ficha.realizarMovimiento(posfin);
		Tablero.getTablero().print();
		assertNull(Tablero.getTablero().matrix[1][1]);
		assertNotNull(Tablero.getTablero().matrix[3][1]);
		
		//Mover la torre
		posfin = new Posicion(1, 0);
		ficha = Tablero.getTablero().matrix[0][0];

		ficha.realizarMovimiento(posfin);
		Tablero.getTablero().print();
		assertNull(Tablero.getTablero().matrix[0][0]);
		assertNotNull(Tablero.getTablero().matrix[1][0]);
		
		//Mover el caballo
		posfin = new Posicion(2, 2);
		ficha = Tablero.getTablero().matrix[0][1];

		ficha.realizarMovimiento(posfin);
		Tablero.getTablero().print();
		assertNull(Tablero.getTablero().matrix[0][1]);
		assertNotNull(Tablero.getTablero().matrix[2][2]);
		
		//Mover el alfil
		posfin = new Posicion(1, 1);
		ficha = Tablero.getTablero().matrix[0][2];

		ficha.realizarMovimiento(posfin);
		Tablero.getTablero().print();
		assertNull(Tablero.getTablero().matrix[0][2]);
		assertNotNull(Tablero.getTablero().matrix[1][1]);
		
		//Mover la reina
		Tablero.getTablero().matrix[1][2]=null;
		posfin = new Posicion(3, 0);
		ficha = Tablero.getTablero().matrix[0][3];

		ficha.realizarMovimiento(posfin);
		Tablero.getTablero().print();
		assertNull(Tablero.getTablero().matrix[0][3]);
		assertNotNull(Tablero.getTablero().matrix[3][0]);
		
		//Mover el rey
		posfin = new Posicion(0, 3);
		ficha = Tablero.getTablero().matrix[0][4];

		ficha.realizarMovimiento(posfin);
		Tablero.getTablero().print();
		assertNull(Tablero.getTablero().matrix[0][4]);
		assertNotNull(Tablero.getTablero().matrix[0][3]);
		

	}

	@Test
	public void testInicializarPiezas() {
		//Comprobacion visual
		Tablero.getTablero().jugador1=j1;
		Tablero.getTablero().jugador2=j2;
		Tablero.getTablero().turnoJugador=j1;

		Tablero.getTablero().inicializarPiezas();
		Tablero.getTablero().print();
	}

	@Test
	public void testLetraToNum() {
		
		assertEquals(Tablero.getTablero().letraToNum('A'),0);
		assertEquals(Tablero.getTablero().letraToNum('B'),1);
		assertEquals(Tablero.getTablero().letraToNum('C'),2);
		assertEquals(Tablero.getTablero().letraToNum('d'),3);
		assertEquals(Tablero.getTablero().letraToNum('e'),4);
		assertEquals(Tablero.getTablero().letraToNum('f'),5);
		assertEquals(Tablero.getTablero().letraToNum('G'),6);
		assertEquals(Tablero.getTablero().letraToNum('H'),7);
		
	}
/*	
	
	@Test
	public void testGuardarCargarPartida() {
		Tablero.getTablero().jugador1=j1;
		Tablero.getTablero().jugador2=j2;
		Tablero.getTablero().inicializarPiezas();
		Tablero.getTablero().turnoJugador=j1;
		Posicion posfin = new Posicion(2, 0);
		Ficha ficha = Tablero.getTablero().matrix[1][0];

		ficha.realizarMovimiento(posfin);

		Fichero.getFichero().guardarPartida();
		Fichero.getFichero().cargarPartida();
		
		assertNull(Tablero.getTablero().matrix[1][0]);
		assertNotNull(Tablero.getTablero().matrix[2][0]);
	}

*/	

	@Test
	public void testCambiarJugador() {
		Tablero.getTablero().cambiarJugador();
		assertEquals(Tablero.getTablero().turnoJugador,Tablero.getTablero().jugador2);
	}




}
