package bdbt_project.SpringApplication;

public class Gatunki {
    private int id_gatunku;
    private String typ_gatunku;
    private String nazwa;
    private String rozmnazanie;
    private String pochodzenie;
    private String wystepowanie;
    private String pokarm;
    private String opis;


    public Gatunki(int id_gatunku, String typ_gatunku, String nazwa, String rozmnazanie, String pochodzenie, String wystepowanie, String pokarm, String opis) {
        this.id_gatunku = id_gatunku;
        this.typ_gatunku = typ_gatunku;
        this.nazwa = nazwa;
        this.rozmnazanie = rozmnazanie;
        this.pochodzenie = pochodzenie;
        this.wystepowanie = wystepowanie;
        this.pokarm = pokarm;
        this.opis = opis;
    }

    public Gatunki() {

    }

    public int getId_gatunku() {
        return id_gatunku;
    }

    public void setId_gatunku(int id_gatunku) {
        this.id_gatunku = id_gatunku;
    }

    public String getTyp_gatunku() {
        return typ_gatunku;
    }

    public void setTyp_gatunku(String typ_gatunku) {
        this.typ_gatunku = typ_gatunku;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getRozmnazanie() {
        return rozmnazanie;
    }

    public void setRozmnazanie(String rozmnazanie) {
        this.rozmnazanie = rozmnazanie;
    }

    public String getPochodzenie() {
        return pochodzenie;
    }

    public void setPochodzenie(String pochodzenie) {
        this.pochodzenie = pochodzenie;
    }

    public String getWystepowanie() {
        return wystepowanie;
    }

    public void setWystepowanie(String wystepowanie) {
        this.wystepowanie = wystepowanie;
    }

    public String getPokarm() {
        return pokarm;
    }

    public void setPokarm(String pokarm) {
        this.pokarm = pokarm;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    @Override
    public String toString() {
        return "Gatunki [id_gatunku=" + id_gatunku + ", typ_gatunku=" + typ_gatunku + ", nazwa=" + nazwa + ", rozmnazanie=" + rozmnazanie + ", pochodzenie=" + pochodzenie + ", wystepowanie=" + wystepowanie + ", pokarm=" + pokarm + ", opis=" + opis + "]";
    }
}

