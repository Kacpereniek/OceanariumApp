package bdbt_project.SpringApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import  org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PracownicyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Pracownicy> list(){
        String sql = "SELECT id_pracownika, id_oceanarium, fadres(id_adresu) id_adresu, \n" +
                "(select nazwa_stanowiska from stanowiska where id_stanowiska =pracownicy.id_stanowiska )id_stanowiska, imie, nazwisko, to_char(data_urodzenia,'YYYY-MM-DD') data_urodzenia, \n" +
                "decode(plec,'M','mężczyzna','K', 'kobieta') plec,\n" +
                "pesel, telefon, email, to_char(data_zatrudnienia,'YYYY-MM-DD') data_zatrudnienia, to_char(data_zwolnienia,'YYYY-MM-DD') data_zwolnienia,\n" +
                "wyksztalcenie FROM PRACOWNICY";

        List<Pracownicy> listPracownicy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return listPracownicy;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Pracownicy pracownicy) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pracownicy").usingColumns("id_oceanarium", "id_adresu", "id_stanowiska", "imie", "drugie_imie", "nazwisko",
                "data_urodzenia", "plec", "pesel", "telefon", "email", "data_zatrudnienia", "data_zwolnienia", "wyksztalcenie");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        insertActor.execute(param);
    }
    public Pracownicy get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM PRACOWNICY WHERE ID_PRACOWNIKA = " + args[0];
        Pracownicy pracownicy = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));

        return pracownicy;
    }

    public void update(Pracownicy pracownicy) {
        String sql = "UPDATE PRACOWNICY SET id_oceanarium=:id_oceanarium, id_adresu=:id_adresu, id_stanowiska=:id_stanowiska, imie=:imie, drugie_imie=:drugie_imie, nazwisko=:nazwisko, data_urodzenia=:data_urodzenia, plec=:plec, pesel=:pesel, telefon=:telefon, email=:email, data_zatrudnienia=:data_zatrudnienia, data_zwolnienia=:data_zwolnienia, wyksztalcenie=:wyksztalcenie WHERE id_pracownika=:id_pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "begin DELETE_PRACOWNIK(?); end;";
        jdbcTemplate.update(sql, id);


    }




}
