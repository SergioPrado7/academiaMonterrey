package cinesanpedrocoahuila_v0;

public class BoletoPremium extends Boleto{
	public BoletoPremium(String numeroAsiento) {
		super(numeroAsiento);
	}
	
	@Override
	public double CalcularPrecio() {
		return 100;
	}
	
	public void PedirComidaAsiento() {
		System.out.println("Comida en camino al asiento Premium: " + numeroAsiento);
	}
}
