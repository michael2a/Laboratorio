package tarea2POO;
import java.util.Scanner;//librería para lectura de datos
import java.io.FileWriter;//librería para crear el archivo txt
import java.io.IOException;//librería para usar catch en caso de error 



public class  CineEntadas { 
	public static class CustomerData{ //intento de Struct en java
		String customerName; //variable para nombre del cliente
		String CI; //variable para numero de cedula 
		String movieName; // variable para el nombre de la película
	}

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in); //para poder leer los datos
		int arraySize=100 ;//tamaño del arreglo
		CustomerData[] People= new CustomerData[arraySize]; //arreglo con la calse CustomerData
		int numberTickets;
		int option; //para el menú
		char desicion;//almaceno la decición del cliente
		boolean execution;//para ejecutar la venta o caso contrario cancelarla
		do {
			System.out.println("bienvenido al servicio de compra de entradas para el cine");
			System.out.println("1. comprar una entrada de cine");
			System.out.println("2. salir");
			option=scanner.nextInt(); //leer un entero en la variable option
			switch(option) {
			case 1:
				
				System.out.println("-----bienvenido------");
				do {
				System.out.println("porfavor, ingrese el numero de ticjets que desea comprar");
				numberTickets= scanner.nextInt();
				if(numberTickets<0 || numberTickets >5) {
					System.out.println("Error, el numero de tickets no puede ser menor a cero ni mayor a 5");
				}
				}while(numberTickets<0 || numberTickets>5);
				scanner.nextLine();
				for(int i=0; i<numberTickets; i++) {
					People[i]= new CustomerData ();
					System.out.println("porfavor, ingrese su nombre persona "+ (i+1) );
					People[i].customerName = scanner.nextLine(); 
					do {
					System.out.println("porfavor, " +People[i].customerName +", ingrese su cedula de identidad");
						People[i].CI= scanner.nextLine();
					if(People[i].CI.length()<10 || People[i].CI.length()>10) {
						System.out.println("el numero de cedula no puede ser menor o mayor a 10 dígitos");
					}
					}while(People[i].CI.length()!=10);
					do {
					System.out.println("Ingrese el nombre de la película que desea ver");
					System.out.println("películas disponibles: ");
					System.out.println("");
					System.out.println("-----------------------");
					System.out.println("-       FROZEN        -");
					System.out.println("- SEÑOR DE LOS ANILLOS-");
					System.out.println("-       YOUR NAME     -");
					System.out.println("-   CAMINO AL CIELO   -");
					System.out.println("-----------------------");
					System.out.println("Porfavor ingrese el nombre tal como se presenta en la pantalla");
					People[i].movieName = scanner.nextLine();
					}while(People[i].movieName.equals("FROZEN")==false && People[i].movieName.equals("SEÑOR DE LOS ANILLOS")==false && People[i].movieName.equals("YOUR NAME")==false && People[i].movieName.equals("CAMINO AL CIELO")==false );
				}
				System.out.println("el valor de cada entrada es de 5.50 dolares");
				System.out.println("Usted adquirió "+numberTickets+" por lo tanto el valor a pagar es de "+(numberTickets*5.50)+ "$");
				
					do {
				System.out.println("¿desea pagar o desea cancelar la compra?");
				System.out.println("ingrese (T) para continuar o ingrese (F) para cancelar la compra"); 
				desicion= scanner.next().charAt(0);
				}while(desicion!='T' && desicion!='F');
					if(desicion=='T') {
						execution=true;
						System.out.println("Compra realizada, Gracias por su compra");
						System.out.println("las películas estarán disponibles a cualquier hora del día");
						try { //intenta ejecutar el código dentro del try 
							FileWriter writer= new FileWriter("factura.txt");
							writer.write("--------Factura electrónica--------"+"\n");
						
							for(int i=0; i<numberTickets; i++) {
								
								writer.write("USUARIO: ");
								writer.write(People[i].customerName + "\n");
								writer.write("PELÍCULA : ");
								writer.write( People[i].movieName +"\n");
								writer.write("Precio: ");
								writer.write("5.50 $"+"\n");
								writer.write(""+"\n");
								writer.write("-----------------------------------------------"+"\n");
								writer.write(""+"\n");
							}
							writer.write("el valor final pagado es: "+ (5.50*numberTickets));
							writer.close();
							System.out.println("se ha generado una factura como archivo txt");
						}catch(IOException e){ //en caso de un error
							System.out.println("no se pudo generar el archivo");
						}
						
					}
					if(desicion=='F') {
						execution=false;
						System.out.println("Entendido, gracias. qur tenga un buen día");
					}
					
				break;
			case 2:
				System.out.println("GRACIAS.....saliendo");
				break;
			default:
				System.out.println("Error. ingrese una opción disponible en el menú");
				break;
			}
		}while(option!=2);
		

	}

}
