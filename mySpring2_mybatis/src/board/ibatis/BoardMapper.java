package board.ibatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import board.dto.BoardDBBean;

public class BoardMapper {

	private static SqlSessionFactory sqlMapper;
	static {
		try {
			String resource = "SqlMapConfig.xml"; 
			Reader reader = Resources.getResourceAsReader(resource); 
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}

  	public static List listBoard(){
  		SqlSession session = sqlMapper.openSession();
  		List list = session.selectList("boardList");
  		session.close();
  		return list;
  	}
  	
  	public static BoardDBBean getBoard(int num, String mode){
  		SqlSession session = sqlMapper.openSession();
  		BoardDBBean dto=session.selectOne("getBoard",num);
  		if(mode.equals("content")){
  			session.update("updateReadcount", num);
  		}
  		session.commit();
  		session.close();
  		return dto;
  	}
  	
  	public static int deleteBoard(int num){
  		SqlSession session = sqlMapper.openSession();
  		int res=session.delete("deleteBoard",num);
  		session.commit();//커밋을 해줘야 db에 실제 적용
  		session.close();
  		return res;
  	}
  	
  	public static int insertBoard(BoardDBBean dto){
  		SqlSession session = sqlMapper.openSession();
  		int res=session.insert("insertBoard", dto);
  		session.commit();
  		session.close();
  		return res;
  	}
  	
  	public static int updateBoard(BoardDBBean dto){
  		SqlSession session = sqlMapper.openSession();
  		int res=session.update("updateBoard", dto);
  		session.commit();
  		session.close();
  		return res;
  	}
}












