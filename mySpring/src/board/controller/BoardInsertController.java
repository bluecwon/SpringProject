package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.mvc.Controller;

import board.dao.BoardDAO;
import board.dto.BoardDBBean;

public class BoardInsertController extends AbstractCommandController /*implements Controller*/{
	
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	/*@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		BoardDBBean dto=new BoardDBBean();
		dto.setWriter(arg0.getParameter("writer"));
		dto.setEmail(arg0.getParameter("email"));
		dto.setContent(arg0.getParameter("content"));
		dto.setPasswd(arg0.getParameter("passwd"));
		dto.setSubject(arg0.getParameter("subject"));
		dto.setIp(arg0.getRemoteAddr());
		
		int result=boardDAO.insertBoard(dto);
		String msg=null;
		String url="board_list.do";
		if(result>0){
			msg="해당 글을 등록하였습니다.";
		}else{
			msg="등록에 실패하였습니다. 관리자에게 문의하세요";
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}*/
	@Override
	protected ModelAndView handle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, BindException arg3)
			throws Exception {
		BoardDBBean dto=(BoardDBBean)arg2;
		dto.setIp(arg0.getRemoteAddr());
		
		int result=boardDAO.insertBoard(dto);
		String msg=null;
		String url="board_list.do";
		if(result>0){
			msg="해당 글을 등록하였습니다.";
		}else{
			msg="등록에 실패하였습니다. 관리자에게 문의하세요";
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}

}
