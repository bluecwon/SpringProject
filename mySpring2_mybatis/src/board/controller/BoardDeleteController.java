package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.dao.BoardDAO;

public class BoardDeleteController implements Controller{
	
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		int num=ServletRequestUtils.getIntParameter(arg0, "num");
		String passwd=arg0.getParameter("passwd");
		String msg=null;
		String url=null;
		if(boardDAO.pwCheck(num,passwd)){
			int result=boardDAO.deleteBoard(num);
			url="board_list.do";
			if(result>0){
				msg="해당 글을 삭제하였습니다.";
			}else{
				msg="삭제에 실패하였습니다. 관리자에게 문의하세요";
			}
		}else{
			msg="비밀번호가 일치하지 않습니다.";
			url="board_delete_form.do?num="+num;
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}

}
