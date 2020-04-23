package dominio;

public class Adulto extends Persona{

	private int nrotarjeta;

	public Adulto(String nombre, String apellidos, int dni, int nrotarjeta) {
		super(nombre, apellidos, dni);
		this.nrotarjeta=nrotarjeta;
	}

	public void pagarCompra() {   
        System.out.println("mi dni es "+ getDni()+ ", pago con la tarjeta nro: "+this.nrotarjeta);
    }
}
