package dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import dto.TeamDTO;

public interface TeamDAO {
	List	getTeamList() throws DataAccessException;
	TeamDTO	getTeam(Integer id) throws DataAccessException;
}
