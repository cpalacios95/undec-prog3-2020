package dominio;

//interfaz que contiene dos metodos, el primero va a determinar la categoria del 
//vehiculo dependiendo del tamanio del motor.
//El segundo metodo es para mostrar el color de las puertas del vehiculo.

public interface Vehiculo {
	public void determinarCategoria();
	public String colorPuertas();
}
