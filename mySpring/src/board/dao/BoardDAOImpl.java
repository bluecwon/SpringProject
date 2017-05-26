package board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import board.dto.BoardDBBean;

public class BoardDAOImpl implements BoardDAO {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List boardList() {
		String sql="select * from spring_board order by num desc";
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
		List result=jdbcTemplate.query(sql, mapper);
		return result;
	}
	@Override
	public BoardDBBean getContent(int num){
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
		/*ResultSetExtractor rse=new ResultSetExtractor() {
			@Override
			public Object extractData(ResultSet arg0) throws SQLException, DataAccessException {
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
		};*/
		BoardDBBean result=(BoardDBBean)jdbcTemplate.queryForObject(sql,mapper,num);
		return result;
	}

	@Override
	public int deleteBoard(int num) {
		String sql="delete from spring_board where num=?";
		int result=jdbcTemplate.update(sql, num);
		return result;
	}

	@Override
	public int insertBoard(BoardDBBean dto) {
		String sql="insert into spring_board values(spring_board_seq.nextval,?,?,?,?,sysdate,0,?,?)";
		Object[] obj=new Object[]{dto.getWriter(),dto.getEmail(),dto.getSubject(),dto.getPasswd(),dto.getContent(),dto.getIp()};
		int result =jdbcTemplate.update(sql, obj);
		return result;
	}

	@Override
	public int updateBoard(BoardDBBean dto) {
		String sql="update spring_board set email=?,subject=?,content=? where num=?";
		Object[] obj=new Object[]{dto.getEmail(),dto.getSubject(),dto.getContent(),dto.getNum()};
		int result=jdbcTemplate.update(sql, obj);
		return result;
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
		BoardDBBean result=(BoardDBBean)jdbcTemplate.queryForObject(sql,mapper,num);
		if(result.getPasswd().equals(pw)){
			return true;
		}else{
			return false;
		}
	}
}
