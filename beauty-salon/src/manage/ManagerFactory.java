package manage;

import entity.korisnici.*;
import manage.entitymanagers.*;
import utils.AppSettings;

public class ManagerFactory {
	private AppSettings appSettings;
	private KlijentManager klijentMng;
	private MenadzerManager menadzerMng;
	private KozmeticarManager kozmeticarMng;
	private RecepcionerManager recepcionerMng;
	private TipTretmanaManager tipTretmanaMng;
	private TretmanManager tretmanMng;
	private KozmetickiSalonManager kozmetickiSalonMng;
	private ZakazanTretmanManager zakazanTretmanMng;
	
	public ManagerFactory(AppSettings appSettings) {
		this.appSettings = appSettings;
		this.klijentMng = new KlijentManager(this.appSettings.getKlijentFilename());
		this.menadzerMng = new MenadzerManager(this.appSettings.getMenadzerFilename());
		this.kozmeticarMng = new KozmeticarManager(this.appSettings.getKozmeticarFilename());
		this.recepcionerMng = new RecepcionerManager(this.appSettings.getRecepcionerFilename());
		this.tipTretmanaMng = new TipTretmanaManager(this.appSettings.getTipTretmanaFilename());
		this.tretmanMng = new TretmanManager(this.appSettings.getTretmanFilename());
		this.kozmetickiSalonMng = new KozmetickiSalonManager(this.appSettings.getKozmetickiSalonFilename());
		this.zakazanTretmanMng = new ZakazanTretmanManager(this.appSettings.getZakazanTretmanFilename());
	}

	public KlijentManager getKlijentMng() {
		return klijentMng;
	}
	public MenadzerManager getMenadzerMng() {
		return menadzerMng;
	}
	public KozmeticarManager getKozmeticarMng() {
		return kozmeticarMng;
	}
	public RecepcionerManager getRecepcionerMng() {
		return recepcionerMng;
	}
	public TipTretmanaManager getTipTretmanaMng() {
		return tipTretmanaMng;
	}
	public TretmanManager getTretmanMng() {
		return tretmanMng;
	}
	public ZakazanTretmanManager getZakazanTretmanMng() {
		return zakazanTretmanMng;
	}
	public KozmetickiSalonManager getKozmetickiSalonMng() {
		return kozmetickiSalonMng;
	}

	public void loadData() {
		this.klijentMng.loadData();
		this.menadzerMng.loadData();
		this.kozmeticarMng.loadData();
		this.recepcionerMng.loadData();
		this.tipTretmanaMng.loadData();
		this.tretmanMng.loadData();
		this.kozmetickiSalonMng.loadData();
		this.zakazanTretmanMng.loadData();
	}
	
	public void prikaziKorisnike() {
		System.out.println("-----------------------");
		System.out.println("   Menadzeri:");
    	for(Menadzer k : getMenadzerMng().getMenadzeri().values()) {
            System.out.println(k);
        }
    	System.out.println("-----------------------");
		System.out.println("   Kozmeticari:");
    	for(Kozmeticar k : getKozmeticarMng().getKozmeticari().values()) {
            System.out.println(k);
        }
    	System.out.println("-----------------------");
		System.out.println("   Recepcioneri:");
    	for(Recepcioner k : getRecepcionerMng().getRecepcioneri().values()) {
            System.out.println(k);
        }
    	System.out.println("-----------------------");
		System.out.println("   Klijenti:");
		for(Klijent k : getKlijentMng().getKlijenti().values()) {
            System.out.println(k);
        }
	}
	
	public Korisnik pronadjiKorisnika(String ime, String prezime, String uloga) {
		switch(uloga) {
			case "menadzer": 
				for(Menadzer k : getMenadzerMng().getMenadzeri().values()) {
    				if(k.getIme().toLowerCase().equals(ime.toLowerCase()) && k.getPrezime().toLowerCase().equals(prezime.toLowerCase())) {
    					return k;
    				}
				 }
	            break;
			case "kozmeticar": 
				for(Kozmeticar k : getKozmeticarMng().getKozmeticari().values()) {
			   	   if(k.getIme().toLowerCase().equals(ime.toLowerCase()) && k.getPrezime().toLowerCase().equals(prezime.toLowerCase())) {
					  return k;
				   }
			    }
			    break;
			case "recepcioner":
				for(Recepcioner k : getRecepcionerMng().getRecepcioneri().values()) {
			   	    if(k.getIme().toLowerCase().equals(ime.toLowerCase()) && k.getPrezime().toLowerCase().equals(prezime.toLowerCase())) {
					  return k;
			   	    }
			    }
				break;
			case "klijent":
				for(Klijent k : getKlijentMng().getKlijenti().values()) {
			   	    if(k.getIme().toLowerCase().equals(ime.toLowerCase()) && k.getPrezime().toLowerCase().equals(prezime.toLowerCase())) {
					  return k;
				    }
			    }
			    break;
			default: 
				return null;
	        }
		
		return null;
	}
	
}
	