package board.ibatis;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import board.dto.BoardDBBean;

/**
 * This is not a best practices class.  It's just an example
 * to give you an idea of how iBATIS works.  For a more complete
 * example, see JPetStore 5.0 at http://www.ibatis.com.
 */
public class BoardMapper {

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

  public static List listBoard(){
	  List list=null;
	  try{
		  list=sqlMapper.queryForList("boardList");
	  }catch(SQLException e){
		  System.err.println("listBoard()실행 중 에러발생!");
		  e.printStackTrace();
	  }
	  return list;
  }
  
  public static BoardDBBean getBoard(int num){
	  BoardDBBean dto=null;
	  try{
		  sqlMapper.update("updateReadcount",num);
		  dto=(BoardDBBean)sqlMapper.queryForObject("getBoard",num);
	  }catch(SQLException e){
		  System.err.println("getBoard() 실행 중 에러 발생!!");
	  }
	  return dto;
  }
  
  public static int deleteBoard(int num){
	  int res=0;
	  try{
		  res=sqlMapper.delete("deleteBoard",num);
	  }catch(SQLException e){
		  System.err.println("deleteBoard() 실행중 에러 발생!");
	  }
	  return res;
  }
  
  public static int updateBoard(BoardDBBean dto){
	  int res=0;
	  try{
		  res=sqlMapper.update("updateBoard",dto);
	  }catch(SQLException e){
		  System.err.println("updateBoard() 실행중 에러 발생!");
	  }
	  return res;
  }
  
  public static int insertBoard(BoardDBBean dto){
	  int res=0;
	  try{
		  res=sqlMapper.update("insertBoard",dto);
	  }catch(SQLException e){
		  System.err.println("insertBoard() 실행중 에러 발생!");
	  }
	  return res;
  }

}
