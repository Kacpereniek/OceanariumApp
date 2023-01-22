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
public class WynagrodzeniaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public WynagrodzeniaDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Wynagrodzenia> list(){
        String sql = "SELECT * FROM WYNAGRODZENIA";

        List<Wynagrodzenia> listWynagrodzenia = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Wynagrodzenia.class));
        return listWynagrodzenia;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Wynagrodzenia wynagrodzenia) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("wynagrodzenia").usingColumns("id_pracownika", "podstawowe", "dodatki", "premia", "data_wyplaty");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wynagrodzenia);
        insertActor.execute(param);
    }

    public Wynagrodzenia get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM OKAZY WHERE ID_OKAZU = " + args[0];
        Wynagrodzenia wynagrodzenia = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Wynagrodzenia.class));
        return wynagrodzenia;
    }

    public void update(Wynagrodzenia wynagrodzenia) {
        String sql = "UPDATE wynagrodzenia SET id_pracownika=:id_pracownika, podstawowe=:podstawowe, dodatki=:dodatki, premia=:premia, data_wyplaty=:data_wyplaty";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(wynagrodzenia);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM OKAZY WHERE ID_OKAZU = ?";

        jdbcTemplate.update(sql, id);


    }
}
