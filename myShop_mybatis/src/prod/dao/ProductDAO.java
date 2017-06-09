package prod.dao;

import java.util.List;

import prod.dto.ProductDTO;

public interface ProductDAO {
	public int inputProduct(ProductDTO dto);
	public List listProduct();
	public int deleteProduct(int num);
	public ProductDTO getProduct(int num);
	public int updateProduct(ProductDTO dto);
}
