package dominio;

public class MostrarDatos {

	public String mostrar(Factura f01) {
		
		return "El precio total de la compra, aplicando un descuento de " +f01.getDescuento()
		+"%, y aplicando un iva de " +f01.getIva()+"%, es de: $"+ f01.getPrecioTotal();
	}
}
