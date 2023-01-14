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
public class OkazyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OkazyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Okazy> list(){
        String sql = "SELECT * FROM OKAZY";

        List<Okazy> listOkazy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Okazy.class));
        return listOkazy;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Okazy okazy) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("okazy").usingColumns("id_zbiornika", "id_gatunku", "typ_okazu", "nazwa", "liczebnosc", "opis");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(okazy);
        insertActor.execute(param);
    }

    public Okazy get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM OKAZY WHERE ID_OKAZU = " + args[0];
        Okazy okazy = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Okazy.class));

        return okazy;
    }

    public void update(Okazy okazy) {
        String sql = "UPDATE OKAZY SET ID_ZBIORNIKA=:id_zbiornika, ID_GATUNKU=:id_gatunku, TYP_OKAZU=:typ_okazu, NAZWA=:nazwa, LICZEBNOSC=:liczebnosc, OPIS=:opis WHERE ID_OKAZU=:id_okazu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(okazy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM OKAZY WHERE ID_OKAZU = ?";
        jdbcTemplate.update(sql, id);

    }

}
