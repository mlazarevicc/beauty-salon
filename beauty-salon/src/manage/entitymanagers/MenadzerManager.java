package manage.entitymanagers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import enumeracije.*;
import entity.korisnici.Menadzer;


public class MenadzerManager {
    private String menadzerFile;
    private HashMap<Integer,Menadzer> menadzeri;
	private int maxId;
    
    public MenadzerManager(String menadzerFile) {
        this.menadzerFile = menadzerFile;
        this.menadzeri = new HashMap<Integer,Menadzer>();
		this.maxId = 0;
    }

    public HashMap<Integer,Menadzer> getMenadzeri() {
        return menadzeri;
    }
    public void setMenadzeri(HashMap<Integer,Menadzer> menadzeri) {
        this.menadzeri = menadzeri;
    }
    public String getMenadzerFile() {
        return menadzerFile;
	}
    public void setMenadzerFile(String menadzerFile) {
        this.menadzerFile = menadzerFile;
    }
	public int getMaxId() {
		return maxId;
	}

	// METODE
	public Menadzer PronadjiMenadzeraPoId(int id) {
		if(!this.menadzeri.containsKey(id)) {
			System.out.println("Prosledjeni id ne postoji.");
			return null;
		}

		return this.menadzeri.get(id);
	}

    public boolean loadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.menadzerFile));
			String linija = null;
			while ((linija = br.readLine()) != null) {
				String[] podaci = linija.split(",");
				int id = Integer.parseInt(podaci[0]);
				if(id > this.maxId) {
					this.maxId = id;
				}
				this.menadzeri.put(id, new Menadzer(id,podaci[1],podaci[2],Pol.valueOfString(podaci[3]),podaci[4],podaci[5],podaci[6],podaci[7],
						 NivoStrucneSpreme.valueOfString(podaci[8]),Integer.parseInt(podaci[9]),Double.parseDouble(podaci[10]),Double.parseDouble(podaci[11])));
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
			pw = new PrintWriter(new FileWriter(this.menadzerFile, false));
			for (Menadzer s : this.menadzeri.values()) {
				pw.println(s.toFileString());
			}
			pw.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

    public void add(String ime, String prezime, Pol pol, String telefon, String adresa,
                    String korisnickoIme, String lozinka, NivoStrucneSpreme nivoStrucneSpreme,
                    int staz, double plata, double bonus) {
    	this.menadzeri.put(++this.maxId, new Menadzer(this.maxId,ime,prezime,pol,telefon,adresa,korisnickoIme,lozinka,nivoStrucneSpreme,staz,plata,bonus));
		this.saveData();
	}


	public void edit(int idMenadzera, String ime, String prezime, Pol pol, String telefon, String adresa,
                     String korisnickoIme, String lozinka, NivoStrucneSpreme nivoStrucneSpreme,
                     int staz, double plata, double bonus) {
		Menadzer s = this.PronadjiMenadzeraPoId(idMenadzera);
		s.setIme(ime);
		s.setPrezime(prezime);
		s.setPol(pol);
        s.setTelefon(telefon);
        s.setAdresa(adresa);
        s.setKorisnickoIme(korisnickoIme);
        s.setLozinka(lozinka);
        s.setNivoStrucneSpreme(nivoStrucneSpreme);
        s.setStaz(staz);
        s.setPlata(plata);
        s.setBonus(bonus);
		this.saveData();
	}

	public void remove(int id) {
		if(!this.menadzeri.containsKey(id)) {
			System.out.println("Prosledjeni id ne postoji.");
			return;
		}

		this.menadzeri.remove(id);
		this.saveData();
	}
}
