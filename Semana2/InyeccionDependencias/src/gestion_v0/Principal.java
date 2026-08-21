package gestion_v0;

public class Principal {
	public static void main(String[] args) {
		System.out.println("ESTE ES EL SISTEMA DE GESTION DEL CINE SAN PEDRO");
		
		SalaCine salaVIP = AdministradorCine.configurarSalaVIP();
		SalaCine salaBase = AdministradorCine.configurarSalaBase();
		
		salaVIP.iniciarFuncion("Narnia");
		System.out.println("--------------------------------------");
		salaBase.iniciarFuncion("End Game");
	}
}
