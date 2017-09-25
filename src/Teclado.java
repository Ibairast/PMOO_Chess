
import java.util.Scanner;

public class Teclado {

	//@SuppressWarnings("resource")
	public static String leerString(String mensaje) {

		System.out.print(mensaje);

		Scanner sc1 = new Scanner(System.in);		
		String text = sc1.next();		
		return text;
	}

	//@SuppressWarnings("resource")
	public static boolean leerBoolean(String mensaje) {
		System.out.print(mensaje);
		boolean bool = false;
		Scanner sc2 = new Scanner(System.in);
		String text = sc2.next();		
		if(text.equals("Y") || text.equals("y")) {
			bool = true;
		}
		return bool;
	}
}
