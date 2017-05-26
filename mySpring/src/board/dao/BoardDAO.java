package board.dao;

import java.util.List;

import board.dto.BoardDBBean;

public interface BoardDAO {
	public List boardList();
	public BoardDBBean getContent(int num);
	public boolean pwCheck(int num,String pw);
	public int deleteBoard(int num);
	public int insertBoard(BoardDBBean dto);
	public int updateBoard(BoardDBBean dto);
}
