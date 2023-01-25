package bdbt_project.SpringApplication;

public class Bilety {
    private int id_bilet;
    private String id_klienta;
    private String typ_biletu;
    private String rodzaj_biletu;
    private String nazwa;
    private String cena;
    private String data_biletu;




    public Bilety(int id_bilet, String id_klienta, String typ_biletu, String rodzaj_biletu, String nazwa, String cena, String data_biletu) {
        this.id_bilet = id_bilet;
        this.id_klienta = id_klienta;
        this.typ_biletu = typ_biletu;
        this.rodzaj_biletu = rodzaj_biletu;
        this.nazwa = nazwa;
        this.cena = cena;
        this.data_biletu = data_biletu;

    }

    public Bilety() {

    }

    public int getId_bilet() {
        return id_bilet;
    }

    public void setId_bilet(int id_bilet) {
        this.id_bilet = id_bilet;
    }

    public String getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(String id_klienta) {
        this.id_klienta = id_klienta;
    }

    public String getTyp_biletu() {
        return typ_biletu;
    }

    public void setTyp_biletu(String typ_biletu) {
        this.typ_biletu = typ_biletu;
    }

    public String getRodzaj_biletu() {
        return rodzaj_biletu;
    }

    public void setRodzaj_biletu(String rodzaj_biletu) {
        this.rodzaj_biletu = rodzaj_biletu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getData_biletu() {
        return data_biletu;
    }

    public void setData_biletu(String data_biletu) {
        this.data_biletu = data_biletu;
    }

    @Override
    public String toString() {
        return "Bilety [id_bilet=" + id_bilet + ", id_klienta=" + id_klienta + ", typ_biletu=" + typ_biletu + ", rodzaj_biletu=" + rodzaj_biletu + ", nazwa=" + nazwa + ", cena=" + cena + ", data_biletu=" + data_biletu + "]";
    }

}
