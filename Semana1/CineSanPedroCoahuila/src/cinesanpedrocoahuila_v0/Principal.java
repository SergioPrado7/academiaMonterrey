package cinesanpedrocoahuila_v0;

public class Principal {

	public static void main(String[] args) {
		Cine cine1 = new Cine();
		System.out.println("Bienvenidos al " + cine1.getNombreCine());
		System.out.println("El cual esta ubicado en " + cine1.getUbicacionCine());
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		Pelicula peli1 = new Pelicula("El Padrino", 95);
		Pelicula peli2 = new Pelicula("Avenger End Game", 115);
		Pelicula peli3 = new Pelicula("Spiderman Brands New Day", 125);
		
		Sala sala1 = new Sala(1, peli1);
		Sala sala2 = new Sala(2, peli2);
		Sala sala3 = new Sala(3, peli3);
		
		sala1.mostrarCartelera();
		sala2.mostrarCartelera();
		sala3.mostrarCartelera();
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		sala1.venderBoleto(new BoletoBasico("A1"));
		sala1.venderBoleto(new BoletoBasico("A2"));
		sala1.venderBoleto(new BoletoPremium("V1"));
		
		sala2.venderBoleto(new BoletoPremium("V1"));
		sala2.venderBoleto(new BoletoPremium("V2"));
		
		sala3.venderBoleto(new BoletoBasico("A1"));
		
		for (Boleto b : sala1.getBoletosVendidos()) {
			System.out.println("El asiento " + b.getNumeroAsiennto() + " --->" + " cobró: $" + b.calcularPrecio());
			if (b instanceof BoletoPremium) {
				BoletoPremium premium = (BoletoPremium) b;
				premium.pedirComidaAsiento();
			}
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("Total vendido en la sala : $" + sala1.calcularTotalVendido());
	}

}
