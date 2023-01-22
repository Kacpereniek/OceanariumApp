package bdbt_project.SpringApplication;

public class Wynagrodzenia {
    private int id_wynagrodzenia;
    private int id_pracownika;
    private String podstawowe;
    private String dodatki;
    private String premia;
    private String data_wyplaty;


    public Wynagrodzenia(int id_wynagrodzenia, int id_pracownika, String podstawowe, String dodatki, String premia, String data_wyplaty) {
        this.id_wynagrodzenia = id_wynagrodzenia;
        this.id_pracownika = id_pracownika;
        this.podstawowe = podstawowe;
        this.dodatki = dodatki;
        this.premia = premia;
        this.data_wyplaty = data_wyplaty;
    }

    public Wynagrodzenia() {

    }

    public int getId_wynagrodzenia() {
        return id_wynagrodzenia;
    }

    public void setId_wynagrodzenia(int id_wynagrodzenia) {
        this.id_wynagrodzenia = id_wynagrodzenia;
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public String getPodstawowe() {
        return podstawowe;
    }

    public void setPodstawowe(String podstawowe) {
        this.podstawowe = podstawowe;
    }

    public String getDodatki() {
        return dodatki;
    }

    public void setDodatki(String dodatki) {
        this.dodatki = dodatki;
    }

    public String getPremia() {
        return premia;
    }

    public void setPremia(String premia) {
        this.premia = premia;
    }

    public String getData_wyplaty() {
        return data_wyplaty;
    }

    public void setData_wyplaty(String data_wyplaty) {
        this.data_wyplaty = data_wyplaty;
    }

    @Override
    public String toString() {
        return "Wynagrodzenia [id_wynagrodzenia=" + id_wynagrodzenia + ", id_pracownika=" + id_pracownika + ", podstawowe=" + podstawowe + ", dodatki=" + dodatki + ", premia=" + premia + ", data_wyplaty=" + data_wyplaty +  "]";
    }

}
