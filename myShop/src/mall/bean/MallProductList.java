package mall.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import prod.dto.ProductDTO;

public class MallProductList {
	ArrayList<ProductDTO> p_list,p_list2;
	Hashtable<String,ArrayList<ProductDTO>> ht;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/*public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}*/

	public MallProductList(){
		p_list=new ArrayList<ProductDTO>();
		p_list2=new ArrayList<ProductDTO>();
		ht=new Hashtable<String,ArrayList<ProductDTO>>();
	}
	

	
	public ArrayList<ProductDTO> listSpecProduct(String pspec) throws SQLException{
		p_list=null;
		String sql="select * from Product where pspec=?";
		RowMapper mapper=new ProdMapper();
		p_list=(ArrayList)jdbcTemplate.query(sql,mapper,pspec);
		ht.put(pspec,p_list);
		return p_list;
	}
	
	public ArrayList<ProductDTO> listCateProduct(String cate) throws SQLException{
		p_list=null;
		String sql="select * from Product where pcategory_fk like '"+cate+"%'";
		RowMapper mapper=new ProdMapper();
		p_list=(ArrayList)jdbcTemplate.query(sql,mapper);
		ht.put(cate, p_list);
		return p_list;
	}
	
	
	public ProductDTO searchProduct(String str,int pnum){
		p_list2=ht.get(str);
		for(ProductDTO pdto:p_list2){
			if(pdto.getPnum()==pnum){
				return pdto;
			}
		}
		return null;
	}

	public Hashtable<String, ArrayList<ProductDTO>> getHt() {
		return ht;
	}
	
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
}
