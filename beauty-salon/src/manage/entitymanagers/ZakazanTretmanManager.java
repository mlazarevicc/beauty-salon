package manage.entitymanagers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashMap;

import entity.tretmani.ZakazanTretman;
import enumeracije.*;
import utils.AppSettings;

public class ZakazanTretmanManager {
    private String zakazanTretmanFile;
    private HashMap<Integer,ZakazanTretman> zakazaniTretmani;
    private int maxId;
    
    public ZakazanTretmanManager(String zakazanTretmanFile) {
        this.zakazanTretmanFile = zakazanTretmanFile;
        this.zakazaniTretmani = new HashMap<Integer,ZakazanTretman>();
        this.maxId = 0;
    }

    public HashMap<Integer,ZakazanTretman> getZakazanTretmani() {
        return zakazaniTretmani;
    }
    public void setZakazanTretmani(HashMap<Integer,ZakazanTretman> zakazaniTretmani) {
        this.zakazaniTretmani = zakazaniTretmani;
    }
    public String getZakazanTretmanFile() {
        return zakazanTretmanFile;
    }
    public void setZakazanTretmanFile(String zakazanTretmanFile) {
        this.zakazanTretmanFile = zakazanTretmanFile;
    }
    public int getMaxId() {
		return maxId;
	}

	// METODE
	public ZakazanTretman PronadjiZakazanTretmanaPoId(int id) {
		if(!this.zakazaniTretmani.containsKey(id)) {
			System.out.println("Prosledjeni id ne postoji.");
			return null;
		}

		return this.zakazaniTretmani.get(id);
	}

    public boolean loadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.zakazanTretmanFile));
			String linija = null;
			while ((linija = br.readLine()) != null) {
				String[] podaci = linija.split(",");
				int id = Integer.parseInt(podaci[0]);
				if(id > this.maxId) {
					this.maxId = id;
				}
				this.zakazaniTretmani.put(id,new ZakazanTretman(id,Integer.parseInt(podaci[1]),Integer.parseInt(podaci[2]),Integer.parseInt(podaci[3]),
						AppSettings.parseDate(podaci[4]),StanjeTretmana.valueOfString(podaci[5]),Double.parseDouble(podaci[6])));
			}
			br.close();
		} catch (IOException e) {
			return false;
		}
		
		return true;
	}
    
    public boolean saveData() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(this.zakazanTretmanFile, false));
			for (ZakazanTretman s : this.zakazaniTretmani.values()) {
				pw.println(s.toFileString());
			}
			pw.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

    public int add(int idKozmeticara, int idKlijenta, int idTretmana,
					LocalDateTime termin, StanjeTretmana stanje, double ukupnaCena) {
    	this.zakazaniTretmani.put(++this.maxId, new ZakazanTretman(this.maxId,idKozmeticara,idKlijenta,idTretmana,termin,stanje,ukupnaCena));	
		this.saveData();
		return this.maxId;
	}
    
    public int add(int idKozmeticara, int idKlijenta, int idTretmana,
					LocalDateTime termin, StanjeTretmana stanje, TretmanManager tretmanMng) {
    	double cena = tretmanMng.getTretmani().get(idTretmana).getCena();
		this.zakazaniTretmani.put(++this.maxId, new ZakazanTretman(this.maxId,idKozmeticara,idKlijenta,idTretmana,termin,stanje,cena));	
		this.saveData();
		return this.maxId;
	}
    

	public void edit(int idZakazanogTretmana, int idKozmeticara, int idKlijenta, int idTretmana,
					 LocalDateTime termin, StanjeTretmana stanje, TretmanManager tretmanMng) {
		ZakazanTretman s = this.PronadjiZakazanTretmanaPoId(idZakazanogTretmana);
		s.setIdKozmeticara(idKozmeticara);
		s.setIdKlijenta(idKlijenta);
		s.setIdTretmana(idTretmana);
		s.setTermin(termin);
		s.setStanje(stanje);
		s.setCena(tretmanMng.getTretmani().get(idTretmana).getCena());
		this.saveData();
	}

	public void remove(int id) {
		if(!this.zakazaniTretmani.containsKey(id)) {
			System.out.println("Prosledjeni id ne postoji.");
			return;
		}

		this.zakazaniTretmani.remove(id);
		this.saveData();
	}
	
	public void prikaz() {
		System.out.println("--------------------");
		System.out.println("   Zakazni tretmani:");
		for(ZakazanTretman t : this.zakazaniTretmani.values()) {
			System.out.println(t);
		}
	}
}
