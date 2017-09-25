
public class Rey extends Ficha {

	public Rey(Jugador pJugador, Posicion pPosicion){
		super(pJugador, pPosicion);
	}

	public boolean comprobarMovimiento(Posicion posicionInicial, Posicion posicionDestino) {

		int pFila1 = posicionInicial.getFila();
		int pFila2 = posicionDestino.getFila();
		int pColumna1 = posicionInicial.getColumna();
		int pColumna2 = posicionDestino.getColumna();

		boolean correcto = false;

		int absOffsetX = Math.abs(pColumna2 - pColumna1);
		int absOffsetY = Math.abs(pFila2 - pFila1);

		if(pFila1 != pFila2 || pColumna1 != pColumna2) {
			if (absOffsetX < 2 && absOffsetY < 2) {
				correcto = posFinalCorrecta (pFila2, pColumna2);
			}
		}

		return correcto;

	}

	public String getIcono(){
		String icono;
		if (this.getJugador().getColor() == Color.WHITE){
			icono = "\u2654" + " ";
		} else{
			icono = "\u265A" + " ";
		}
		return icono;
	}

}
