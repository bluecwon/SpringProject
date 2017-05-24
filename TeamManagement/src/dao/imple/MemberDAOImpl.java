package dao.imple;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberDAOImpl extends SimpleJdbcTemplate implements MemberDAO{
	private InsertMember insertMember;
	private MembersQuery membersQuery;
	private MemberQuery memberQuery;
	private DeleteMember deleteMember;
	private UpdateMember updateMember;
	
	public MemberDAOImpl(DataSource dataSource){
		super(dataSource);
		insertMember=new InsertMember(dataSource);
		membersQuery=new MembersQuery(dataSource);
		memberQuery=new MemberQuery(dataSource);
		deleteMember=new DeleteMember(dataSource);
		updateMember=new UpdateMember(dataSource);
	}
	@Override
	public List getMembers(Integer id) throws DataAccessException {
		return membersQuery.execute(id);
	}

	@Override
	public MemberDTO getMember(Integer id) throws DataAccessException {
		return (MemberDTO)memberQuery.findObject(id);
	}

	@Override
	public void insertMember(MemberDTO member) throws DataAccessException {
		Object[] values=new Object[]{member.getName(),member.getTeam().getId()};
		insertMember.update(values);
	}

	@Override
	public void deleteMember(MemberDTO member) throws DataAccessException {
		Object[] values=new Object[]{member.getId()};
		deleteMember.update(values);
	}

	@Override
	public void updateMember(MemberDTO member) throws DataAccessException {
		Object[] values=new Object[]{member.getTeam().getId(),member.getId()};
		updateMember.update(values);
	}

}
