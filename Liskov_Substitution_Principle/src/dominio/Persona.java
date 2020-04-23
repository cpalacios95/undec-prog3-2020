package dominio;

public class Persona {
	 
    private String nombre;
    private String apellidos;
    private int dni;
    private int nrotarjeta;
    public Persona( String nombre, String apellidos, int dni, int nrotarjerta) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni=dni;
        this.nrotarjeta=nrotarjeta;
    }

    public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public int getNrotarjeta() {
		return nrotarjeta;
	}


	public void setNrotarjeta(int nrotarjeta) {
		this.nrotarjeta = nrotarjeta;
	}


	public void pagarCompra() {   
        System.out.println("mi dni es "+ getDni()+ ", pago con la tarjeta nro: "+this.nrotarjeta);
    }
}
