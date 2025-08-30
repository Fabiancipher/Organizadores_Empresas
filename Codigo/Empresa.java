import java.time.*;
import java.time.format.DateTimeFormatter;
import java.text.*;
public class Empresa{
    private String nombre;
    private LocalDate fecha;
    private Integer ventas;
    private Integer clientes;

    static DateTimeFormatter DF= DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public Empresa(String nombre, LocalDate fecha, Integer ventas, Integer clientes){
        this.nombre= nombre;
        this.fecha= fecha;
        this.ventas= ventas;
        this.clientes= clientes;
    }
    
    @Override
    public String toString() {
    	return "[Nombre: "+this.nombre+", Fecha: "+this.fecha+", Ventas: "+this.ventas+", Clientes: "+this.clientes+"] \n";
    }
    
    public String fechaToString() {
    	return fecha.format(DF);
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Integer getVentas() {
		return ventas;
	}

	public void setVentas(Integer ventas) {
		this.ventas = ventas;
	}

	public Integer getClientes() {
		return clientes;
	}

	public void setClientes(Integer clientes) {
		this.clientes = clientes;
	}
}