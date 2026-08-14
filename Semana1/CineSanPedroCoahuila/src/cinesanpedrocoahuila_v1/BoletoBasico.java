package cinesanpedrocoahuila_v1;

public class BoletoBasico extends Boleto {
	
	public BoletoBasico(String numeroAsiento) {
		super(numeroAsiento);
	}
	
	@Override
	public double calcularPrecio() {
		return 50.0;
	}
}