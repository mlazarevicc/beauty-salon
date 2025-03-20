package entity.korisnici;
import enumeracije.*;

public abstract class Korisnik {
    private int id;
    private String ime, prezime, telefon, adresa, korisnickoIme, lozinka;
    private Pol pol;

    Korisnik() {}

    Korisnik(int id, String ime, String prezime, Pol pol, String telefon, String adresa,
             String korisnickoIme, String lozinka) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.telefon = telefon;
        this.adresa = adresa;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    Korisnik(Korisnik k) {
        this.id = k.id;
        this.ime = k.ime;
        this.prezime = k.prezime;
        this.pol = k.pol;
        this.telefon = k.telefon;
        this.adresa = k.adresa;
        this.korisnickoIme = k.korisnickoIme;
        this.lozinka = k.lozinka;
    }
    
    public int getId() {
        return id;
    }
    public String getIme() {
        return this.ime;
    }
    public void setIme(String ime) {
        this.ime=ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

}
