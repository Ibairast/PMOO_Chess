
public class Jugador {

	//Atributos
	private Color color; 
	private String nombre;

	//Contructora
	public Jugador(Color pColor,String pNombre){
		this.color = pColor;
		this.nombre = pNombre;
	}

	public Color getColor(){
		return this.color;
	}

	public String getNombre(){
		return this.nombre;
	}

}
