package cinesanpedrocoahuila_v1;

public abstract class Boleto {
	protected String numeroAsiento;
	
	public Boleto(String numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}
	
	public abstract double calcularPrecio();
	
	public String getNumeroAsiennto() {
		return numeroAsiento;
	}
}
