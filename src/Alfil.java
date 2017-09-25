
public class Alfil extends Ficha{

	public Alfil(Jugador pJugador, Posicion pPosicion){
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
			if (absOffsetX == absOffsetY) {
				correcto = this.comprobarIntermedio(pFila1, pColumna1, pFila2, pColumna2);
				if (correcto) {
					correcto = posFinalCorrecta (pFila2, pColumna2);
				}
			}
		}

		return correcto;
	}

	public String getIcono(){
		String icono;
		if (this.getJugador().getColor() == Color.WHITE){
			icono ="\u2657" + " ";
		} else{
			icono ="\u265D" + " ";
		}
		return icono;
	}

}
