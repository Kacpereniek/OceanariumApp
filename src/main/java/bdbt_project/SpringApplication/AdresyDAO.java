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
public class AdresyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AdresyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Adresy> list(){
        String sql = "SELECT * FROM ADRESY order by id_adresu desc";

        List<Adresy> listAdresy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
        return listAdresy;
    }

    /* Insert – wstawianie nowego wiersza do bazy */
    public void save(Adresy adresy) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("adresy").usingColumns("kod_pocztowy", "miasto", "ulica", "nr_domu", "nr_lokalu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
        insertActor.execute(param);
    }

    public Adresy get(int id) {
        Object[] args = {id};
        String sql = "SELECT * FROM ADRESY WHERE ID_ADRESU = " + args[0];
        Adresy adresy = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Adresy.class));
        return adresy;
    }

    public void update(Adresy adresy) {
        String sql = "UPDATE adresy SET kod_pocztowy=:kod_pocztowy, miasto=:miasto, ulica=:ulica, nr_domu=:nr_domu, nr_lokalu=:nr_lokalu WHERE id_adresu=:id_adresu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(adresy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);

        template.update(sql, param);
    }

    public void delete(int id) {
        String sql = "DELETE FROM ADRESY WHERE id_adresu = ?";

        jdbcTemplate.update(sql, id);


    }

}
