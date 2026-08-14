package cinesanpedrocoahuila_v1;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		double totalDineroCine = 0;
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
		
		ArrayList<Sala> listaSalas = new ArrayList<>();
		listaSalas.add(sala1);
		listaSalas.add(sala2);
		listaSalas.add(sala3);
		
		for(Sala salaActual : listaSalas) {
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Reporte de la Sala " + salaActual.getNumeroSala());
			for (Boleto b : salaActual.getBoletosVendidos()) {
				System.out.println("El asiento " + b.getNumeroAsiennto() + " --->" + "Se cobró: $" + b.calcularPrecio());
				if (b instanceof BoletoPremium) {
					BoletoPremium premium = (BoletoPremium) b;
					premium.pedirComidaAsiento();
				}
			}
			double totalSala = salaActual.calcularTotalVendido();
			System.out.println("Total vendido en la sala " + salaActual.getNumeroSala() + " = $" + totalSala);
			totalDineroCine += totalSala;
		}
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("Total vendido en el " + cine1.getNombreCine() + " = $" + totalDineroCine);
	}

}
