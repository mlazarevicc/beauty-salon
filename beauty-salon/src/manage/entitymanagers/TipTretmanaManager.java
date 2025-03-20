package manage.entitymanagers;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.ArrayList;

import entity.tretmani.*;

public class TipTretmanaManager {
    private String tipoviTretmanaFile;
    private HashMap<Integer,TipTretmana> tipoviTretmana;
	private int maxId;
    
    public TipTretmanaManager(String tipoviTretmanaFile) {
        this.tipoviTretmanaFile = tipoviTretmanaFile;
        this.tipoviTretmana = new HashMap<Integer,TipTretmana>();
		this.maxId = 0;
    }

    public HashMap<Integer,TipTretmana> getTipoviTretmana() {
        return tipoviTretmana;
    }
    public void setTipoviTretmana(HashMap<Integer,TipTretmana> tipoviTretmana) {
        this.tipoviTretmana = tipoviTretmana;
    }
    public String getTipTretmanaFile() {
        return tipoviTretmanaFile;
    }
    public void setTipTretmanaFile(String tipoviTretmanaFile) {
        this.tipoviTretmanaFile = tipoviTretmanaFile;
    }

	// METODE
	public TipTretmana PronadjiTipTretmanaPoId(int id) {
		if(!this.tipoviTretmana.containsKey(id)) {
			System.out.println("Prosledjeni id ne postoji.");
			return null;
		}

		return this.tipoviTretmana.get(id);
	}
	
	public TipTretmana PronadjiTipTretmanaPoNazivu(String naziv) {
		for(TipTretmana t : this.tipoviTretmana.values()) {
			if(t.getNaziv().toLowerCase().equals(naziv.toLowerCase())) {
				return t;
			}
		}
		return null;
	}

    public boolean loadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.tipoviTretmanaFile));
			String linija = null;
			while ((linija = br.readLine()) != null) {
				String[] podaci = linija.split(",");
				int id = Integer.parseInt(podaci[0]);
				if(id > this.maxId) {
					this.maxId = id;
				}
				this.tipoviTretmana.put(id,new TipTretmana(id,podaci[1]));
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
			pw = new PrintWriter(new FileWriter(this.tipoviTretmanaFile, false));
			for (TipTretmana s : this.tipoviTretmana.values()) {
				pw.println(s.toFileString());
			}
			pw.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

    public void add(String naziv) {
		this.tipoviTretmana.put(++this.maxId, new TipTretmana(this.maxId,naziv));	
		this.saveData();
	}

	public void edit(int idTipTretmana, String naziv) {
		TipTretmana t = this.PronadjiTipTretmanaPoId(idTipTretmana);
		t.setNaziv(naziv);
		this.saveData();
	}


	public void remove(int id, TretmanManager tretmaniMng, ZakazanTretmanManager zakazaniTretmaniMng) {
		if(!this.tipoviTretmana.containsKey(id)) {
			System.out.println("Prosledjeni id ne postoji.");
			return;
		}
		
		this.tipoviTretmana.remove(id);
		
		
		ArrayList<Integer> tretmaniZaBrisanje = new ArrayList<Integer>();
		
		for(Tretman t : tretmaniMng.getTretmani().values()) {
			if(t.getIdTipaTretmana() == id) {
				
				int idTretmana = t.getIdTretmana();
				tretmaniZaBrisanje.add(idTretmana);
				//tretmaniMng.remove(idTretmana);
				
				ArrayList<Integer> zakazaniTretmaniZaBrisanje = new ArrayList<Integer>();
				for(ZakazanTretman zt : zakazaniTretmaniMng.getZakazanTretmani().values()) {
					if(zt.getIdTretmana() == idTretmana) {
						zakazaniTretmaniZaBrisanje.add(zt.getIdTretmana());
						//zakazaniTretmaniMng.remove(zt.getIdZakazanogTretmana());
					}
				}
				for (Integer idZT : zakazaniTretmaniZaBrisanje) {
					zakazaniTretmaniMng.getZakazanTretmani().remove(idZT);
				}
			}
		}
		
		for (Integer idT : tretmaniZaBrisanje) {
			tretmaniMng.getTretmani().remove(idT);
		}
		
		this.saveData();
	}
}
