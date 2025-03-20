package manage.entitymanagers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import enumeracije.Pol;
import entity.korisnici.Klijent;

public class KlijentManager {
    private String klijentFile;
    private HashMap<Integer,Klijent> klijenti;
	private int maxId;

	public KlijentManager(String klijentFile) {
        this.klijentFile = klijentFile;
        this.klijenti = new HashMap<Integer,Klijent>();
		this.maxId = 0;
    }

    public HashMap<Integer,Klijent> getKlijenti() {
        return klijenti;
    }
    public void setKlijenti(HashMap<Integer,Klijent> klijenti) {
        this.klijenti = klijenti;
    }
    public String getKlijentFile() {
        return klijentFile;
    }
    public void setKlijentFile(String klijentFile) {
        this.klijentFile = klijentFile;
    }
	public int getMaxId() {
		return maxId;
	}

	// METODE
	public Klijent PronadjiKlijentaPoId(int id) {
		if(!this.klijenti.containsKey(id)) {
			System.out.println("Prosledjeni id ne postoji.");
			return null;
		}

		return this.klijenti.get(id);
	}

    public boolean loadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.klijentFile));
			String linija = null;
			while ((linija = br.readLine()) != null) {
				String[] podaci = linija.split(",");
				int id = Integer.parseInt(podaci[0]);
				if(id > this.maxId) {
					this.maxId = id;
				}
				this.klijenti.put(id, new Klijent(id,podaci[1],podaci[2],Pol.valueOfString(podaci[3]),podaci[4],podaci[5],podaci[6],podaci[7],Double.parseDouble(podaci[8]),Double.parseDouble(podaci[9])));
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
			pw = new PrintWriter(new FileWriter(this.klijentFile, false));
			for (Klijent s : this.klijenti.values()) {
				pw.println(s.toFileString());
			}
			pw.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

    public void add(String ime, String prezime, Pol pol, String telefon, String adresa, String korisnickoIme,
                    String lozinka, double karticaLojalnosti, double potroseniNovac) {
		this.klijenti.put(++this.maxId, new Klijent(this.maxId,ime,prezime,pol,telefon,adresa,korisnickoIme,lozinka,karticaLojalnosti,potroseniNovac));
		this.saveData();
	}

	public void edit(int idKlijenta, String ime, String prezime, Pol pol, String telefon, String adresa, String korisnickoIme,
                     String lozinka, double karticaLojalnosti, double potroseniNovac) {
		Klijent s = this.PronadjiKlijentaPoId(idKlijenta);
		s.setIme(ime);
		s.setPrezime(prezime);
		s.setPol(pol);
        s.setTelefon(telefon);
        s.setAdresa(adresa);
        s.setKorisnickoIme(korisnickoIme);
        s.setLozinka(lozinka);
        s.setKarticaLojalnosti(karticaLojalnosti);
        s.setPotroseniNovac(potroseniNovac);
		this.saveData();
	}

	public void remove(int id) {
		if(!this.klijenti.containsKey(id)) {
			System.out.println("Prosledjeni id ne postoji.");
			return;
		}

		this.klijenti.remove(id);
		this.saveData();
	}
}
