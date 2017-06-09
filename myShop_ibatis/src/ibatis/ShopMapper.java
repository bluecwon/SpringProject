package ibatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import cate.dto.CateDTO;
import prod.dto.ProductDTO;

/**
 * This is not a best practices class.  It's just an example
 * to give you an idea of how iBATIS works.  For a more complete
 * example, see JPetStore 5.0 at http://www.ibatis.com.
 */
public class ShopMapper {

  /**
   * SqlMapClient instances are thread safe, so you only need one.
   * In this case, we'll use a static singleton.  So sue me.  ;-)
   */
  private static SqlMapClient sqlMapper;

  /**
   * It's not a good idea to put code that can fail in a class initializer,
   * but for sake of argument, here's how you configure an SQL Map.
   */
  static {
    try {
      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
      sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
      reader.close(); 
    } catch (IOException e) {
      // Fail fast.
      throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
    }
  }
  
  public static List listCate(){
	  List res=null;
	  try{
		  res=sqlMapper.queryForList("listCate");
	  }catch(SQLException e){
		  System.err.println("listCate() 오류!");
	  }
	  return res;
  }
  
  public static int inputCate(CateDTO dto){
	  int res=0;
	  try{
		  res=sqlMapper.update("inputCate", dto);
	  }catch(SQLException e){
		  System.err.println("inputCate() 오류!");
	  }
	  return res;
  }
  
  public static int deleteCate(int cnum){
	  int res=0;
	  try{
		  res=sqlMapper.update("deleteCate", cnum);
	  }catch(SQLException e){
		  System.err.println("deleteCate() 오류!");
	  }
	  return res;
  }
  
  public static CateDTO searchCname(String code){
	  CateDTO res=null;
	  try{
		  res=(CateDTO)sqlMapper.queryForObject("searchCname",code);
	  }catch(SQLException e){
		  System.err.println("searchCname() 오류!");
	  }
	  return res;
  }
  
  public static int inputProduct(ProductDTO dto){
	  int res=0;
	  try{
		  res=sqlMapper.update("inputProduct",dto);
	  }catch(SQLException e){
		  System.err.println("inputProduct() 오류!");
	  }
	  return res;
  }
  
  public static List listProduct(){
	  List res=null;
	  try{
		  res=sqlMapper.queryForList("listProduct");
	  }catch(SQLException e){
		  System.err.println("listProduct() 오류!");
	  }
	  return res;
  }
  
  public static ProductDTO getProduct(int num){
	  ProductDTO res=null;
	  try{
		  res=(ProductDTO)sqlMapper.queryForObject("getProduct",num);
	  }catch(SQLException e){
		  System.err.println("getProduct() 오류!");
	  }
	  return res;
  }
  
  public static int deleteProduct(int pnum){
	  int res=0;
	  try{
		  res=sqlMapper.update("deleteProduct",pnum);
	  }catch(SQLException e){
		  System.err.println("deleteProduct() 오류!");
	  }
	  return res;
  }
  
  public static int updateProduct(ProductDTO dto){
	  int res=0;
	  try{
		  res=sqlMapper.update("updateProduct",dto);
	  }catch(SQLException e){
		  System.err.println("updateProduct() 오류!");
	  }
	  return res;
  }
  
  public static List listSpecProduct(String pspec){
	  List res=null;
	  try{
		  res=sqlMapper.queryForList("listSpecProduct",pspec);
	  }catch(SQLException e){
		  System.err.println("listSpecProduct() 오류!");
	  }
	  return res;
  }
  
  public static List listCateProduct(String cate){
	  List res=null;
	  try{
		  res=sqlMapper.queryForList("listCateProduct",cate);
	  }catch(SQLException e){
		  System.err.println("listCateProduct() 오류!");
	  }
	  return res;
  }
  

}
