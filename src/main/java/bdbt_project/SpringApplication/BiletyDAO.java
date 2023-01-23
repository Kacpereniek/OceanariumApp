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
public class BiletyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BiletyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Bilety> list(){
        String sql = "SELECT id_bilet, (select imie||' '||nazwisko from klienci where id_klienta = BILETY.id_klienta ) id_klienta\n" +
                ",typ_biletu,rodzaj_biletu, nazwa, cena, to_char( data_biletu,'YYYY-MM-DD') data_biletu FROM BILETY order by id_bilet desc";

        List<Bilety> listBilety = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Bilety.class));
        return listBilety;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Bilety bilety) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("bilety").usingColumns("id_klienta", "typ_biletu", "rodzaj_biletu", "nazwa", "cena", "data_biletu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(bilety);
        insertActor.execute(param);
    }

    public Bilety get(int id) {
        Object[] args = {id};
        String sql = "SELECT id_bilet, id_klienta,typ_biletu,rodzaj_biletu, nazwa, cena, to_char( data_biletu,'YYYY-MM-DD') data_biletu FROM BILETY WHERE ID_BILET = " + args[0];
        Bilety bilety = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Bilety.class));
        return bilety;
    }

    public void update(Bilety bilety) {
        String sql = "UPDATE BILETY SET TYP_BILETU=:typ_biletu, RODZAJ_BILETU=:rodzaj_biletu," +
                " NAZWA=:nazwa, CENA=:cena, DATA_BILETU=:data_biletu WHERE ID_BILET=:id_bilet";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(bilety);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "begin DELETE_BILETY(?); end;";

        jdbcTemplate.update(sql, id);


    }
}
