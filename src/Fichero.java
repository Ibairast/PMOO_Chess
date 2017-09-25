import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fichero {

	private static Fichero miFichero = null;
	private static String filename = "PGuardada.txt";

	//Constructora
	private Fichero(){}

	// Singleton
	public static Fichero getFichero(){
		if(miFichero == null){
			miFichero = new Fichero();
		}

		return miFichero;
	}

	public static String leerFichero(String pNombreArchivo) {

		boolean todoOk = false;
		String linea;
		String texto = "";

		while(!todoOk){
			try{
				FileReader lector = new FileReader(pNombreArchivo);
				BufferedReader b = new BufferedReader(lector);

				while((linea = b.readLine()) != null){
					texto = texto + linea + "\n";
				}

				b.close();
				todoOk = true;
			}

			catch (Exception e){
				System.out.println("Error de lectura en el fichero");
			}
		}

		return texto;
	}

	public void cargarPartida(){
		//Partida del fichero
		// Para abrir el archivo

		// Crea un array de strings con la informacion del fichero
		Ficha[][] matrix = Tablero.getTablero().getMatriz();
		String[] texto  = Fichero.leerFichero(Fichero.filename).split("\n");
		String[] jugador1 = texto[0].split("/");
		String[] jugador2 = texto[1].split("/");
		int colorJugador1 = Integer.parseInt(jugador1[1]);
		int colorJugador2 = Integer.parseInt(jugador2[1]);
		Color colorJug1;
		Color colorJug2;
		int turnoJugador = Integer.parseInt(texto[2]);

		String[] fichas = texto[3].split("/");

		if(colorJugador1 == 0){
			colorJug1 = Color.BLACK;
		} else {
			colorJug1 = Color.WHITE;
		}

		if(colorJugador2 == 0){
			colorJug2 = Color.BLACK;
		} else {
			colorJug2 = Color.WHITE;
		}

		Jugador jugad1 = new Jugador(colorJug1, jugador1[0]);
		Jugador jugad2 = new Jugador(colorJug2, jugador2[0]);
		Tablero.getTablero().setJug1(jugad1);
		Tablero.getTablero().setJug2(jugad2);

		if(turnoJugador == 1){
			Tablero.getTablero().setTurnoJugador(jugad1);
		} else {
			Tablero.getTablero().setTurnoJugador(jugad2);
		}


		for (int i = 0; i < fichas.length; i = i + 4) {

			// Try para controlar la excepcion en caso de que el archivo lo
			// hayamos escrito mal (sintaxis/ formato incorrecto: ej. se nos ha olvidado un '/')
			try {

				// POSICIONES (STRING TO INT)
				int fila = Integer.parseInt(fichas[i]);
				int columna = Integer.parseInt(fichas[i+1]);

				// PARA CREAR JUGADOR
				// En realidad ha sido para transformar de String a tipo Jugador y
				// poder llevarlo todo a la de abajo
				Jugador pJugador = null;
				if(Integer.parseInt(fichas[i+3]) == 1) {
					pJugador = jugad1;
				}
				else {
					pJugador = jugad2;
				}

				// PARA CREAR EL TIPOFICHA
				// Como arriba, para cambiar de string a tipoFicha
				Ficha tipo = null;
				switch (fichas[i+2]) {
				case "PEON":
					tipo = new Peon(pJugador, new Posicion (fila, columna));
					break;
				case "CABALLO":
					tipo = new Caballo(pJugador, new Posicion (fila, columna));
					break;
				case "ALFIL":
					tipo = new Alfil(pJugador, new Posicion (fila, columna));
					break;
				case "TORRE":
					tipo = new Torre(pJugador, new Posicion (fila, columna));
					break;
				case "REY":
					tipo = new Rey(pJugador, new Posicion (fila, columna));
					break;
				case "REINA":
					tipo = new Reina(pJugador, new Posicion (fila, columna));
					break;
				}

				// Lo importante
				matrix[fila][columna] = tipo;

				Tablero.getTablero().setMatriz(matrix);
			}

			catch (Exception e) {
				System.out.println("Error al intentar leer el archivo. Parece que Ã©ste esta daÃ±ado o mal escrito. Compruebelo.");
			}
		}
	}

	public void guardarPartida() {
		// Metodo que guarda la partida en un txt

		Jugador jugad1 = Tablero.getTablero().getJug1(); //Jugador 1 del tablero
		Jugador jugad2 = Tablero.getTablero().getJug2(); //Jugador 2 del tablero
		Jugador turnoJugador = Tablero.getTablero().getTurnoJugador(); //Turno jugador actual del tablero
		Ficha[][] matrix = Tablero.getTablero().getMatriz(); //La matriz
		File arc = new File(Fichero.filename);
		try {
			// Eliminamos el archivo para que luego sobreesciba la partida
			if(arc.exists()){
				arc.delete();
			}

			FileWriter archivo = new FileWriter(Fichero.filename, true);

			if(jugad1.getColor() == Color.WHITE){
				archivo.write(jugad1.getNombre() + "/1\n"); // 1 significa blanco
			} else {
				archivo.write(jugad1.getNombre() + "/0\n"); // 0 significa negro
			}

			if(jugad2.getColor() == Color.WHITE){
				archivo.write(jugad2.getNombre() + "/1\n");
			} else {
				archivo.write(jugad2.getNombre() + "/0\n");
			}

			if(turnoJugador == jugad1){
				archivo.write("1\n");
			} else {
				archivo.write("2\n");
			}
			//************************************************************************archivo.write(this.turnoJugador+"/");
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {

					if (matrix[i][j] != null){

						String tipo = matrix[i][j].getTipoFicha();
						int jugador;

						if(matrix[i][j].getJugador() == jugad1){
							jugador = 1;
						} else {
							jugador = 2;
						}
						archivo.write(i + "/" + j + "/" + tipo + "/" + jugador + "/");

					}
				}
			}

			archivo.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
