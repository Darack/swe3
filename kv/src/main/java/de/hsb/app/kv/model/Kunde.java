package de.hsb.app.kv.model;

public class Kunde {
	/**
	 * @param vorname
	 * @param nachname
	 * @param geburtsdatum
	 */
	public Kunde(String vorname, String nachname, java.time.LocalDate geburtsdatum) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.geburtsdatum = geburtsdatum;
	}
	
	public Kunde() {}
	
	private String vorname;
	private String nachname;
	private java.time.LocalDate geburtsdatum;
	
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
	public java.time.LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(java.time.LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}
}
