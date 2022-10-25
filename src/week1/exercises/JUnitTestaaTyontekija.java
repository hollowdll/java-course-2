package week1.exercises;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class JUnitTestaaTyontekija {

	@Test
	public void testGetNimi() {
		Tyontekija t = new Tyontekija();
		final String NIMI = "Kalle";
		t.setNimi(NIMI);
		assertEquals(NIMI, t.getNimi());
	}
	
	@Test
	public void testGetOsoite() {
		Tyontekija t = new Tyontekija();
		final String OSOITE = "Mannerheimintie";
		t.setOsoite(OSOITE);
		assertEquals(OSOITE, t.getOsoite());
	}
	
	@Test
	public void testGetKoko() {
		final double PITUUS = 200;
		final int PAINO = 80;
		Tyontekija t = new Tyontekija();
		Koko k = new Koko(PITUUS, PAINO);
		t.setKoko(k);
		assertEquals(k, t.getKoko());
	}
	
	@Test
	public void testGetTuntipalkka() {
		Tyontekija t = new Tyontekija();
		final double TUNTIPALKKA = 18.75;
		t.setTuntipalkka(TUNTIPALKKA);
		assertEquals(TUNTIPALKKA, t.getTuntipalkka(), 0.01);
	}

}
