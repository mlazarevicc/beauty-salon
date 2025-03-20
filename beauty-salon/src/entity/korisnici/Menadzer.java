package entity.korisnici;
import enumeracije.*;

public class Menadzer extends Zaposlen {

    Menadzer() {
    }
    public Menadzer(int idMenadzera, String ime, String prezime, Pol pol, String telefon, String adresa,
                    String korisnickoIme, String lozinka, NivoStrucneSpreme nivoStrucneSpreme,
                    int staz, double plata, double bonus) {
        super(idMenadzera,ime,prezime,pol,telefon,adresa,korisnickoIme,lozinka,nivoStrucneSpreme,staz,plata,bonus);
    }

    Menadzer(Menadzer m) {
        super(m);
    }

    @Override
    public String toString() {
        return "id = " + this.getId() + ", ime = " + this.getIme() + ", prezime = " + this.getPrezime() + ", pol = " + this.getPol() +
               ", telefon = " + this.getTelefon() + ", adresa = " + this.getAdresa() + ", korisnicko_ime = " + this.getKorisnickoIme() + ", lozinka = " + this.getLozinka() + 
               ", nivo_strucne_spreme = " + this.getNivoStrucneSpreme() + ", staz = " + this.getStaz() + ", plata = " + this.getPlata() + 
               ", bonus = " + this.getBonus();
    }
    
    public String toFileString() {
        return this.getId() + "," + this.getIme() + "," + this.getPrezime() + "," + this.getPol() + "," + this.getTelefon() + "," + this.getAdresa()
        	   + "," + this.getKorisnickoIme() + "," + this.getLozinka() + "," + this.getNivoStrucneSpreme() + "," + this.getStaz() +
                 "," + this.getPlata() + "," + this.getBonus();
	}
    
}
