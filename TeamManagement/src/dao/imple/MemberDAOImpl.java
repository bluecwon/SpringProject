package dao.imple;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberDAOImpl extends SimpleJdbcTemplate implements MemberDAO{
	private InsertMember insertMember;
	
	public MemberDAOImpl(DataSource dataSource){
		super(dataSource);
		insertMember=new InsertMember(dataSource);
	}
	@Override
	public List getMembers(Integer id) throws DataAccessException {
		
		return null;
	}

	@Override
	public MemberDTO getMember(Integer id) throws DataAccessException {
		
		return null;
	}

	@Override
	public void insertMember(MemberDTO member) throws DataAccessException {
		Object[] values=new Object[]{member.getName(),member.getTeam().getId()};
		insertMember.update(values);
	}

	@Override
	public void deleteMember(MemberDTO member) throws DataAccessException {
		
	}

	@Override
	public void updateMember(MemberDTO member) throws DataAccessException {
		
	}

}
