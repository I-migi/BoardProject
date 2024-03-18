package Personal.CRUDprojectH2.domain.board;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardMapper implements RowMapper<Board> {

    @Override
    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
        Board board = new Board();
        board.setId(rs.getLong("id"));
        board.setTitle(rs.getString("title"));
        board.setWriter(rs.getString("writer"));
        board.setContent(rs.getString("content"));
        board.setCreatedDate(rs.getTimestamp("created_date").toLocalDateTime());
        board.setViewCount(rs.getInt("view_count"));
        return board;
    }

}
