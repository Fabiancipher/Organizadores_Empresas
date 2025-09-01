package Secuencial;
import java.util.*;
public class Secuencial{
    public static Object matriz[][];
    private static int columnas= 0;
    static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        Secuencial sec= new Secuencial();
        Secuencial.matriz= new Object[4][100]; 
        sec.menu();
    }
    public void menu() {
    while(true) {
			System.out.println(" 1) Añadir empresa \n 2) Ordenar \n 3) Mostrar Lista \n 0) Salir \n");
			int menu= Integer.parseInt(sc.nextLine());
			
			switch(menu) {
				case 1:
					addEmpresa();
					break;
				case 2:
					ordenar();
					break;
				case 3:
					mostrarLista();
					break;
				case 0:
					return;
				default:
					System.out.println("Seleccion invalida");
			}
		}
    }
    public void addEmpresa() {
        System.out.println("Ingrese el nombre de la empresa: "); Object nombre= sc.nextLine();
        System.out.println("Ingrese la fecha de creacion de la empresa: "); Object fecha= sc.nextLine();
        System.out.println("Ingrese el numero de ventas del mes: "); Object ventas= Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese el numero de clientes: "); Object clientes= Integer.parseInt(sc.nextLine());

        matriz[0][columnas]= nombre;
        matriz[1][columnas]= fecha;
        matriz[2][columnas]= ventas;
        matriz[3][columnas]= clientes;
        columnas++;
    }

    public static void ordenar() {
        mostrarLista();

        System.out.println("Ordenar por: \n 1) Nombre \n 2) Fecha \n 3) Ventas \n 4) Clientes \n");
        int atributo = Integer.parseInt(sc.nextLine());

        if(atributo<=0 || atributo>4){
            System.out.println("Seleccion invalida");
            return;
        }

        System.out.println("Tipo de orden: 1=Ascendente, 2=Descendente");
        int tipo = Integer.parseInt(sc.nextLine());

        if(tipo!=1 && tipo!=2){
            System.out.println("Seleccion invalida");
            return;
        }

        boolean asc = (tipo == 1);

        System.out.println("Algoritmo: 1=Burbuja, 2=Seleccion, 3=Insercion");
        int algoritmo = Integer.parseInt(sc.nextLine());

        switch (algoritmo) {
            case 1:
                burbuja((atributo-1), asc);
                break;
            case 2:
                seleccion((atributo-1), asc);
                break;
            case 3:
                insercion((atributo-1), asc);
                break;
            default:
                System.out.println("Opcion invalida");
        }
    }

    public static void mostrarLista() {
       for(int i=0; i<columnas; i++){
            System.out.println("N°"+(i+1)+": [Nombre: "+matriz[0][i]+"; Fecha: "+matriz[1][i]+"; Ventas: "+matriz[2][i]+"; Clientes: "+matriz[3][i]+"] \n");
       }
    }

     public static void burbuja(int attr, boolean asc) {
        for (int i = 0; i < columnas - 1; i++) {
            for (int j = 0; j < columnas - 1 - i; j++) {
                if (comparar(matriz[attr][j], matriz[attr][j + 1], asc) > 0) {
                    intercambiar(j, j + 1);
                }
            }
        }
    }

    public static void seleccion(int attr, boolean asc) {
        for (int i = 0; i < columnas - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < columnas; j++) {
                if (comparar(matriz[attr][idx], matriz[attr][j], asc) > 0) {
                    idx = j;
                }
            }
            intercambiar(i, idx);
        }
    }

    public static void insercion(int attr, boolean asc) {
        for (int i = 1; i < columnas; i++) {
            int j = i;
            while (j > 0 && comparar(matriz[attr][j - 1], matriz[attr][j], asc) > 0) {
                intercambiar(j - 1, j);
                j--;
            }
        }
    }

    public static int comparar(Object a, Object b, boolean asc) {
        int res = 0;
        if (a instanceof Integer && b instanceof Integer) { //Revisa que ambos sean del mismo tipo (Enteros o Strings)
            res = ((Integer) a).compareTo((Integer) b);
        } else { // nombre y fecha como String
            res = a.toString().compareToIgnoreCase(b.toString());
        }
        return asc ? res : -res; // Cambia el orden
    }

    public static void intercambiar(int i, int j) {
        for (int fila = 0; fila < 4; fila++) { // Recorre las filas
            Object temp = matriz[fila][i]; // Guarda el valor temporalmente
            matriz[fila][i] = matriz[fila][j]; //Intercambia los valores
            matriz[fila][j] = temp; // Devuelve el valor original
        }
    }

}