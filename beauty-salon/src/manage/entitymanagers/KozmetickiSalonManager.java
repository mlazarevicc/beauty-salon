package manage.entitymanagers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import entity.KozmetickiSalon;

public class KozmetickiSalonManager {
	private String kozmetickiSalonFile;
    private HashMap<Integer,KozmetickiSalon> kozmetickiSaloni;
	private int maxId;

	public KozmetickiSalonManager(String kozmetickiSalonFile) {
        this.kozmetickiSalonFile = kozmetickiSalonFile;
        this.kozmetickiSaloni = new HashMap<Integer,KozmetickiSalon>();
		this.maxId = 0;
    }

    public HashMap<Integer,KozmetickiSalon> getKozmetickiSaloni() {
        return kozmetickiSaloni;
    }
	public int getMaxId() {
		return maxId;
	}

	// METODE
	public KozmetickiSalon PronadjiKozmetickiSalonaPoId(int id) {
		if(!this.kozmetickiSaloni.containsKey(id)) {
			System.out.println("Prosledjeni id ne postoji.");
			return null;
		}

		return this.kozmetickiSaloni.get(id);
	}

    public boolean loadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.kozmetickiSalonFile));
			String linija = null;
			while ((linija = br.readLine()) != null) {
				String[] podaci = linija.split(",");
				int id = Integer.parseInt(podaci[0]);
				if(id > this.maxId) {
					this.maxId = id;
				}
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				this.kozmetickiSaloni.put(id, new KozmetickiSalon(id,podaci[1],LocalTime.parse(podaci[2], formatter),LocalTime.parse(podaci[3], formatter)));
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
			pw = new PrintWriter(new FileWriter(this.kozmetickiSalonFile, false));
			for (KozmetickiSalon s : this.kozmetickiSaloni.values()) {
				pw.println(s.toFileString());
			}
			pw.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

    public void add(String naziv, LocalTime pocetnoRadnoVreme, LocalTime krajnjeRadnoVreme) {
		this.kozmetickiSaloni.put(++this.maxId, new KozmetickiSalon(this.maxId,naziv,pocetnoRadnoVreme,krajnjeRadnoVreme));
		this.saveData();
	}

	public void edit(int idKozmetickogSalona, String naziv, LocalTime pocetnoRadnoVreme, LocalTime krajnjeRadnoVreme) {
		KozmetickiSalon s = this.PronadjiKozmetickiSalonaPoId(idKozmetickogSalona);
		s.setNaziv(naziv);
		s.setPocetnoRadnoVreme(pocetnoRadnoVreme);
		s.setKrajnjeRadnoVreme(krajnjeRadnoVreme);
		this.saveData();
	}

	public void remove(int id) {
		if(!this.kozmetickiSaloni.containsKey(id)) {
			System.out.println("Prosledjeni id ne postoji.");
			return;
		}

		this.kozmetickiSaloni.remove(id);
		this.saveData();
	}
}
