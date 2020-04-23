package dominio;

public class Factura {
	
	private double precioBase;
	private double precioTotal;
	private double Iva;
	private double descuento;
	
	
	public void generarFactura(Cliente c01) {
		Iva i01= new Iva();
		Descuento d01= new Descuento();
		this.precioBase= c01.obtenerTotal();
		this.Iva= i01.obtenerIva(precioBase);
		this.descuento= d01.obtnerDescueto(precioBase);
		this.precioTotal= (this.Iva+this.precioBase)-this.descuento;
	}


	public double getPrecioBase() {
		return precioBase;
	}


	public double getPrecioTotal() {
		return precioTotal;
	}


	public double getIva() {
		return Iva;
	}


	public double getDescuento() {
		return descuento;
	}

}
