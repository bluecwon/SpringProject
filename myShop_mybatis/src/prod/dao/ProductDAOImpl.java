package prod.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import mybatis.ShopMapper;
import prod.dto.ProductDTO;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public int inputProduct(ProductDTO dto) {
		return ShopMapper.inputProduct(dto);
	}

	@Override
	public List listProduct() {
		return ShopMapper.listProduct();
	}

	@Override
	public int deleteProduct(int num) {
		return ShopMapper.deleteProduct(num);
	}

	@Override
	public ProductDTO getProduct(int num) {
		return ShopMapper.getProduct(num);
	}

	@Override
	public int updateProduct(ProductDTO dto) {
		return ShopMapper.updateProduct(dto);
	}
	
}
