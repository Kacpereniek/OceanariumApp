package bdbt_project.SpringApplication;

public class Okazy {
    private int id_okazu;
    private String id_zbiornika;
    private String id_gatunku;
    private String typ_okazu;
    private String nazwa;
    private int liczebnosc;
    private String opis;




    public Okazy(int id_okazu, String id_zbiornika, String id_gatunku, String typ_okazu, String nazwa, int liczebnosc, String opis) {
        this.id_okazu = id_okazu;
        this.id_zbiornika = id_zbiornika;
        this.id_gatunku = id_gatunku;
        this.typ_okazu = typ_okazu;
        this.nazwa = nazwa;
        this.liczebnosc = liczebnosc;
        this.opis = opis;

    }

    public Okazy() {

    }

    public int getId_okazu() {
        return id_okazu;
    }

    public void setId_okazu(int id_okazu) {
        this.id_okazu = id_okazu;
    }

    public String getId_zbiornika() {
        return id_zbiornika;
    }

    public void setId_zbiornika(String id_zbiornika) {
        this.id_zbiornika = id_zbiornika;
    }

    public String getId_gatunku() {
        return id_gatunku;
    }

    public void setId_gatunku(String id_gatunku) {
        this.id_gatunku = id_gatunku;
    }

    public String getTyp_okazu() {
        return typ_okazu;
    }

    public void setTyp_okazu(String typ_okazu) {
        this.typ_okazu = typ_okazu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getLiczebnosc() {
        return liczebnosc;
    }

    public void setLiczebnosc(int liczebnosc) {
        this.liczebnosc = liczebnosc;
    }
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    @Override
    public String toString() {
        return "Okazy [id_okazu=" + id_okazu + ", id_zbiornika=" + id_zbiornika + ", id_gatunku=" + id_gatunku + ", typ_okazu=" + typ_okazu + ", nazwa=" + nazwa + ", liczebnosc=" + liczebnosc + ", opis=" + opis + "]";
    }
}

