package board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import board.dto.BoardDBBean;
import board.ibatis.BoardMapper;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public List boardList() {
		return BoardMapper.listBoard();
	}
	@Override
	public BoardDBBean getContent(int num, String mode){
		return BoardMapper.getBoard(num, mode);
	}

	@Override
	public int deleteBoard(int num) {
		return BoardMapper.deleteBoard(num);
	}

	@Override
	public int insertBoard(BoardDBBean dto) {
		return BoardMapper.insertBoard(dto);
	}

	@Override
	public int updateBoard(BoardDBBean dto) {
		return BoardMapper.updateBoard(dto);
	}

	@Override
	public boolean pwCheck(int num, String pw) {
		String sql="select * from spring_board where num=?";
		RowMapper mapper=new RowMapper(){
			@Override
			public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
				BoardDBBean dto=new BoardDBBean();
				dto.setNum(arg0.getInt("num"));
				dto.setWriter(arg0.getString("writer"));
				dto.setEmail(arg0.getString("email"));
				dto.setSubject(arg0.getString("subject"));
				dto.setPasswd(arg0.getString("passwd"));
				dto.setReg_date(arg0.getString("reg_date"));
				dto.setReadcount(arg0.getInt("readcount"));
				dto.setContent(arg0.getString("content"));
				dto.setIp(arg0.getString("ip"));
				return dto;
			}
		};
		BoardDBBean result=(BoardDBBean)BoardMapper.getBoard(num,"");
		if(result.getPasswd().equals(pw)){
			return true;
		}else{
			return false;
		}
	}
}
