
public class Peon extends Ficha {

	public Peon(Jugador pJugador, Posicion pPosicion){
		super(pJugador, pPosicion);
	}

	public boolean comprobarMovimiento(Posicion posicionInicial, Posicion posicionDestino) {

		Ficha[][] matrix = Tablero.getTablero().getMatriz();

		int pFila1 = posicionInicial.getFila();
		int pFila2 = posicionDestino.getFila();
		int pColumna1 = posicionInicial.getColumna();
		int pColumna2 = posicionDestino.getColumna();


		boolean correcto = false;

		int offsetX = pColumna2 - pColumna1;
		int offsetY = pFila2 - pFila1;
		int absOffsetX = Math.abs(pColumna2 - pColumna1);
		int absOffsetY = Math.abs(pFila2 - pFila1);


		if(pFila1 != pFila2 || pColumna1 != pColumna2) {

			switch (Tablero.getTablero().getTurnoJugador().getColor()) {
			case WHITE:
				if (offsetY > 0){
					if(offsetX == 0 && ((offsetY == 1)||(offsetY == 2 && pFila1 == 1))) {
						if(matrix[pFila2][pColumna2] == null) {
							correcto = true;
							if (pFila2 == 7){ //Coronacion blanco
								peonTo(posicionInicial); 
							}
						}						
					} else {
						if(absOffsetX == offsetY && absOffsetX == 1) {
							if(matrix[pFila2][pColumna2] != null && matrix[pFila2][pColumna2].getJugador() != Tablero.getTablero().getTurnoJugador()) {
								correcto = true;
								if (pFila2 == 7){ //Coronacion blanco
									peonTo(posicionInicial);
								}
							}
						}
					}
				}
				break;
			case BLACK:
				if (offsetY < 0){
					if(offsetX == 0 && ((absOffsetY == 1)||(absOffsetY == 2 && pFila1 == 6))) {
						if(matrix[pFila2][pColumna2] == null) {
							correcto = true;
							if (pFila2 == 0){ //Coronacion negro
								peonTo(posicionInicial);
							}
						}	
					} else {
						if(absOffsetX == absOffsetY && absOffsetX == 1) {
							if(matrix[pFila2][pColumna2] != null && matrix[pFila2][pColumna2].getJugador() != Tablero.getTablero().getTurnoJugador()) {
								correcto = true;
								if (pFila2 == 0){ //Coronacion negro
									peonTo(posicionInicial);
								}
							}
						}
					}
				}
				break;
			default:
				break;
			}


		}

		return correcto;
	}

	private void peonTo(Posicion pos) {
		Ficha[][] matrix = Tablero.getTablero().getMatriz();
		int pFila = pos.getFila();
		int pColumna = pos.getColumna();
		String ficha = Teclado.leerString("¿Qué ficha quieres ser?:  (TORRE, CABALLO, REINA, ALFIL)");
		ficha = ficha.toUpperCase();
		Ficha fNueva;
		if (ficha.equals("TORRE")) {
			fNueva = new Torre(Tablero.getTablero().getTurnoJugador(), pos);
			matrix[pFila][pColumna] = fNueva;
		} else if (ficha.equals("CABALLO")) {
			fNueva = new Caballo(Tablero.getTablero().getTurnoJugador(), pos);
			matrix[pFila][pColumna] = fNueva;
		} else if (ficha.equals("REINA")) {
			fNueva = new Reina(Tablero.getTablero().getTurnoJugador(), pos);
			matrix[pFila][pColumna] = fNueva;
		} else if (ficha.equals("ALFIL")) {
			fNueva = new Alfil(Tablero.getTablero().getTurnoJugador(), pos);
			matrix[pFila][pColumna] = fNueva;
		} else {
			System.out.println("No puedes ser esa pieza");
			peonTo(pos);
		}
	}

	public String getIcono(){
		String icono;
		if (this.getJugador().getColor() == Color.WHITE){
			icono = "\u2659" + " ";
		} else{
			icono = "\u265F" + " ";
		}
		return icono;
	}
}

