package week1.exercises;

public class Tyontekija extends Henkilo {

	private double tuntipalkka;
	
	public Tyontekija() {
		tuntipalkka = 0.0;
	}

	public Tyontekija(String nimi, String osoite, double tuntipalkka) {
		super(nimi, osoite);
		this.tuntipalkka = tuntipalkka;
	}

	public double getTuntipalkka() {
		return tuntipalkka;
	}

	public void setTuntipalkka(double tuntipalkka) {
		this.tuntipalkka = tuntipalkka;
	}

	@Override
	public String toString() {
		return "Tyontekija [tuntipalkka=" + tuntipalkka + ", getNimi()=" + getNimi()
				+ ", getOsoite()=" + getOsoite() + "]";
	}

}
