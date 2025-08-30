import java.util.Scanner;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.function.Function;
public class Matriz{
    private List<Empresa> lista;
    private Scanner sc;
    private Integer size;
    private DateTimeFormatter formatter;
    
    public Matriz(){
        this.lista= new ArrayList<>();
        this.sc= new Scanner(System.in);
        this.size= 0;
        this.formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
    
    private Comparator<Empresa> getComparator(String atributo, boolean isAscendente){
    	
    	Function<Empresa, Comparable<?>> extractor = getExtractor(atributo);
        
        Comparator<Empresa> comparador = (e1, e2) -> {
            Comparable<?> valor1 = extractor.apply(e1);
            Comparable<?> valor2 = extractor.apply(e2);
            
            @SuppressWarnings("unchecked")
            int resultado = ((Comparable<Object>)valor1).compareTo(valor2);
            return resultado;
        };
        
        return isAscendente ? comparador : comparador.reversed();
    }
    
    private Function<Empresa, Comparable<?>> getExtractor(String atributo) {
        switch(atributo.toLowerCase()) {
            case "nombre":
                return Empresa::getNombre;
            case "fecha":
                return empresa -> empresa.getFecha(); 
            case "ventas":
                return Empresa::getVentas;
            case "clientes":
                return Empresa::getClientes;
            default:
                throw new IllegalArgumentException("Atributo no válido: " + atributo);
        }
    }

    public void addEmpresa(){
        System.out.println("Ingrese el nombre de la empresa: "); String nombre= sc.nextLine();
        System.out.println("Ingrese la fecha de creacion de la empresa: "); String fecha= sc.nextLine();
        System.out.println("Ingrese el numero de ventas del mes: "); Integer ventas= Integer.parseInt(sc.nextLine());
        System.out.println("Ingrese el numero de clientes: "); Integer clientes= Integer.parseInt(sc.nextLine());
        try{
        	LocalDate fechaLocalDate = LocalDate.parse(fecha, formatter);
            Empresa x= new Empresa(nombre, fechaLocalDate, ventas, clientes);
            lista.add(x);
            this.size++;
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void mostrarLista() {
    	for(Empresa empresa : lista) {
    		System.out.println(empresa);
    	}
    }
    
    public void burbuja(String atributo, boolean isAscendente){
        Comparator<Empresa> comparador = getComparator(atributo, isAscendente);
        
        for(int i=0; i<lista.size()-1; i++) {
            for(int j=0; j<lista.size()-i-1; j++) {
                if (comparador.compare(lista.get(j),lista.get(j+1))>0) {
                    Collections.swap(lista, j, j+1);
                }
            }
        }
    }

    public void seleccion(String atributo, boolean isAscendente){
        Comparator<Empresa> comparador = getComparator(atributo, isAscendente);
        
         for (int i = 0; i < lista.size() - 1; i++) {
             int minIndex = i;
             for (int j = i + 1; j < lista.size(); j++) {
                 if (comparador.compare(lista.get(j), lista.get(minIndex)) < 0) {
                     minIndex = j;
                 }
             }
             if (minIndex != i) {
                 Collections.swap(lista, i, minIndex);
             }
         }
    }

    public void insercion(String atributo, boolean isAscendente){
        Comparator<Empresa> comparador = getComparator(atributo, isAscendente);
        
        for (int i=1; i<lista.size();i++) {
            Empresa clave= lista.get(i);
            int j= i-1;
            
            while(j>= 0 && comparador.compare(lista.get(j), clave)>0) {
                lista.set(j+1, lista.get(j));
                j--;
            }
            lista.set(j+1, clave);
        }
    }
}