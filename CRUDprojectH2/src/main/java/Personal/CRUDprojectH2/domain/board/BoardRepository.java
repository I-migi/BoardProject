package Personal.CRUDprojectH2.domain.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

import static java.sql.DriverManager.getConnection;

@Repository
public class BoardRepository {

//    private static final Map<Long, Board> store = new HashMap<>();
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BoardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Board registerBoard(Board board){
        String sql ="INSERT INTO board (title, writer, content, created_date,view_count) VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, board.getTitle(), board.getWriter(), board.getContent(), LocalDateTime.now(), 0);
        return board;
    }

    public Board findById(Long id){
        String sql = "SELECT * FROM board WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BoardMapper());
    }

    public void deleteBoard(Long id){
        String sql = "DELETE FROM board WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
    public List<Board> findAll(){
        String sql = "SELECT * FROM board";
        return jdbcTemplate.query(sql, new BoardMapper());

    }

    public void updateBoard(Long id,Board updateParam){
        String sql = "UPDATE board SET title = ?, writer = ?, content = ? WHERE id = ?";
        jdbcTemplate.update(sql, updateParam.getTitle(), updateParam.getWriter(), updateParam.getContent(), id);
    }
}
