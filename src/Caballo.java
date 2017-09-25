
public class Caballo extends Ficha {

	public Caballo(Jugador pJugador, Posicion pPosicion){
		super(pJugador, pPosicion);
	}

	public boolean comprobarMovimiento(Posicion posicionInicial, Posicion posicionDestino) {

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
			if(offsetX != 0 && offsetY != 0 && absOffsetX + absOffsetY == 3) {
				correcto = posFinalCorrecta (pFila2, pColumna2);
			}

		}
		return correcto;
	}

	public String getIcono(){
		String icono;
		if (this.getJugador().getColor() == Color.WHITE){
			icono = "\u2658" + " ";
		} else{
			icono = "\u265E" + " ";
		}
		return icono;
	}
}
