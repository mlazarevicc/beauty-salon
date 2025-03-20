package entity.tretmani;


public class TipTretmana {
    private int idTipaTretmana;
    private String naziv;

    TipTretmana() {}

    public TipTretmana(int idTipaTretmana, String naziv) {
        this.naziv = naziv;
        this.idTipaTretmana = idTipaTretmana;
    }

    TipTretmana(TipTretmana t) {
        this.naziv = t.naziv;
        this.idTipaTretmana = t.idTipaTretmana;
    }
    
    public int getIdTipaTretmana() {
        return idTipaTretmana;
    }
    public String getNaziv() {
        return naziv;
    }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return "id = " + idTipaTretmana + ", naziv = " + naziv;
    }
    
    public String toFileString() {
        return idTipaTretmana + "," + naziv;
	}
}