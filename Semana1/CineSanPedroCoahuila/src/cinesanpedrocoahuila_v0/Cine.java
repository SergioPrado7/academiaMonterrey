package cinesanpedrocoahuila_v0;

public class Cine {
	private final String nombreCine;
	private final String ubicacionCine;
	
	public Cine() {
		this.nombreCine = "Cine de San Pedro";
		this.ubicacionCine = "Avenida Morelos esquina con Juan Acuña";
	}
	
	public String getNombreCine() {
		return nombreCine;
	}
	
	public String getUbicacionCine() {
		return ubicacionCine;
	}
}