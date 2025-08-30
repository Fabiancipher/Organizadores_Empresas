import java.util.*;
public class Controlador {
	private Matriz organizador;
	private Scanner sc;
	
	public Controlador(Matriz organizador) {
		this.organizador = organizador;
		this.sc = new Scanner(System.in);
	}
	
	public void seleccion() {
		organizador.mostrarLista();
		String atributo= "";
		boolean isAscendente= true;
		
		System.out.println("1) Organizar por nombre \n 2) Organizar por fecha \n 3) Organizar por ventas \n 4) Organizar por clientes \n");
		int dec = Integer.parseInt(sc.nextLine());
		
		switch(dec) {
			case 1:
				atributo = "nombre";
				break;
			case 2:
				atributo = "fecha";
				break;
			case 3:
				atributo = "ventas";
				break;
			case 4:
				atributo = "clientes";
				break;
			default:
				System.out.println("Seleccion invalida");
				return;
		}
		
		System.out.println("1) Ascendente \n 2) Descendente \n");
		int decAsc = Integer.parseInt(sc.nextLine());
		
		switch(decAsc) {
			case 1:
				isAscendente = true;
				break;
			case 2:
				isAscendente = false;
				break;
			default:
				System.out.println("Seleccion invalida");
				return;
		}
		
		System.out.println("1) Burbuja \n 2) Seleccion \n 3) Insercion");
		int decAlgo = Integer.parseInt(sc.nextLine());
		
		switch(decAlgo) {
		case 1:
			organizador.burbuja(atributo, isAscendente);
			break;
		case 2:
			organizador.seleccion(atributo, isAscendente);
			break;
		case 3:
			organizador.insercion(atributo, isAscendente);
			break;
		default:
			System.out.println("Seleccion invalida");
			return;
		}
		
		System.out.println("Atributo: "+atributo);
		System.out.println("Orden: " + (isAscendente ? "Ascendente": "Descendente"));
		organizador.mostrarLista();
	}
}