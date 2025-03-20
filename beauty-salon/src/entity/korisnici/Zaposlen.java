package entity.korisnici;
import enumeracije.*;


public class Zaposlen extends Korisnik{
    private NivoStrucneSpreme nivoStrucneSpreme;
    private int staz;
    private double bonus, plata;

    Zaposlen() {}

    Zaposlen(int id, String ime, String prezime, Pol pol, String telefon, String adresa,
             String korisnickoIme, String lozinka, NivoStrucneSpreme nivoStrucneSpreme,
             int staz, double bonus, double plata) {

        super(id,ime,prezime,pol,telefon,adresa,korisnickoIme,lozinka);
        this.nivoStrucneSpreme = nivoStrucneSpreme;
        this.staz = staz;
        this.bonus = bonus;
        this.plata = plata;
    }

    Zaposlen(Zaposlen z) {
        super(z.getId(),z.getIme(),z.getPrezime(),z.getPol(),z.getTelefon(),z.getAdresa(),z.getKorisnickoIme(),z.getLozinka());
        this.nivoStrucneSpreme = z.nivoStrucneSpreme;
        this.staz = z.staz;
        this.bonus = z.bonus;
        this.plata = z.plata;
    }

    public NivoStrucneSpreme getNivoStrucneSpreme() {
        return nivoStrucneSpreme;
    }

    public void setNivoStrucneSpreme(NivoStrucneSpreme nivoStrucneSpreme) {
        this.nivoStrucneSpreme = nivoStrucneSpreme;
    }

    public int getStaz() {
        return staz;
    }
    public void setStaz(int staz) {
        this.staz = staz;
    }
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getPlata() {
        return plata;
    }

    public void setPlata(double plata) {
        this.plata = plata;
    }
}
