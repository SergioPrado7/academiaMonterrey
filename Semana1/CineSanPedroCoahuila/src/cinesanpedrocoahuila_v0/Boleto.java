package cinesanpedrocoahuila_v0;

public abstract class Boleto {
	protected String numeroAsiento;
	
	public Boleto(String numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}
	
	public abstract double CalcularPrecio();
	
	public String getNumeroAsiennto() {
		return numeroAsiento;
	}
}
