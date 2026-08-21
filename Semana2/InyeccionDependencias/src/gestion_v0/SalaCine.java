package gestion_v0;

public class SalaCine {
	private String numeroSala;
	private String tipoProyector;
	private final ProyectorIMAX proyectorIMAX;
	private final ProyectorDigital proyectorDigital;
	
	public SalaCine(String numeroSala, String tipoProyector) {
		this.numeroSala = numeroSala;
		this.tipoProyector = tipoProyector;
		this.proyectorIMAX = new ProyectorIMAX();
		this.proyectorDigital = new ProyectorDigital();
	}
	
	public void iniciarFuncion(String nombrePelicula) {
		System.out.println("Iniciando la función en la sala " + numeroSala);
		if (tipoProyector.equals("IMAX")) {
			proyectorIMAX.reproducirPelicula(nombrePelicula);
		} else if (tipoProyector.equals("Digital")) {
            proyectorDigital.reproducirPelicula(nombrePelicula);
        } else {
            System.out.println("No existe ese proyector");
        }
	}
}
