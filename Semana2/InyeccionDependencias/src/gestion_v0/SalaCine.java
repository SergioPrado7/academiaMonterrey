package gestion_v0;

public class SalaCine {
	private String numeroSala;
	private final Proyector proyector;
	
	public SalaCine(String numeroSala, Proyector proyector) {
		this.numeroSala = numeroSala;
		this.proyector = proyector;
	}
	
	public void iniciarFuncion(String nombrePelicula) {
		System.out.println("Iniciando la función en la sala " + numeroSala);
		proyector.reproducirPelicula(nombrePelicula);
	}
}
