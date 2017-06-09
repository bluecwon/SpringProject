package mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import cate.dto.CateDTO;
import prod.dto.ProductDTO;

public class ShopMapper {


  private static SqlSessionFactory sqlMapper;

  static {
    try {
    	String resource="SqlMapConfig.xml";
    	Reader reader = Resources.getResourceAsReader(resource); 
		sqlMapper = new SqlSessionFactoryBuilder().build(reader); 
    } catch (IOException e) {
      throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
    }
  }
  
  public static List listCate(){
	  List res=null;
	  SqlSession session=sqlMapper.openSession();
	  res=session.selectList("listCate");
	  session.close();
	  return res;
  }
  
  public static int inputCate(CateDTO dto){
	  int res=0;
	  SqlSession session=sqlMapper.openSession();
	  res=session.insert("inputCate",dto);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static int deleteCate(int cnum){
	  int res=0;
	  SqlSession session=sqlMapper.openSession();
	  res=session.delete("deleteCate",cnum);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static CateDTO searchCname(String code){
	  CateDTO res=null;
	  SqlSession session=sqlMapper.openSession();
	  res=session.selectOne("searchCname",code);
	  session.close();
	  return res;
  }
  
  public static int inputProduct(ProductDTO dto){
	  int res=0;
	  SqlSession session=sqlMapper.openSession();
	  res=session.insert("inputProduct", dto);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static List listProduct(){
	  List res=null;
	  SqlSession session=sqlMapper.openSession();
	  res=session.selectList("listProduct");
	  session.close();
	  return res;
  }
  
  public static ProductDTO getProduct(int num){
	  ProductDTO res=null;
	  SqlSession session=sqlMapper.openSession();
	  res=session.selectOne("getProduct",num);
	  session.close();
	  return res;
  }
  
  public static int deleteProduct(int pnum){
	  int res=0;
	  SqlSession session=sqlMapper.openSession();
	  res=session.delete("deleteProduct",pnum);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static int updateProduct(ProductDTO dto){
	  int res=0;
	  SqlSession session=sqlMapper.openSession();
	  res=session.update("updateProduct",dto);
	  session.commit();
	  session.close();
	  return res;
  }
  
  public static List listSpecProduct(String pspec){
	  List res=null;
	  SqlSession session=sqlMapper.openSession();
	  res=session.selectList("listSpecProduct",pspec);
	  session.close();
	  return res;
  }
  
  public static List listCateProduct(String cate){
	  List res=null;
	  SqlSession session=sqlMapper.openSession();
	  res=session.selectList("listCateProduct",cate);
	  session.close();
	  return res;
  }
  

}
