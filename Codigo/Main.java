import java.util.Scanner;
public class Main {
	public static Controlador control;
	public static Matriz organ;
	public static Scanner sc;
	public static void main(String[] args) {
		organ = new Matriz();
		control = new Controlador(organ);
		sc = new Scanner(System.in);
		
		while(true) {
			System.out.println(" 1) Añadir empresa \n 2) Ordenar \n 3) Mostrar Lista \n 0) Salir \n");
			int menu= Integer.parseInt(sc.nextLine());
			
			switch(menu) {
				case 1:
					organ.addEmpresa();
					break;
				case 2:
					control.seleccion();
					break;
				case 3:
					organ.mostrarLista();
					break;
				case 0:
					return;
				default:
					System.out.println("Seleccion invalida");
			}
		}
	}

}
