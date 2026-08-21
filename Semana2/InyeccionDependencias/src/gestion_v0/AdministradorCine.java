package gestion_v0;

public class AdministradorCine {
	public static SalaCine configurarSalaVIP() {
		Proyector proyectorIMAX = new ProyectorIMAX();
		return new SalaCine("V1", proyectorIMAX);
	}
	
	public static SalaCine configurarSalaBase() {
		Proyector proyectorDigital = new ProyectorDigital();
		return new SalaCine("B1", proyectorDigital);
	}
}
