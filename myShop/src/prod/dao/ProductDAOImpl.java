package prod.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import prod.dto.ProductDTO;

public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/
	
	private class ProdMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
			ProductDTO dto=new ProductDTO();
			dto.setPnum(arg0.getInt("pnum"));
			dto.setPcategory_fk(arg0.getString("Pcategory_fk"));
			dto.setPname(arg0.getString("pname"));
			dto.setPimage(arg0.getString("pimage"));
			dto.setPrice(arg0.getInt("price"));
			dto.setPcompany(arg0.getString("pcompany"));
			dto.setPcontents(arg0.getString("pcontents"));
			dto.setPqty(arg0.getInt("pqty"));
			dto.setPoint(arg0.getInt("point"));
			dto.setPspec(arg0.getString("pspec"));
			return dto;
		}
	}

	@Override
	public int inputProduct(ProductDTO dto) {
		String sql="insert into product values(prod_seq.nextval,?,?,?,?,?,?,?,?,?,sysdate)";
		Object[] values=new Object[]{dto.getPname(),dto.getPcategory_fk(),dto.getPcompany(),dto.getPimage(),
				dto.getPqty(),dto.getPrice(),dto.getPspec(),dto.getPcontents(),dto.getPoint()};
		int res=jdbcTemplate.update(sql, values);
		return res;
	}

	@Override
	public List listProduct() {
		String sql="select * from product";
		RowMapper mapper=new ProdMapper();
		List prodList=jdbcTemplate.query(sql, mapper);
		return prodList;
	}

	@Override
	public int deleteProduct(int num) {
		String sql="delete from product where pnum=?";
		int res=jdbcTemplate.update(sql,num);
		return res;
	}

	@Override
	public ProductDTO getProduct(int num) {
		String sql="select * from product where pnum=?";
		RowMapper mapper=new ProdMapper();
		ProductDTO dto=(ProductDTO)jdbcTemplate.queryForObject(sql, mapper,num);
		return dto;
	}

	@Override
	public int updateProduct(ProductDTO dto) {
		String sql="update product set pname=?, pcompany=?, pimage=?, pqty=?, price=?, pspec=?, pcontents=?, "
				+ "point=? where pnum=?";
		Object[] values=new Object[]{dto.getPname(),dto.getPcompany(),dto.getPimage(),dto.getPqty(),
				dto.getPrice(),dto.getPspec(),dto.getPcontents(),dto.getPoint(),dto.getPnum()};
		int res=jdbcTemplate.update(sql, values);
		return res;
	}
	
}
