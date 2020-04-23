package dominio;

public class Iva {

	private int valor;
	
	public Iva() {
		this.valor=21;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public double obtenerIva(double precioBase) {
		
		return (precioBase * this.valor)/100;
	}
	
	
}
