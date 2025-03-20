package main;

import utils.AppSettings;
import entity.tretmani.*;

import java.time.LocalTime;
import java.util.ArrayList;

import manage.ManagerFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Podesavanje aplikacije ...");

		AppSettings appSettings = new AppSettings("./data/klijenti.csv","./data/menadzeri.csv","./data/kozmeticari.csv","./data/recepcioneri.csv",
												"./data/tipoviTretmana.csv","./data/tretmani.csv","./data/kozmetickiSaloni.csv","./data/zakazaniTretmani.csv");
		ManagerFactory controlers = new ManagerFactory(appSettings);
		
		controlers.loadData();
		
		controlers.getKozmetickiSalonMng().add("Moj salon", LocalTime.of(8, 0), LocalTime.of(20, 0));
		
		controlers.getMenadzerMng().add("Nikola","Nikolić",null, null, null, null, null, null, 0, 0, 0);
		
		controlers.getRecepcionerMng().add("Pera", "Perić",null, null, null, null, null, null, 0, 0, 0);
		
		controlers.getKozmeticarMng().add("Sima", "Simić",null, null, null, null, null, null, 0, 0, 0);
		controlers.getKozmeticarMng().add("Žika", "Žikić",null, null, null, null, null, null, 0, 0, 0);
		controlers.getKozmeticarMng().add("Jadranka", "Jovanović", null, null, null, null, null, null, 0, 0, 0);

        controlers.getKlijentMng().add("Milića", "Milić",null, null, null, null, null, 0, 0);
        controlers.getKlijentMng().add("Mika", "Mikić",null, null, null, null, null, 0, 0);
		
        int id = controlers.pronadjiKorisnika("Jadranka", "Jovanović", "kozmeticar").getId();
        controlers.getKozmeticarMng().edit(id,"Jovana", "Jovanović", null, null, null, null, null, null, 0, 0, 0, null);
        
        controlers.prikaziKorisnike();
        
        id = controlers.pronadjiKorisnika("Žika", "Žikić", "kozmeticar").getId();
        controlers.getKozmeticarMng().remove(id);
        
        controlers.prikaziKorisnike();
        
        controlers.getTipTretmanaMng().add("manikir");
        controlers.getTipTretmanaMng().add("pedikir");
        controlers.getTipTretmanaMng().add("masaza");
        
        id = controlers.getTipTretmanaMng().PronadjiTipTretmanaPoNazivu("masaza").getIdTipaTretmana();
        controlers.getTretmanMng().add(id, "Relaks masaza", LocalTime.of(0, 45), 2000);
        controlers.getTretmanMng().add(id, "Sportska masaza", LocalTime.of(1, 15), 2500);
        controlers.getTretmanMng().add(id, "Spa pedikir", LocalTime.of(0, 45), 1600);
        id = controlers.getTipTretmanaMng().PronadjiTipTretmanaPoNazivu("manikir").getIdTipaTretmana();
        controlers.getTretmanMng().add(id, "Francuski manikir", LocalTime.of(0, 50), 1500);
        controlers.getTretmanMng().add(id, "Gel lak", LocalTime.of(1, 20), 1600);
        controlers.getTretmanMng().add(id, "Spa manikir", LocalTime.of(1, 30), 2000);
        
        controlers.getTretmanMng().prikaz();
        
        Tretman t = controlers.getTretmanMng().PronadjiTretmanPoNazivu("Francuski manikir");
        controlers.getTretmanMng().edit(t.getIdTretmana(),t.getIdTipaTretmana(),t.getNazivTretmana(),LocalTime.of(0, 55),t.getCena());
        
        t = controlers.getTretmanMng().PronadjiTretmanPoNazivu("Spa pedikir");
        id = controlers.getTipTretmanaMng().PronadjiTipTretmanaPoNazivu("pedikir").getIdTipaTretmana();
        controlers.getTretmanMng().edit(t.getIdTretmana(),id,t.getNazivTretmana(),t.getTrajanje(),t.getCena());
        
        controlers.getTretmanMng().prikaz();
        
        controlers.getTipTretmanaMng().remove(id,controlers.getTretmanMng(),controlers.getZakazanTretmanMng());
        
        controlers.getTretmanMng().prikaz();
        
        id = controlers.pronadjiKorisnika("Sima", "Simić", "kozmeticar").getId();
        ArrayList<Integer> tipoviTretmana = new ArrayList<Integer>();
        tipoviTretmana.add(controlers.getTipTretmanaMng().PronadjiTipTretmanaPoNazivu("manikir").getIdTipaTretmana());
        tipoviTretmana.add(controlers.getTipTretmanaMng().PronadjiTipTretmanaPoNazivu("masaza").getIdTipaTretmana());
        controlers.getKozmeticarMng().edit(id, "Sima", "Simić", null, null, null, null, null, null, id, id, id, tipoviTretmana);
        
        id = controlers.pronadjiKorisnika("Jovana", "Jovanović", "kozmeticar").getId();
        ArrayList<Integer> tipoviTretmana2 = new ArrayList<Integer>();
        tipoviTretmana2.add(controlers.getTipTretmanaMng().PronadjiTipTretmanaPoNazivu("manikir").getIdTipaTretmana());
        controlers.getKozmeticarMng().edit(id, "Jovana", "Jovanović", null, null, null, null, null, null, id, id, id, tipoviTretmana2);
        
        int idKozmeticara = controlers.pronadjiKorisnika("Sima", "Simić", "kozmeticar").getId();
        int idKlijenta = controlers.pronadjiKorisnika("Milića", "Milić", "klijent").getId();
        id = controlers.getTretmanMng().PronadjiTretmanPoNazivu("relaks masaza").getIdTretmana();
        controlers.getZakazanTretmanMng().add(idKozmeticara, idKlijenta, id, null, null, controlers.getTretmanMng().getTretmani().get(id).getCena());

        idKlijenta = controlers.pronadjiKorisnika("Mika", "Mikić", "klijent").getId();
        id = controlers.getTretmanMng().PronadjiTretmanPoNazivu("gel lak").getIdTretmana();
        int id2 = controlers.getZakazanTretmanMng().add(idKozmeticara, idKlijenta, id, null, null, controlers.getTretmanMng().getTretmani().get(id).getCena());
     
        
        idKozmeticara = controlers.pronadjiKorisnika("Jovana", "Jovanović", "kozmeticar").getId();
        id = controlers.getTretmanMng().PronadjiTretmanPoNazivu("spa manikir").getIdTretmana();
        controlers.getZakazanTretmanMng().add(idKozmeticara, idKlijenta, id, null, null, controlers.getTretmanMng().getTretmani().get(id).getCena());
        
        controlers.getZakazanTretmanMng().prikaz();
        
        id = controlers.getTretmanMng().PronadjiTretmanPoNazivu("francuski manikir").getIdTretmana();
        controlers.getZakazanTretmanMng().edit(id2, idKozmeticara, idKlijenta, id, null, null, controlers.getTretmanMng());
        
        controlers.getZakazanTretmanMng().prikaz();
        
        Tretman tretman = controlers.getTretmanMng().PronadjiTretmanPoNazivu("relaks masaza");
        controlers.getTretmanMng().edit(tretman.getIdTretmana(),tretman.getIdTipaTretmana(),tretman.getNazivTretmana(),tretman.getTrajanje(),1700);
        
        controlers.getZakazanTretmanMng().prikaz();
        
    }
}
