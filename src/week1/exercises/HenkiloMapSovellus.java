package week1.exercises;

import java.util.Map;
import java.util.HashMap;
import java.text.DecimalFormat;

class HenkiloMapSovellus {
	
	private Map<String, Henkilo> henkilot = new HashMap<String, Henkilo>();
	private Lukija lukija = new Lukija();
	
	int kysyValinta() {
		System.out.println("\n1. Lisää henkilö"
							+ "\n2. Näytä henkilön tiedot"
							+ "\n3. Muuta henkilön nimi ja osoite"
							+ "\n4. Muuta henkilön koko"
							+ "\n5. Näytä kaikki henkilöt"
							+ "\n0. Lopetus");
		
		int valinta = lukija.lueKokonaisluku("Anna valintasi (0-5): ");
		
		return valinta;
	}
	
	void lisaaHenkilo() {
		String nimi, osoite;
		double pituus;
		int paino;
		
		nimi = lukija.lueTeksti("Anna nimi: ");
		osoite = lukija.lueTeksti("Anna osoite: ");
		pituus = lukija.lueDesimaaliluku("Anna pituus: ");
		paino = lukija.lueKokonaisluku("Anna paino: ");
		
		// Luo koko ja henkilo
		Koko koko = new Koko(pituus, paino);
		Henkilo henkilo = new Henkilo(nimi, osoite, koko);
		
		// lisää HashMappiin
		henkilot.put(nimi, henkilo);
	}
	
	void naytaHenkilonTiedot() {
		String nimi = lukija.lueTeksti("Anna näytettävän henkilön nimi: ");
		
		if (henkilot.containsKey(nimi)) {
			Henkilo henkilo = henkilot.get(nimi);
			System.out.println("Nimi: " + henkilo.getNimi()
								+ "\nOsoite: " + henkilo.getOsoite());
			
			// Jos koko on olemassa
			if (henkilo.getKoko() != null) {
				DecimalFormat decimals = new DecimalFormat("0.00");
				System.out.println("Pituus: " + decimals.format(henkilo.getKoko().getPituus())
									+ "\nPainoindeksi: " + decimals.format(henkilo.getKoko().getPainoindeksi()));
			}
			
		} else 
			System.out.println("Henkilöä ei ole");
	}
	
	void muutaHenkilonNimiJaOsoite() {
		String nimi = lukija.lueTeksti("Anna perustietoja muutettavan henkilön nimi: ");
		
		if (henkilot.containsKey(nimi)) {
			String uusiNimi = lukija.lueTeksti("Anna nimi: ");
			String uusiOsoite = lukija.lueTeksti("Anna osoite: ");
			
			Henkilo henkilo = henkilot.get(nimi);
			henkilo.setNimi(uusiNimi);
			henkilo.setOsoite(uusiOsoite);
			
			// Muuta avaimen nimi
			henkilot.remove(nimi);
			henkilot.put(uusiNimi, henkilo);
		}
	}
	
	void muutaHenkilonKoko() {
		String nimi = lukija.lueTeksti("Anna kokoa muutettavan henkilön nimi: ");
		
		if (henkilot.containsKey(nimi)) {
			Henkilo henkilo = henkilot.get(nimi);
			
			if (henkilo.getKoko() != null) {
				double pituus = lukija.lueDesimaaliluku("Anna pituus: ");
				int paino = lukija.lueKokonaisluku("Anna paino: ");
				
				henkilo.getKoko().setPituus(pituus);
				henkilo.getKoko().setPaino(paino);
			}
			
		} else
			System.out.println("Henkilöä ei ole");
	}
	
	void naytaKaikkiHenkilot() {
		for (String k : henkilot.keySet()) {
			Henkilo henkilo = henkilot.get(k);
			System.out.println("\nNimi: " + henkilo.getNimi()
								+ "\nOsoite: " + henkilo.getOsoite());
			
			if (henkilo.getKoko() != null) {
				DecimalFormat decimals = new DecimalFormat("0.00");
				System.out.println("Pituus: " + decimals.format(henkilo.getKoko().getPituus())
									+ "\nPainoindeksi: " + decimals.format(henkilo.getKoko().getPainoindeksi()));
			}
		}
	}

	public static void main(String[] args) {
		HenkiloMapSovellus ohjelma = new HenkiloMapSovellus();
		int valinta = -1;
		
		// 0 lopettaa ohjelman
		while (valinta != 0) {
			valinta = ohjelma.kysyValinta();
			
			switch (valinta) {
			case 0:
				return;
				
			case 1:
				ohjelma.lisaaHenkilo();
				break;
				
			case 2:
				ohjelma.naytaHenkilonTiedot();
				 break;
				 
			case 3:
				ohjelma.muutaHenkilonNimiJaOsoite();
				break;
				
			case 4:
				ohjelma.muutaHenkilonKoko();
				break;
				
			case 5:
				ohjelma.naytaKaikkiHenkilot();
				break;
				
			default:
				System.out.println("Virheellinen syöte!");
			}
		}
	}

}
