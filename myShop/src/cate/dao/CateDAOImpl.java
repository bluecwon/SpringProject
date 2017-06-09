package cate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cate.dto.CateDTO;

public class CateDAOImpl implements CateDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/
	
	private class cateMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
			CateDTO dto=new CateDTO();
			dto.setCname(arg0.getString("cname"));
			dto.setCnum(arg0.getInt("cnum"));
			dto.setCode(arg0.getString("code"));
			return dto;
		}
		
	}

	@Override
	public List listCate() {
		String sql="select * from category";
		RowMapper mapper=new cateMapper();
		List list=jdbcTemplate.query(sql, mapper);
		return list;
	}

	@Override
	public int inputCate(CateDTO dto) {
		String sql="insert into category values(cate_seq.nextval,?,?)";
		Object[] values=new Object[]{dto.getCode(),dto.getCname()};
		int res=jdbcTemplate.update(sql, values);
		return res;
	}

	@Override
	public int deleteCate(int cnum) {
		String sql="delete from category where cnum=?";
		int res=jdbcTemplate.update(sql, cnum);
		return res;
	}

	@Override
	public String searchName(String code) {
		String sql="select * from category where code=?";
		RowMapper mapper=new cateMapper();
		CateDTO dto=(CateDTO)jdbcTemplate.queryForObject(sql, mapper, code);
		return dto.getCname();
	}	
}
