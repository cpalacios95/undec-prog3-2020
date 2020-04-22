package dominio;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

	
	private String nombre;
	private String apellido;
	private int dni;
	private String telefono;
	List<Item> misItems;
	
	public Cliente(String nombre, String apellido, int dni, String telefono) {
		this.nombre= nombre;
		this.apellido= apellido;
		this.dni= dni;
		this.telefono= telefono;
		misItems= new ArrayList<Item>();
	}


	public void addProducto(Item item) {
		misItems.add(item);
	}


	public double obtenerTotal() {
		double total=0;
		for(Item i: misItems) {
			total+=i.getPrecio()*i.getCantidad();
		}
		return total;
	}


	public String getNombre() {
		return nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public int getDni() {
		return dni;
	}


	public String getTelefono() {
		return telefono;
	}
}
