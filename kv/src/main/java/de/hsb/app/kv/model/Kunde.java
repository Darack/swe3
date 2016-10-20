package de.hsb.app.kv.model;

public class Kunde {
	/**
	 * @param vorname
	 * @param nachname
	 * @param geburtsdatum
	 */
	public Kunde(String vorname, String nachname, String geburtsdatum) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsdatum = geburtsdatum;
	}
	private String vorname;
	private String nachname;
	private String geburtsdatum;
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
}
