package dominio;

public class CentroMusical {
	
	private String tipoEntrada;
	
	public CentroMusical(String tipo) {
		this.tipoEntrada=tipo;
	}

	public void tipoEntrada() {
		if(tipoEntrada.equals("CD"))
			reproducirCD();
		if(tipoEntrada.equals("Casete"))
			reproducirCasete();
		else
			reproducirAuxiliar();
	}

	private void reproducirAuxiliar() {
		//ReproduciendoAuxiliar
	}

	private void reproducirCasete() {
		//ReproduciendoCasete
		
	}

	private void reproducirCD() {
		//ReproduciendoCD
		
	}
	
}
