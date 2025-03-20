package entity.tretmani;
import java.time.LocalDateTime;

import utils.AppSettings;
import enumeracije.StanjeTretmana;

public class ZakazanTretman {
    private int idZakazanogTretmana, idKozmeticara, idKlijenta, idTretmana;
    private LocalDateTime termin;
    private StanjeTretmana stanje;
    private double cena;

    public ZakazanTretman() {
    }

    public ZakazanTretman(int idZakazanogTretmana, int idKozmeticara, int idKlijenta, int idTretmana,
            			  LocalDateTime termin, StanjeTretmana stanje, double cena) {
        this.idZakazanogTretmana = idZakazanogTretmana;
        this.idKozmeticara = idKozmeticara;
        this.idKlijenta = idKlijenta;
        this.idTretmana = idTretmana;
        this.termin = termin;
        this.stanje = stanje;
        this.cena = cena;
    }
    public ZakazanTretman(int idKozmeticara, int idKlijenta, int idTretmana,
			  LocalDateTime termin, StanjeTretmana stanje, double cena) {
		this.idKozmeticara = idKozmeticara;
		this.idKlijenta = idKlijenta;
		this.idTretmana = idTretmana;
		this.termin = termin;
		this.stanje = stanje;
		this.cena = cena;
    }

    public int getIdZakazanogTretmana() {
        return idZakazanogTretmana;
    }
    public void setIdZakazanogTretmana(int idZakazanogTretmana) {
        this.idZakazanogTretmana = idZakazanogTretmana;
    }
    public int getIdKozmeticara() {
        return idKozmeticara;
    }
    public void setIdKozmeticara(int idKozmeticara) {
        this.idKozmeticara = idKozmeticara;
    }
    public int getIdKlijenta() {
        return idKlijenta;
    }
    public void setIdKlijenta(int idKlijenta) {
        this.idKlijenta = idKlijenta;
    }
    public int getIdTretmana() {
        return idTretmana;
    }
    public void setIdTretmana(int idTretmana) {
        this.idTretmana = idTretmana;
    }
    public LocalDateTime getTermin() {
        return termin;
    }
    public void setTermin(LocalDateTime termin) {
        this.termin = termin;
    }
    public StanjeTretmana getStanje() {
        return stanje;
    }
    public void setStanje(StanjeTretmana stanje) {
        this.stanje = stanje;
    }
    public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}

    @Override
    public String toString() {
        return "id = " + idZakazanogTretmana + ", id_kozmeticara = " + idKozmeticara + ", id_klijenta" + idKlijenta + ", id_tipa_tretmana = " + idTretmana +
        	   ", termin = " + AppSettings.formatDate(termin,"yyyy-MM-dd HH:mm:ss") + ", stanje = " + stanje + ", cena = " + cena;
    }
    
    public String toFileString() {
        return idZakazanogTretmana + "," + idKozmeticara + "," + idKlijenta + "," + idTretmana + "," + AppSettings.formatDate(termin,"yyyy-MM-dd HH:mm:ss") +
        	   "," + stanje + "," + cena;
	}

}
