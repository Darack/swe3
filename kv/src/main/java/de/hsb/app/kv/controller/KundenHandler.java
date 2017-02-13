package de.hsb.app.kv.controller;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import de.hsb.app.kv.model.Kunde;

@ManagedBean(name = "kundenHandler")
@SessionScoped
public class KundenHandler {
	
	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private UserTransaction utx;
	
	private DataModel<Kunde> kunden;
	private Kunde merkeKunde = new Kunde();
	
//	private List<Kunde> kundenListe = Arrays.asList(new Kunde[] {
//			new Kunde("Hugo", "Hermann", new Date(1970, 1, 1)),
//			new Kunde("Willi", "Meier", new Date(1960, 2, 2)),
//			new Kunde("Alan", "Turing", new Date(1912, 6, 23)),
//			new Kunde("Donald", "Knuth", new Date(1938, 1, 10)),
//			new Kunde("Edsger W.", "Dijkstra", new Date(1930, 5, 11))
//	});
	
	@PostConstruct
	public void init() {
		try {
			utx.begin();
			em.persist(new Kunde("Hugo", "Hermann", new Date(1970, 1, 1)));
			em.persist(new Kunde("Willi", "Meier", new Date(1960, 2, 2)));
			em.persist(new Kunde("Alan", "Turing", new Date(1912, 6, 23)));
			em.persist(new Kunde("Donald", "Knuth", new Date(1938, 1, 10)));
			em.persist(new Kunde("Edsger W.", "Dijkstra", new Date(1930, 5, 11)));
			kunden = new ListDataModel<Kunde>();
			kunden.setWrappedData(em.createNamedQuery("SelectKunden").getResultList());
			utx.commit();
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("error in init()");
		}
	}
	
	public String neu() {
//		System.out.println(k.getVorname() + " " + k.getNachname() + " " + k.getGeburtsdatum());
		merkeKunde = new Kunde();
		return "neuerKunde";
	}
	
	public String speichern() {
		try {
			utx.begin();
			merkeKunde = em.merge(merkeKunde);
			em.persist(merkeKunde);
			kunden.setWrappedData(em.createNamedQuery("SelectKunden").getResultList());
			utx.commit();
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("error in speichern()");
		}
		
		return "alleKunden";
	}
	
//	public List<Kunde> getKundenListe() {
//		return kundenListe;
//	}
//
//	public void setKundenListe(List<Kunde> kundenListe) {
//		this.kundenListe = kundenListe;
//	}

	public DataModel<Kunde> getKunden() {
		return kunden;
	}

	public void setKunden(DataModel<Kunde> kunden) {
		this.kunden = kunden;
	}

	public Kunde getMerkeKunde() {
		return merkeKunde;
	}

	public void setMerkeKunde(Kunde merkeKunde) {
		this.merkeKunde = merkeKunde;
	}
}
