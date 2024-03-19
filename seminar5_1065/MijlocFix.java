import java.util.Date;

public class MijlocFix extends ElementPatrimonial implements Cloneable {
    private Categorie categorie;
    private int durataNormata;

    public MijlocFix() {
    }

    public MijlocFix(long nrInventar) {
        super(nrInventar);
    }

    public MijlocFix(String denumire, long nrInventar, double valoare, Date dataAchizitie,
                     Locatie locatie, Categorie categorie, int durataNormata) throws Exception {
        super(denumire, nrInventar, valoare, dataAchizitie, locatie);
        if (durataNormata<0 || durataNormata>100){
            throw new Exception("Durata normata invalida!");
        }
        this.categorie = categorie;
        this.durataNormata = durataNormata;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public int getDurataNormata() {
        return durataNormata;
    }

    public void setDurataNormata(int durataNormata) throws Exception {
        if (durataNormata<0 || durataNormata>100){
            throw new Exception("Durata normata invalida!");
        }
        this.durataNormata = durataNormata;
    }

    public double uzura(){
        Date dataCurenta = new Date();
        long diferentaMilis = dataCurenta.getTime()-dataAchizitie.getTime();
        int diferentaZile = (int)diferentaMilis/(24*60*60);
        return ((double)diferentaZile)/(durataNormata*365);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MijlocFix clona_superficiala = (MijlocFix) super.clone();
        clona_superficiala.setDataAchizitie((Date) dataAchizitie.clone());
        clona_superficiala.setLocatie((Locatie) locatie.clone());
        return clona_superficiala;
    }

    @Override
    public String toString() {
        return "{" + super.toString()+
                " " + categorie +
                "," + durataNormata +
                "}";
    }
}
