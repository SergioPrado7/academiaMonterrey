package cinesanpedrocoahuila_v0;

public class Pelicula {
	private final String titulo;
	private final int duracionMins;
	
	public Pelicula(String titulo, int duracionMins) {
		this.titulo = titulo;
		this.duracionMins = duracionMins;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public int getDuracionMins() {
		return duracionMins;
	}
}
