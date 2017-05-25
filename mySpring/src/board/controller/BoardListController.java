package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.dao.BoardDAO;

public class BoardListController implements Controller{ // controller Ŭ������°��� �˷��ֱ� ���� ���
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("WEB-INF/board/list.jsp"); //mav�� ����
		List result=boardDAO.boardList();
		mav.addObject("boardList",result);
		return mav;
	}
	
}
