package dominio;
//Definimos una interfaz para que sea usado por los vehiculos que no contengan
//puertas, por ejemplo, motocicleta, cuatriciclos, etc. 
//Que contiene solamente el metodo de determinar categoria.

public interface VehiculoSinPuertas {
	public void determinarCategoria();
}
