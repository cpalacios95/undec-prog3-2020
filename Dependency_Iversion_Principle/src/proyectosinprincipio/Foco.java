package proyectosinprincipio;

public class Foco {

	private String estado="Apagado";

	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado=estado;
	}

	public void cambiarEstado() {
		if(this.estado.equals("Apagado"))
			setEstado("Encendido");
			//PrenderFoco
		else
			setEstado("Apagado");
			//ApagarFoco
		
	}
}
