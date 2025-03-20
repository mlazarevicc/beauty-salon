package entity.korisnici;
import enumeracije.*;


public class Klijent extends Korisnik{
    private double potroseniNovac, karticaLojalnosti;

    public Klijent() {}
    public Klijent(int idKlijenta, String ime, String prezime, Pol pol, String telefon, String adresa, String korisnickoIme,
                   String lozinka, double karticaLojalnosti, double potroseniNovac) {
        super(idKlijenta,ime,prezime,pol,telefon,adresa,korisnickoIme,lozinka);
        this.karticaLojalnosti = karticaLojalnosti;
        this.potroseniNovac = potroseniNovac;
    }

    public double getKarticaLojalnosti() {
        return karticaLojalnosti;
    }
    public void setKarticaLojalnosti(double karticaLojalnosti) {
        this.karticaLojalnosti = karticaLojalnosti;
    }
    public double getPotroseniNovac() {
        return potroseniNovac;
    }
    public void setPotroseniNovac(double potroseniNovac) {
        this.potroseniNovac = potroseniNovac;
    }

    @Override
    public String toString() {
        return "id = " + this.getId() + ", ime = " + this.getIme() + ", prezime = " + this.getPrezime() + ", pol = " + this.getPol() +
               ", telefon = " + this.getTelefon() + ", adresa = " + this.getAdresa() + ", korisnicko_ime = " + this.getKorisnickoIme() + ", lozinka = " + this.getLozinka() + 
               ", kartica_lojalnosti = " + karticaLojalnosti + ", potroseni_novac = " + potroseniNovac;
    }
    
    public String toFileString() {
        return this.getId() + "," + this.getIme() + "," + this.getPrezime()+ "," + this.getPol() + "," + this.getTelefon() + "," +
               this.getAdresa() + "," + this.getKorisnickoIme() + "," + this.getLozinka() + "," + karticaLojalnosti + "," + potroseniNovac;
	}
}

