package bdbt_project.SpringApplication;

public class Pracownicy {
    private int id_pracownika;
    private int id_oceanarium;
    private String id_adresu;
    private String id_stanowiska;
    private String imie;
    private String drugie_imie;
    private String nazwisko;
    private String data_urodzenia;
    private String plec;
    private String pesel;
    private String telefon;
    private String email;
    private String data_zatrudnienia;
    private String data_zwolnienia;
    private String wyksztalcenie;


    public Pracownicy(int id_pracownika, int id_oceanarium, String id_adresu, String id_stanowiska, String imie, String drugie_imie, String nazwisko, String data_urodzenia, String plec, String pesel, String telefon, String email, String data_zatrudnienia, String data_zwolnienia, String wyksztalcenie) {
        this.id_pracownika = id_pracownika;
        this.id_oceanarium = id_oceanarium;
        this.id_adresu = id_adresu;
        this.id_stanowiska = id_stanowiska;
        this.imie = imie;
        this.drugie_imie = drugie_imie;
        this.nazwisko = nazwisko;
        this.data_urodzenia = data_urodzenia;
        this.plec = plec;
        this.pesel = pesel;
        this.telefon = telefon;
        this.email = email;
        this.data_zatrudnienia = data_zatrudnienia;
        this.data_zwolnienia = data_zwolnienia;
        this.wyksztalcenie = wyksztalcenie;

    }
    public Pracownicy() {

    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public int getId_oceanarium() { return id_oceanarium; }

    public void setId_oceanarium(int id_oceanarium) {
        this.id_oceanarium = id_oceanarium;
    }

    public String getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(String id_adresu) {
        this.id_adresu = id_adresu;
    }

    public String getId_stanowiska() {
        return id_stanowiska;
    }

    public void setId_stanowiska(String id_stanowiska) {
        this.id_stanowiska = id_stanowiska;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getDrugie_imie() {
        return drugie_imie;
    }

    public void setDrugie_imie(String drugie_imie) {
        this.drugie_imie = drugie_imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getData_zatrudnienia() {
        return data_zatrudnienia;
    }

    public void setData_zatrudnienia(String data_zatrudnienia) {
        this.data_zatrudnienia = data_zatrudnienia;
    }

    public String getData_zwolnienia() {
        return data_zwolnienia;
    }

    public void setData_zwolnienia(String data_zwolnienia) {
        this.data_zwolnienia = data_zwolnienia;
    }

    public String getWyksztalcenie() {
        return wyksztalcenie;
    }

    public void setWyksztalcenie(String wyksztalcenie) {
        this.wyksztalcenie = wyksztalcenie;
    }



    @Override
    public String toString() {
        return "Pracownicy [id_pracownika=" + id_pracownika + ", id_oceanarium=" + id_oceanarium + ", id_adresu=" + id_adresu + ", id_stanowiska=" + id_stanowiska + ", imie=" + imie + ", drugie_imie=" + drugie_imie + ", nazwisko=" + nazwisko + ", data_urodzenia=" + data_urodzenia + ", plec=" + plec + ", pesel=" + pesel + ", telefon=" + telefon + ", email=" + email + ", data_zatrudnienia=" + data_zatrudnienia + ", data_zwolnienia=" + data_zwolnienia + ", wyksztalcenie=" + wyksztalcenie + "]";
    }
}



