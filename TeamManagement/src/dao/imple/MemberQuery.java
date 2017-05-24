package dao.imple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import dto.MemberDTO;
import dto.TeamDTO;

public class MemberQuery extends MappingSqlQuery<Object> {
	private static String sql = "select * from member where member_id = ?";
	
	public MemberQuery(DataSource dataSource){
		super(dataSource, sql);
		super.declareParameter(new SqlParameter("member_id", Types.INTEGER));
		compile();
	}
	
	@Override
	protected Object mapRow(ResultSet arg0, int arg1) throws SQLException {
		MemberDTO member=new MemberDTO();
		member.setId(arg0.getInt("member_id"));
		member.setName(arg0.getString("name"));
		return member;
	}

}