package manage.entitymanagers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import entity.tretmani.*;

public class TretmanManager {
    private String tretmaniFile;
    private HashMap<Integer,Tretman> tretmani;
	private int maxId;
    
    public TretmanManager(String tretmaniFile) {
        this.tretmaniFile = tretmaniFile;
        this.tretmani = new HashMap<Integer,Tretman>();
		this.maxId = 0;
    }

    public HashMap<Integer,Tretman> getTretmani() {
        return tretmani;
    }
    public void setTretmani(HashMap<Integer,Tretman> tretmani) {
        this.tretmani = tretmani;
    }
    public String getTipTretmanaFile() {
        return tretmaniFile;
	}
    public void setTipTretmanaFile(String tretmaniFile) {
        this.tretmaniFile = tretmaniFile;
    }

	// METODE
	public Tretman PronadjiTretmanPoId(int id) {
		if(!this.tretmani.containsKey(id)) {
			System.out.println("Prosledjeni id ne postoji.");
			return null;
		}

		return this.tretmani.get(id);
	}
	
	public Tretman PronadjiTretmanPoNazivu(String naziv) {
		for(Tretman t : this.tretmani.values()) {
			if(t.getNazivTretmana().toLowerCase().equals(naziv.toLowerCase())) {
				return t;
			}
		}
		return null;
	}

    public boolean loadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.tretmaniFile));
			String linija = null;
			while ((linija = br.readLine()) != null) {
				String[] podaci = linija.split(",");
				int id = Integer.parseInt(podaci[0]);
				if(id > this.maxId) {
					this.maxId = id;
				}
				this.tretmani.put(id,new Tretman(id,Integer.parseInt(podaci[1]),podaci[2],LocalTime.parse(podaci[3],DateTimeFormatter.ofPattern("HH:mm")),Double.parseDouble(podaci[4])));
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
			pw = new PrintWriter(new FileWriter(this.tretmaniFile, false));
			for (Tretman s : this.tretmani.values()) {
				pw.println(s.toFileString());
			}
			pw.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

    public void add(int idTipaTretmana, String naziv, LocalTime trajanje, double cena) {
		this.tretmani.put(++this.maxId, new Tretman(this.maxId,idTipaTretmana,naziv,trajanje,cena));	
		this.saveData();
	}

	public void edit(int idTretmana, int idTipaTretmana, String naziv, LocalTime trajanje, double cena) {
		Tretman t = this.PronadjiTretmanPoId(idTretmana);
		t.setNazivTretmana(naziv);
		t.setIdTipaTretmana(idTipaTretmana);
		t.setTrajanje(trajanje);
		t.setCena(cena);
		this.saveData();
	}


	public void remove(int id) {
		if(!this.tretmani.containsKey(id)) {
			System.out.println("Prosledjeni id ne postoji.");
			return;
		}

		this.tretmani.remove(id);
		this.saveData();
	}
	
	public void prikaz() {
		System.out.println("--------------------");
		System.out.println("   Tretmani:");
		for(Tretman t : this.tretmani.values()) {
			System.out.println(t);
		}
	}
}
