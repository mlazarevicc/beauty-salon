package entity.tretmani;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Tretman {
    private int idTipaTretmana, idTretmana;
    private String nazivTretmana;
    private LocalTime trajanje;
    private double cena;

    public Tretman() {
    }

    public Tretman(int idTretmana, int idTipaTretmana, String nazivTretmana, LocalTime trajanje, double cena) {
        this.idTipaTretmana = idTipaTretmana;
        this.idTretmana = idTretmana;
        this.nazivTretmana = nazivTretmana;
        this.trajanje = trajanje;
        this.cena = cena;
    }

    public String getNazivTretmana() {
        return nazivTretmana;
    }
    public void setNazivTretmana(String nazivTretmana) {
        this.nazivTretmana = nazivTretmana;
    }
    public int getIdTipaTretmana() {
        return idTipaTretmana;
    }
    public void setIdTipaTretmana(int idTipaTretmana) {
        this.idTipaTretmana = idTipaTretmana;
    }
    public int getIdTretmana() {
        return idTretmana;
    }
    public LocalTime getTrajanje() {
		return trajanje;
	}
	public void setTrajanje(LocalTime trajanje) {
		this.trajanje = trajanje;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}

	@Override
    public String toString() {
        return "id = " + idTretmana + ", id_tipa_tretmana = " + idTipaTretmana + ", naziv = " + nazivTretmana + ", vreme_trajanja = " +
        		trajanje.format(DateTimeFormatter.ofPattern("HH:mm")) + ", cena = " + cena;
    }
    
    public String toFileString() {
        return idTretmana + "," + idTipaTretmana + "," + nazivTretmana + "," + trajanje.format(DateTimeFormatter.ofPattern("HH:mm")) + "," + cena;
	}
}
