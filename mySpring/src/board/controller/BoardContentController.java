package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.dao.BoardDAO;
import board.dto.BoardDBBean;

public class BoardContentController implements Controller{
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//ModelAndView mav=new ModelAndView();
		//mav.setViewName("WEB-INF/board/content.jsp");
		//int num=Integer.parseInt(arg0.getParameter("num"));
		int num=ServletRequestUtils.getIntParameter(arg0, "num");
		BoardDBBean dto=boardDAO.getContent(num);
		//mav.addObject("content",dto);
		ModelAndView mav=new ModelAndView("WEB-INF/board/content.jsp","content",dto);
		return mav;
	}

}
