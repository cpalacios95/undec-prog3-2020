package proyectoconprincipio;

public class Boton {

	private final Persistencia miPersistencia;
	
	public Boton(Persistencia persistencia) {
		this.miPersistencia=persistencia;
	}
	
	public void pulsar() {
		miPersistencia.cambiarEstado();
	}	
}
