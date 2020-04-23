package dominio;

public class Descuento {

	private double cantDescuento;
	
	public Descuento() {
		this.cantDescuento= 5.0;
	}

	public double getCantDescuento() {
		return cantDescuento;
	}

	public void setCantDescuento(double cantDescuento) {
		this.cantDescuento = cantDescuento;
	}

	public double obtnerDescueto(double precioBase) {

		return (precioBase*this.cantDescuento)/100;
	}
	
	
}
