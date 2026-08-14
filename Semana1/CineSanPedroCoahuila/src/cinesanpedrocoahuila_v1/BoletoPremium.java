package cinesanpedrocoahuila_v1;

public class BoletoPremium extends Boleto{
	public BoletoPremium(String numeroAsiento) {
		super(numeroAsiento);
	}
	
	@Override
	public double calcularPrecio() {
		return 100;
	}
	
	public void pedirComidaAsiento() {
		System.out.println("Comida en camino al asiento Premium: " + numeroAsiento);
	}
}
