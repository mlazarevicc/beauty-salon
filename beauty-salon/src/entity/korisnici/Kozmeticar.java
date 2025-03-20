package entity.korisnici;
import java.util.ArrayList;

import enumeracije.*;

public class Kozmeticar extends Zaposlen {

    private ArrayList<Integer> tipoviTretmana;

    public Kozmeticar() { 
        this.tipoviTretmana = new ArrayList<Integer>(); 
    }
    public Kozmeticar(int idKozmeticara, String ime, String prezime, Pol pol, String telefon, String adresa,
               String korisnickoIme, String lozinka, NivoStrucneSpreme nivoStrucneSpreme,
               int staz, double plata, double bonus) {

        super(idKozmeticara,ime,prezime,pol,telefon,adresa,korisnickoIme,lozinka,nivoStrucneSpreme,staz,bonus,plata);
        this.tipoviTretmana = new ArrayList<Integer>();
    }
    public Kozmeticar(int idKozmeticara, String ime, String prezime, Pol pol, String telefon, String adresa,
               String korisnickoIme, String lozinka, NivoStrucneSpreme nivoStrucneSpreme,
               int staz, double plata, double bonus, ArrayList<Integer> tipoviTretmana) {

        super(idKozmeticara,ime,prezime,pol,telefon,adresa,korisnickoIme,lozinka,nivoStrucneSpreme,staz,bonus,plata);
        this.tipoviTretmana = tipoviTretmana;
    }

    Kozmeticar(Kozmeticar k) {
        super(k);
        this.tipoviTretmana = k.tipoviTretmana;
    }

    public ArrayList<Integer> getTipoviTretmana() {
        return tipoviTretmana;
    }
    public void setTipoviTretmana(ArrayList<Integer> tipoviTretmana) {
        this.tipoviTretmana = tipoviTretmana;
    }

    private String TretmaniToString() {
        String tretmaniString = "";
		if (this.tipoviTretmana != null && this.tipoviTretmana.size()>0) {
			for (Integer t : this.tipoviTretmana) {
				tretmaniString += t + ";";
			}
			tretmaniString = tretmaniString.substring(0, tretmaniString.length()-1);
		}

        return tretmaniString;
    }

    @Override
    public String toString() {
        return "id = " + this.getId() + ", ime = " + this.getIme() + ", prezime = " + this.getPrezime() + ", pol = " + this.getPol() +
               ", telefon = " + this.getTelefon() + ", adresa = " + this.getAdresa() + ", korisnicko_ime = " + this.getKorisnickoIme() + ", lozinka = " + this.getLozinka() +
               ", nivo_strucne_spreme = " + this.getNivoStrucneSpreme() + ", staz = " + this.getStaz() + ", plata = " + this.getPlata() +
               ", bonus = " + this.getBonus() + ", tipoviTretmana = " + TretmaniToString();
    }
    
    public String toFileString() {
        return this.getId() + "," + this.getIme() + "," + this.getPrezime() + "," + this.getPol() + "," + this.getTelefon() + "," + this.getAdresa() + "," +
               this.getKorisnickoIme() + "," + this.getLozinka() + "," + this.getNivoStrucneSpreme() + "," + this.getStaz() +
               "," + this.getBonus() + "," + this.getPlata() + "," + TretmaniToString();
	}
}
