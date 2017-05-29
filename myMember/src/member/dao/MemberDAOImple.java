package member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import member.dto.MemberDTO;

public class MemberDAOImple implements MemberDAO {
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	protected class MemberRowMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
			MemberDTO dto=new MemberDTO();
			dto.setNo(arg0.getInt("no"));
			dto.setName(arg0.getString("name"));
			dto.setId(arg0.getString("id"));
			dto.setPasswd(arg0.getString("passwd"));
			dto.setSsn1(arg0.getString("ssn1"));
			dto.setSsn2(arg0.getString("ssn2"));
			dto.setEmail(arg0.getString("email"));
			dto.setHp1(arg0.getString("hp1"));
			dto.setHp2(arg0.getString("hp2"));
			dto.setHp3(arg0.getString("hp3"));
			dto.setJoindate(arg0.getString("joindate"));
			return dto;
		}
	}

	@Override
	public boolean memberLogin(String id, String passwd) {
		String sql="select * from jsp_member where id=?";
		RowMapper mapper=new MemberRowMapper();
		MemberDTO dto=(MemberDTO)jdbcTemplate.queryForObject(sql, mapper,id);
		if(dto.getPasswd().equals(passwd)){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean checkMember(String name, String ssn1, String ssn2) {
		String sql="select count(*) from jsp_member where name=? and ssn1=? and ssn2=?";
		Object[] values=new Object[]{name,ssn1,ssn2};
		int res=jdbcTemplate.queryForInt(sql,values);
		if(res>0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public int insertMember(MemberDTO dto) {
		String sql="insert into jsp_member values(member_seq.nextval,?,?,?,?,?,?,?,?,?,sysdate)";
		Object[] values=new Object[]{dto.getName(),dto.getId(),dto.getPasswd(),dto.getSsn1(),dto.getSsn2(),dto.getEmail(),dto.getHp1(),dto.getHp2(),dto.getHp3()};
		int res=jdbcTemplate.update(sql, values);
		return res;
	}

	@Override
	public MemberDTO selectMember(String id) {
		String sql="select * from jsp_member where id=?";
		RowMapper mapper=new MemberRowMapper();
		MemberDTO dto=(MemberDTO)jdbcTemplate.queryForObject(sql,mapper, id);
		return dto;
	}

	@Override
	public List listMember() {
		String sql="select * from jsp_member";
		RowMapper mapper=new MemberRowMapper();
		List list=jdbcTemplate.query(sql,mapper);
		return list;
	}

	@Override
	public String findId(String name, String ssn1, String ssn2) {
		String sql="select * from jsp_member where name=? and ssn1=? and ssn2=?";
		RowMapper mapper=new MemberRowMapper();
		Object[] values=new Object[]{name,ssn1,ssn2};
		try{
			MemberDTO dto=(MemberDTO)jdbcTemplate.queryForObject(sql,mapper,values);
			return dto.getId();
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public String findPw(MemberDTO dto) {
		String sql="select * from jsp_member where id=? and name=? and hp1=? and hp2=? and hp3=?";
		RowMapper mapper=new MemberRowMapper();
		Object[] values=new Object[]{dto.getId(),dto.getName(),dto.getHp1(),dto.getHp2(),dto.getHp3()};
		try{
			MemberDTO result=(MemberDTO)jdbcTemplate.queryForObject(sql,mapper,values);
			return result.getPasswd();
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	@Override
	public int deleteMember(int num) {
		String sql="delete from jsp_member where no=?";
		int result=jdbcTemplate.update(sql,num);
		return result;
	}

	@Override
	public int updateMember(MemberDTO dto) {
		String sql="update jsp_member set email=?, hp1=?, hp2=?, hp3=?, passwd=? where no=?";
		Object[] values=new Object[]{dto.getEmail(),dto.getHp1(),dto.getHp2(),dto.getHp3(),dto.getPasswd(),dto.getNo()};
		int res=jdbcTemplate.update(sql,values);
		return res;
	}

	@Override
	public boolean checkPW(int num, String passwd) {
		String sql="select * from jsp_member where no=?";
		RowMapper mapper=new MemberRowMapper();
		MemberDTO dto=(MemberDTO)jdbcTemplate.queryForObject(sql,mapper,num);
		if(dto.getPasswd().equals(passwd)){
			return true;
		}else{
			return false;
		}
	}
}
