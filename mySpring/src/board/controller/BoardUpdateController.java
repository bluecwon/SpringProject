package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.dao.BoardDAO;
import board.dto.BoardDBBean;

public class BoardUpdateController implements Controller{
	
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		BoardDBBean dto=new BoardDBBean();
		dto.setWriter(arg0.getParameter("writer"));
		dto.setEmail(arg0.getParameter("email"));
		dto.setContent(arg0.getParameter("content"));
		dto.setPasswd(arg0.getParameter("passwd"));
		dto.setSubject(arg0.getParameter("subject"));
		dto.setNum(ServletRequestUtils.getIntParameter(arg0, "num"));
		
		String msg=null;
		String url=null;
		if(boardDAO.pwCheck(dto.getNum(),dto.getPasswd())){
			int result=boardDAO.updateBoard(dto);
			url="board_list.do";
			if(result>0){
				msg="�ش� ���� �����Ͽ����ϴ�.";
			}else{
				msg="������ �����Ͽ����ϴ�. �����ڿ��� �����ϼ���";
			}
		}else{
			msg="��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
			url="board_update_form.do?num="+dto.getNum();
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}

}
