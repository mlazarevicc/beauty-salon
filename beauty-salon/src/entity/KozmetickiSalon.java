package entity;

import java.time.LocalTime;

public class KozmetickiSalon {
	private int id;
	private String naziv;
	private LocalTime pocetnoRadnoVreme, krajnjeRadnoVreme;
	
	public KozmetickiSalon() {};
	
	public KozmetickiSalon(int idKozmetickogSalona, String naziv, LocalTime pocetnoRadnoVreme, LocalTime krajnjeRadnoVreme) {
		super();
		this.id = idKozmetickogSalona;
		this.naziv = naziv;
		this.pocetnoRadnoVreme = pocetnoRadnoVreme;
		this.krajnjeRadnoVreme = krajnjeRadnoVreme;
	}
	
	
	public int getId() {
		return id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public LocalTime getPocetnoRadnoVreme() {
		return pocetnoRadnoVreme;
	}
	public void setPocetnoRadnoVreme(LocalTime pocetnoRadnoVreme) {
		this.pocetnoRadnoVreme = pocetnoRadnoVreme;
	}
	public LocalTime getKrajnjeRadnoVreme() {
		return krajnjeRadnoVreme;
	}
	public void setKrajnjeRadnoVreme(LocalTime krajnjeRadnoVreme) {
		this.krajnjeRadnoVreme = krajnjeRadnoVreme;
	}
	
	@Override
	public String toString() {
		return "id = " + id + ", naziv = " + naziv + ", pocetnoRadnoVreme = " + pocetnoRadnoVreme + ", krajnjeRadnoVreme = " + krajnjeRadnoVreme;
	}
	public String toFileString() {
		return id + "," + naziv + "," + pocetnoRadnoVreme + "," + krajnjeRadnoVreme;
	}
}
