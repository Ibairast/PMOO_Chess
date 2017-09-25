
public class Posicion {
	private int fila = 0;
	private int columna = 0;

	public Posicion(int pFila, int pColumna) {
		this.fila = pFila;
		this.columna = pColumna;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setFila(int pFila){
		this.fila = pFila;
	}

	public void setColumna(int pColumna){
		this.columna = pColumna;
	}

}
