package manage.entitymanagers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import enumeracije.*;
import entity.korisnici.Kozmeticar;

public class KozmeticarManager {
    private String kozmeticarFile;
    private HashMap<Integer,Kozmeticar> kozmeticari;
	private int maxId;

	public KozmeticarManager(String kozmeticarFile) {
        this.kozmeticarFile = kozmeticarFile;
        this.kozmeticari = new HashMap<Integer,Kozmeticar>();
		this.maxId = 0;
    }

    public HashMap<Integer,Kozmeticar> getKozmeticari() {
        return kozmeticari;
    }
    public void setKozmeticari(HashMap<Integer,Kozmeticar> kozmeticari) {
        this.kozmeticari = kozmeticari;
    }
    public String getKlijentFile() {
        return kozmeticarFile;
    }
    public void setKlijentFile(String kozmeticarFile) {
        this.kozmeticarFile = kozmeticarFile;
    }
	public int getMaxId() {
		return maxId;
	}

	// METODE
	public Kozmeticar PronadjiKozmeticaraPoId(int id) {
		if(!this.kozmeticari.containsKey(id)) {
			System.out.println("Prosledjeni id ne postoji.");
			return null;
		}

		return this.kozmeticari.get(id);
	}

    public boolean loadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.kozmeticarFile));
			String linija = null;
			while ((linija = br.readLine()) != null) {
				String[] podaci = linija.split(",");
				int id = Integer.parseInt(podaci[0]);
				if(id > this.maxId) {
					this.maxId = id;
				}
				Kozmeticar k = new Kozmeticar(id,podaci[1],podaci[2],Pol.valueOfString(podaci[3]),podaci[4],podaci[5],podaci[6],podaci[7],
                                     NivoStrucneSpreme.valueOfString(podaci[8]),Integer.parseInt(podaci[9]),Double.parseDouble(podaci[10]),Double.parseDouble(podaci[11]));
                if(podaci.length > 12) {
                    for(String tretmanId : podaci[12].split(";")) {
                        k.getTipoviTretmana().add(Integer.parseInt(tretmanId));
                    }
                }
                this.kozmeticari.put(id,k);
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
			pw = new PrintWriter(new FileWriter(this.kozmeticarFile, false));
			for (Kozmeticar s : this.kozmeticari.values()) {
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
		this.kozmeticari.put(++this.maxId, new Kozmeticar(this.maxId,ime,prezime,pol,telefon,adresa,korisnickoIme,lozinka,nivoStrucneSpreme,staz,plata,bonus));
		this.saveData();
	}

    public void edit(int idKozmeticara, String ime, String prezime, Pol pol, String telefon, String adresa,
                     String korisnickoIme, String lozinka, NivoStrucneSpreme nivoStrucneSpreme,
                     int staz, double plata, double bonus, ArrayList<Integer> tipoviTretmana) {
		Kozmeticar s = this.PronadjiKozmeticaraPoId(idKozmeticara);
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
        s.setTipoviTretmana(tipoviTretmana);
		this.saveData();
	}

	public void remove(int id) {
		if(!this.kozmeticari.containsKey(id)) {
			System.out.println("Prosledjeni id ne postoji.");
			return;
		}

		this.kozmeticari.remove(id);
		this.saveData();
	}
}
