package dominio;

public class Motocicleta implements Vehiculo{

	private int motor;
	private int ancho;
	private int largo;
	private int categoria;
	public Motocicleta(int motor, int ancho, int largo) {
		this.motor=motor;
		this.ancho= ancho;
		this.largo= largo;
	}
	@Override
	public void determinarCategoria() {
		if(this.motor>110)
			this.categoria=1;
		else
			this.categoria=2;
		
	}
	@Override
	public String colorPuertas() {
		// TODO Auto-generated method stub
		return "Es una motocicleta por lo tanto no tiene puertas";
	}

	
}
