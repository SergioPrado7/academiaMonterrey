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
		
		Sala sala1 = new Sala(1, peli1, peli1);
		Sala sala2 = new Sala(2, peli2, peli2);
		Sala sala3 = new Sala(3, peli3, peli3);
		
		System.out.println("Funcion en Sala " + sala1.getNumeroSala() + " --->" + " Pelicula: " + sala1.getPeliculaAsignada().getTitulo() + " / Duración: " + sala1.getDuracionPelicula().getDuracionMins() + " mins");
		System.out.println("Funcion en Sala " + sala2.getNumeroSala() + " --->" + " Pelicula: " + sala2.getPeliculaAsignada().getTitulo() + " / Duración: " + sala2.getDuracionPelicula().getDuracionMins() + " mins");
		System.out.println("Funcion en Sala " + sala3.getNumeroSala() + " --->" + " Pelicula: " + sala3.getPeliculaAsignada().getTitulo() + " / Duración: " + sala3.getDuracionPelicula().getDuracionMins() + " mins");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		sala1.VenderBoleto(new BoletoBasico("A1"));
		sala1.VenderBoleto(new BoletoBasico("A2"));
		sala1.VenderBoleto(new BoletoPremium("V1"));
		sala2.VenderBoleto(new BoletoPremium("V1"));
		sala2.VenderBoleto(new BoletoPremium("V2"));
		sala3.VenderBoleto(new BoletoBasico("A1"));
		
		for (Boleto b : sala1.getBoletosVendidos()) {
			System.out.println("El asiento " + b.getNumeroAsiennto() + " --->" + " cobró: $" + b.CalcularPrecio());
			if (b instanceof BoletoPremium) {
				BoletoPremium premium = (BoletoPremium) b;
				premium.PedirComidaAsiento();
			}
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("Total vendido en la sala : $" + sala1.CalcularTotalVendido());
	}

}
