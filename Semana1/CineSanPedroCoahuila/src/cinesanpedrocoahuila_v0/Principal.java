package cinesanpedrocoahuila_v0;

public class Principal {

	public static void main(String[] args) {
		Cine cine1 = new Cine();
		System.out.println("Bienvenidos al " + cine1.getNombreCine());
		System.out.println("El cual esta ubicado en " + cine1.getUbicacionCine());
		
		Pelicula peli1 = new Pelicula("El Padrino", 95);
		Pelicula peli2 = new Pelicula("Avenger End Game", 115);
		Pelicula peli3 = new Pelicula("Spiderman Brands New Day", 125);
		
		Sala sala1 = new Sala(1, peli1);
		Sala sala2 = new Sala(2, peli2);
		Sala sala3 = new Sala(3, peli3);
	}

}
