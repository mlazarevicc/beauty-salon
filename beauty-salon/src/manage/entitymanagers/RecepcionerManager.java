package manage.entitymanagers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import enumeracije.*;
import entity.korisnici.Recepcioner;

public class RecepcionerManager {
    private String recepcionerFile;
    private HashMap<Integer,Recepcioner> recepcioneri;
	private int maxId;

	public RecepcionerManager(String recepcionerFile) {
        this.recepcionerFile = recepcionerFile;
        this.recepcioneri = new HashMap<Integer,Recepcioner>();
    }
    public HashMap<Integer,Recepcioner> getRecepcioneri() {
        return recepcioneri;
	}
    public void setRecepcioneri(HashMap<Integer,Recepcioner> recepcioneri) {
        this.recepcioneri = recepcioneri;
    }
    public String getRecepcionerFile() {
        return recepcionerFile;
    }
    public void setRecepcionerFile(String recepcionerFile) {
        this.recepcionerFile = recepcionerFile;
    }
	public int getMaxId() {
		return maxId;
	}

	// METODE
	public Recepcioner PronadjiRecepcioneraPoId(int id) {
		if(!this.recepcioneri.containsKey(id)) {
			System.out.println("Prosledjeni id ne postoji.");
			return null;
		}

		return this.recepcioneri.get(id);
	}

    public boolean loadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.recepcionerFile));
			String linija = null;
			while ((linija = br.readLine()) != null) {
				String[] podaci = linija.split(",");
				int id = Integer.parseInt(podaci[0]);
				if(id > this.maxId) {
					this.maxId = id;
				}
				this.recepcioneri.put(id,new Recepcioner(id,podaci[1],podaci[2],Pol.valueOfString(podaci[3]),podaci[4],podaci[5],podaci[6],
                         podaci[7],NivoStrucneSpreme.valueOfString(podaci[8]),Integer.parseInt(podaci[9]),Double.parseDouble(podaci[10]),Double.parseDouble(podaci[11])));
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
			pw = new PrintWriter(new FileWriter(this.recepcionerFile, false));
			for (Recepcioner s : this.recepcioneri.values()) {
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
		this.recepcioneri.put(++this.maxId, new Recepcioner(this.maxId,ime,prezime,pol,telefon,adresa,korisnickoIme,lozinka,nivoStrucneSpreme,staz,plata,bonus));
		this.saveData();
	}


	public void edit(int idRecepcionera, String ime, String prezime, Pol pol, String telefon, String adresa,
                     String korisnickoIme, String lozinka, NivoStrucneSpreme nivoStrucneSpreme,
                     int staz, double plata, double bonus) {
		Recepcioner s = this.PronadjiRecepcioneraPoId(idRecepcionera);
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
		if(!this.recepcioneri.containsKey(id)) {
			System.out.println("Prosledjeni id ne postoji.");
			return;
		}

		this.recepcioneri.remove(id);
		this.saveData();
	}
}
