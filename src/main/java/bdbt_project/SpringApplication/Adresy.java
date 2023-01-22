package bdbt_project.SpringApplication;

public class Adresy {
    private String id_adresu;
    private String kod_pocztowy;
    private String miasto;
    private String ulica;
    private String nr_domu;
    private String nr_lokalu;


    public Adresy(String id_adresu, String kod_pocztowy, String miasto, String ulica, String nr_domu, String nr_lokalu) {
        this.id_adresu = id_adresu;
        this.kod_pocztowy = kod_pocztowy;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nr_domu = nr_domu;
        this.nr_lokalu = nr_lokalu;
    }

    public Adresy(){

    }

    public String getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(String id_adresu) {
        this.id_adresu = id_adresu;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNr_domu() {
        return nr_domu;
    }

    public void setNr_domu(String nr_domu) {
        this.nr_domu = nr_domu;
    }

    public String getNr_lokalu() {
        return nr_lokalu;
    }

    public void setNr_lokalu(String nr_lokalu) {
        this.nr_lokalu = nr_lokalu;
    }

    @Override
    public String toString() {
        return "Adresy [id_adresu=" + id_adresu + ", kod_pocztowy=" + kod_pocztowy + ", miasto=" + miasto +", ulica=" + ulica + ", nr_domu=" + nr_domu +", nr_lokalu=" + nr_lokalu + "]";
    }

}
