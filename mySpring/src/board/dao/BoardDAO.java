package board.dao;

import java.util.List;

import board.dto.BoardDBBean;

public interface BoardDAO {
	public List boardList();
	public BoardDBBean getContent(int num);
}
