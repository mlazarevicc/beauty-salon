package entity.korisnici;
import enumeracije.*;

public class Recepcioner extends Zaposlen{
    
    Recepcioner() {
    }
    public Recepcioner(int idRecepcionera, String ime, String prezime, Pol pol, String telefon, String adresa,
             String korisnickoIme, String lozinka, NivoStrucneSpreme nivoStrucneSpreme,
             int staz, double plata, double bonus) {

        super(idRecepcionera,ime,prezime,pol,telefon,adresa,korisnickoIme,lozinka,nivoStrucneSpreme,staz,plata,bonus);
    }

    Recepcioner(Recepcioner k) {
        super(k);
    }

    @Override
    public String toString() {
        return "id = " + this.getId() + ", ime = " + this.getIme() + ", prezime = " + this.getPrezime() + ", pol = " + this.getPol() +
               ", telefon = " + this.getTelefon() + ", adresa = " + this.getAdresa() + ", korisnicko_ime = " + this.getKorisnickoIme() + ", lozinka = " + this.getLozinka() +
               ", nivo_strucne_spreme = " + this.getNivoStrucneSpreme() + ", staz = " + this.getStaz() + ", plata = " + this.getPlata() + 
               ", bonus = " + this.getBonus();
    }
    
    public String toFileString() {
        return this.getId() + "," + this.getIme() + "," + this.getPrezime() + "," + this.getPol() + "," + this.getTelefon() + "," +
        	   this.getAdresa() + "," + this.getKorisnickoIme() + "," + this.getLozinka() + "," + this.getNivoStrucneSpreme() + ","
        	   + this.getStaz() + "," + this.getBonus() + "," + this.getPlata();
	}
}