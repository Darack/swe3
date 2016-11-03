package de.hsb.app.kv.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import de.hsb.app.kv.model.Kunde;

@ManagedBean(name = "kundenHandler")
@SessionScoped
public class KundenHandler {
	private List<Kunde> kundenListe = Arrays.asList(new Kunde[] {
			new Kunde("Hugo", "Hermann", LocalDate.of(1970, 1, 1)),
			new Kunde("Willi", "Meier", LocalDate.of(1960, 2, 2)),
			new Kunde("Alan", "Turing", LocalDate.of(1912, 6, 23)),
			new Kunde("Donald", "Knuth", LocalDate.of(1938, 1, 10)),
			new Kunde("Edsger W.", "Dijkstra", LocalDate.of(1930, 5, 11))
	});
	
	public String neu(Kunde k) {
		System.out.println(k.getVorname() + " " + k.getNachname() + " " + k.getGeburtsdatum());
		return "alleKunden";
	}
	
	public List<Kunde> getKundenListe() {
		return kundenListe;
	}

	public void setKundenListe(List<Kunde> kundenListe) {
		this.kundenListe = kundenListe;
	}
}
