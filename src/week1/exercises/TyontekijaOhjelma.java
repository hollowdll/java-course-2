package week1.exercises;

import java.text.DecimalFormat;

public class TyontekijaOhjelma {
	
	private Tyontekija tyontekija;
	private Lukija lukija = new Lukija();
	
	public void luoTyontekija() {
		// Kysy tiedot
		String nimi = lukija.lueTeksti("Anna nimi: ");
		String osoite = lukija.lueTeksti("Anna osoite: ");
		double tuntipalkka = lukija.lueDesimaaliluku("Anna tuntipalkka: ");
		
		tyontekija = new Tyontekija();
		tyontekija.setNimi(nimi);
		tyontekija.setOsoite(osoite);
		tyontekija.setTuntipalkka(tuntipalkka);
	}
	
	public void luoTyontekijaTiedoilla() {
		String nimi = lukija.lueTeksti("Anna nimi: ");
		String osoite = lukija.lueTeksti("Anna osoite: ");
		double tuntipalkka = lukija.lueDesimaaliluku("Anna tuntipalkka: ");
		
		tyontekija = new Tyontekija(nimi, osoite, tuntipalkka);
	}
	
	public void naytaTiedot() {
		if (tyontekija != null) {
			DecimalFormat decimals = new DecimalFormat("0.00");
			
			System.out.println("\nNimi: " + tyontekija.getNimi()
								+ "\nOsoite: " + tyontekija.getOsoite()
								+ "\nTuntipalkka: " + decimals.format(tyontekija.getTuntipalkka()));
		}
	}

	public static void main(String[] args) {
		TyontekijaOhjelma ohjelma = new TyontekijaOhjelma();
		
		ohjelma.luoTyontekija();
		ohjelma.naytaTiedot();
	}

}
