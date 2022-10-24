package week1.exercises;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class HenkiloMapSovellus {
	
	private Scanner input = new Scanner(System.in);
	private Map<String, Henkilo> henkilot = new HashMap<String, Henkilo>();
	
	int kysyValinta() {
		int valinta;
		
		System.out.println("\n1. Lisää henkilö"
							+ "\n2. Näytä henkilön tiedot"
							+ "\n3. Muuta henkilön nimi ja osoite"
							+ "\n4. Muuta henkilön koko"
							+ "\n5. Näytä kaikki henkilöt"
							+ "\n0. Lopetus");
		System.out.print("Anna valintasi (0-5): ");
		valinta = input.nextInt();
		input.nextLine();
		
		return valinta;
	}
	
	void lisaaHenkilo() {
		
	}
	
	void naytaHenkilonTiedot() {
		
	}
	
	void muutaHenkilonNimiJaOsoite() {
		
	}
	
	void muutaHenkilonKoko() {
		
	}
	
	void naytaKaikkiHenkilot() {
		
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
