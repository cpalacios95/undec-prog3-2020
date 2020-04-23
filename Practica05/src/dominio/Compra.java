package dominio;

public class Compra {
	public static void main(String []args) {
		
		Cliente c01= new Cliente ("Cristian", "Palacios", 39700483, "3825665796");
	//	Cliente c02= new Cliente ("Ramiro", "Roldan", 38589312, "3825559866");
	//	Cliente c03= new Cliente ("Juan Ignacio", "Scalet", 38665651, "3825671041");
		
		c01.addProducto(new Item("Tornillo", 40, 7.5));
		c01.addProducto(new Item("Martillo", 1, 205));
		c01.addProducto(new Item("tacos fischer", 12, 14.7));
		
		Factura f01= new Factura();
		f01.generarFactura(c01);
		
		MostrarDatos m01= new MostrarDatos();
		System.out.println(m01.mostrar(f01));

	}

}
