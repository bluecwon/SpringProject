package dao.imple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import dao.TeamDAO;
import dto.TeamDTO;

public class TeamDAOImpl extends SimpleJdbcTemplate implements TeamDAO {
	
	private TeamDAOImpl(DataSource dataSource){
		super(dataSource);
	}

	@Override
	public List getTeamList() throws DataAccessException {
		RowMapper mapper=new TeamRowMapper();
		String sql="select team_id, name from team";
		List teamList=super.query(sql, mapper); //SimpleJdbcTemplate 클래스가 가지고있는 셀렉트 메소드
		return teamList;
	}

	@Override
	public TeamDTO getTeam(Integer id) throws DataAccessException {
		RowMapper mapper=new TeamRowMapper();
		String sql="select team_id, name from team where team_id=?";
		try{
			TeamDTO team=(TeamDTO)super.queryForObject(sql, mapper, id);
			return team;
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	protected class TeamRowMapper implements RowMapper{
		/*private List teamList = new ArrayList();
		
		public List getResults(){
			return teamList;
		}*///자동으로 만들어 지는 부분
		@Override
		public Object mapRow(ResultSet arg0, int arg1) throws SQLException { //arg1 :count
			TeamDTO team=new TeamDTO();
			team.setId(arg0.getInt("team_id"));
			team.setName(arg0.getString("name"));
			return team;
		}
	}

}
