import java.util.Date;

public class ObiectInventar extends ElementPatrimonial{
    private String gestionar;

    public ObiectInventar() {
    }

    public ObiectInventar(long nrInventar) {
        super(nrInventar);
    }

    public ObiectInventar(String denumire, long nrInventar, double valoare, Date dataAchizitie,
                          Locatie locatie, String gestionar) {
        super(denumire, nrInventar, valoare, dataAchizitie, locatie);
        this.gestionar = gestionar;
    }

    public String getGestionar() {
        return gestionar;
    }

    public double uzura(){
        Date dataCurenta = new Date();
        long diferentaMilis = dataCurenta.getTime()-dataAchizitie.getTime();
        int diferentaZile = (int)diferentaMilis/(24*60*60);
        return diferentaZile > 365 ? 1:diferentaZile/365.0;
    }

    public void setGestionar(String gestionar) {
        this.gestionar = gestionar;
    }

    @Override
    public String toString() {
        return "{" + super.toString()+
                " " + gestionar + "} ";
    }
}
