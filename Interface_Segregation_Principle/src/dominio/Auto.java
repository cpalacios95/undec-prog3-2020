package dominio;

public class Auto implements Vehiculo{

	private int motor;
	private int ancho;
	private int largo;
	private int categoria;
	public Auto(int motor, int ancho, int largo) {
		this.motor=motor;
		this.ancho= ancho;
		this.largo= largo;
	}

	@Override
	public void determinarCategoria() {
		if(this.motor>3000) {
			this.categoria=1;
		}
		else
			this.categoria=2;
	}

	@Override
	public String colorPuertas() {
		return "El color de todas las puertas es rojo";
	}
	
}
