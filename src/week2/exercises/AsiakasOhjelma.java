package week2.exercises;



/* CRUD = Create, Read, Update, Delete */

public class AsiakasOhjelma {
	
	private Lukija lukija = new Lukija();
	
	public void naytaValikko() {
		int valinta = -1;
		
		while (valinta != 0) {
			System.out.println("\n1. Lisää asiakas"
					+ "\n2. Näytä asiakkaat"
					+ "\n3. Muuta asiakas"
					+ "\n4. Poista asiakas"
					+ "\n0. Lopetus");

			valinta = lukija.lueKokonaisluku("Valintasi: ");
			
			switch (valinta) {
			case 0:
				return;
				
			case 1:
				lisaaAsiakas();
				break;
				
			case 2:
				listaaAsiakkaat();
				break;
				
			case 3:
				muutaAsiakas();
				break;
				
			case 4:
				poistaAsiakas();
				break;
				
			default:
				System.out.println("Virheellinen syöte!");
			}
		}
	}
	
	private void lisaaAsiakas() {
		
	}
	
	private void listaaAsiakkaat() {
		
	}
	
	private void muutaAsiakas() {
		
	}
	
	private void poistaAsiakas() {
		
	}

	public static void main(String[] args) {
		AsiakasOhjelma ohjelma = new AsiakasOhjelma();
		ohjelma.naytaValikko();
	}

}
