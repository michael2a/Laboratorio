package proyectoPractica;
import java.util.Scanner;


public class POO {
	public static class Rectangulo{
		
		float base;
		float altura;
		public void area() {
			System.out.println("el area del rectángulo es igual a: "+(base*altura));
		}
	}
	public static void main(String [] args) {
		Scanner scanner= new Scanner(System.in);
		Rectangulo rectangulo= new Rectangulo();
		System.out.println("Ingrese la base del rectángulo");
		rectangulo.base= scanner.nextFloat();
		System.out.println("ingrese la altura de rectangulo");
		rectangulo.altura=scanner.nextFloat();
		rectangulo.area();
	}

}
