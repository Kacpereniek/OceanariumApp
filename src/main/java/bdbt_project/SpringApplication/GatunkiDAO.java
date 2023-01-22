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
public class GatunkiDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public GatunkiDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Gatunki> list(){
        String sql = "SELECT * FROM GATUNKI order by id_gatunku desc";

        List<Gatunki> listGatunki = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Gatunki.class));
        return listGatunki;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Gatunki gatunki) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("gatunki").usingColumns("typ_gatunku", "nazwa", "rozmnazanie", "pochodzenie", "wystepowanie", "pokarm", "opis");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(gatunki);
        insertActor.execute(param);
    }

    public Gatunki get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM GATUNKI WHERE ID_GATUNKU = " + args[0];
        Gatunki gatunki = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Gatunki.class));

        return gatunki;
    }

    public void update(Gatunki gatunki) {
        String sql = "UPDATE gatunki SET typ_gatunku=:typ_gatunku, nazwa=:nazwa, rozmnazanie=:rozmnazanie, pochodzenie=:pochodzenie, wystepowanie=:wystepowanie, pokarm=:pokarm, opis=:opis WHERE id_gatunku=:id_gatunku";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(gatunki);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM gatunki WHERE id_gatunku = ?";
        jdbcTemplate.update(sql, id);

    }

}
