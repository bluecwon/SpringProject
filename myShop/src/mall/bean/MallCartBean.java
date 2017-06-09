package mall.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;

import prod.dto.ProductDTO;

public class MallCartBean {
	ProductDTO p,p2;
	@Autowired
	MallProductList mallProductList;
	
	Hashtable<String,ProductDTO> ht;
	
	/*public void setMallProductList(MallProductList mallProductList) {
		this.mallProductList = mallProductList;
	}*/

	public MallCartBean(){
		p=new ProductDTO();
		p2=new ProductDTO();
		ht=new Hashtable<String,ProductDTO>();
	}
	
	public boolean cartAdd(String key,int pnum,int qty) throws SQLException{	
		ArrayList<ProductDTO> list=mallProductList.getHt().get(key);
		for(ProductDTO dto:list){
			if(dto.getPnum()==pnum){
				if(ht.get(String.valueOf(pnum))==null){
					dto.setPqty(qty);
					ht.put(String.valueOf(pnum), dto);
					return true;
				}else{
					int pqty=ht.get(String.valueOf(pnum)).getPqty();
					dto.setPqty(pqty+qty);
					ht.put(String.valueOf(pnum), dto);
					return true;
				}
			}
		}
		return false;
	}
	
	public Hashtable<String, ProductDTO> listCart() {
		return ht;
	}
	
	public boolean cartEdit(int pnum,int qty)throws SQLException{	
		ht.get(String.valueOf(pnum)).setPqty(qty);
		if(qty==ht.get(String.valueOf(pnum)).getPqty()){
	    return true;
		}else{
		return false;
		}
	}
	
	public boolean cartDelete(int pnum)throws SQLException{	
		ht.remove(String.valueOf(pnum));
		if(ht.get(String.valueOf(pnum))==null){
	    return true;
		}else{
		return false;
		}
	}
}
