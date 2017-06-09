package mall.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;


import ibatis.ShopMapper;
import prod.dto.ProductDTO;

public class MallProductList {
	ArrayList<ProductDTO> p_list,p_list2;
	Hashtable<String,ArrayList<ProductDTO>> ht;

	public MallProductList(){
		p_list=new ArrayList<ProductDTO>();
		p_list2=new ArrayList<ProductDTO>();
		ht=new Hashtable<String,ArrayList<ProductDTO>>();
	}
	

	
	public ArrayList<ProductDTO> listSpecProduct(String pspec) throws SQLException{
		p_list=null;
		p_list=(ArrayList)ShopMapper.listSpecProduct(pspec);
		ht.put(pspec,p_list);
		return p_list;
	}
	
	public ArrayList<ProductDTO> listCateProduct(String cate) throws SQLException{
		p_list=null;
		p_list=(ArrayList)ShopMapper.listCateProduct(cate);
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
	
}
