package dominio;

public class Factura {
	
	private double precioBase;
	private double precioTotal;
	private double Iva;
	private double descuento;
	
	
	public void generarFactura(Cliente c01) {
	this.precioBase= c01.obtenerTotal();
	this.Iva= (this.precioBase*21)/100;
	this.descuento= (this.precioBase*5)/100;
	this.precioTotal= (this.Iva+this.precioBase)-this.descuento;
	}


	public String mostrarDatos() {
		String salida="";
		return salida+"El precio total de la compra con un descuento de " +5+"% y un iva de :"+
				21+ "% es: "+this.precioTotal;
		
	}
	

}
