package proyectoconprincipio;

public class Foco implements Persistencia{

	private String estado="Apagado";
	
	@Override
	public void cambiarEstado() {
		if(this.estado.equals("Apagado"))
			setEstado("Encendido");
			//PrenderFoco
		else
			setEstado("Apagado");
			//ApagarFoco
	}

	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado=estado;
	}
	
}
