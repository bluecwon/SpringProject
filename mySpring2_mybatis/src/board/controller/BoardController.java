package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import board.dao.BoardDAO;
import board.dto.BoardDBBean;
@Controller
public class BoardController {
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	@RequestMapping(value="/board_list.do")
	public ModelAndView listBoard(HttpServletRequest request, HttpServletResponse response)throws Exception{
		ModelAndView mav=new ModelAndView();
		mav.setViewName("WEB-INF/board/list.jsp"); //mav로 리턴
		List result=boardDAO.boardList();
		mav.addObject("boardList",result);
		return mav;	
	}
	@RequestMapping(value="/board_insert.do", method=RequestMethod.GET)
	public ModelAndView insertFormBoard(HttpServletRequest request, HttpServletResponse response)throws Exception{
		ModelAndView mav=new ModelAndView("WEB-INF/board/insert_form.jsp");
		return mav;
	}
	@RequestMapping(value="/board_insert.do",method=RequestMethod.POST)
	public ModelAndView insertPro(HttpServletRequest request, HttpServletResponse response)throws Exception{
		BoardDBBean dto=getBoardDBBean(request);
		dto.setIp(request.getRemoteAddr());
		
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
	
	@RequestMapping(value="/board_content.do",method=RequestMethod.GET)
	public ModelAndView contentBoard(HttpServletRequest request, HttpServletResponse response)throws Exception{
		int num=ServletRequestUtils.getIntParameter(request, "num");
		String mode="content";
		BoardDBBean dto=boardDAO.getContent(num,mode);
		ModelAndView mav=new ModelAndView("WEB-INF/board/content.jsp","content",dto);
		return mav;
	}
	
	@RequestMapping(value="/board_delete.do",method=RequestMethod.GET)
	public ModelAndView deleteFormBoard(HttpServletRequest request, HttpServletResponse response)throws Exception{
		ModelAndView mav=new ModelAndView("WEB-INF/board/delete_form.jsp");
		return mav;
	}
	
	@RequestMapping(value="/board_delete.do",method=RequestMethod.POST)
	public ModelAndView deleteBoard(HttpServletRequest request, HttpServletResponse response)throws Exception{
		int num=ServletRequestUtils.getIntParameter(request, "num");
		String passwd=request.getParameter("passwd");
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
			url="board_delete.do?num="+num;
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
	
	@RequestMapping(value="/board_update.do",method=RequestMethod.GET)
	public ModelAndView updateFormBoard(HttpServletRequest request, HttpServletResponse response)throws Exception{
		int num=ServletRequestUtils.getIntParameter(request, "num");
		BoardDBBean dto=boardDAO.getContent(num,"");
		ModelAndView mav=new ModelAndView("WEB-INF/board/update_form.jsp","dto",dto);
		return mav;
	}
	
	@RequestMapping(value="/board_update.do",method=RequestMethod.POST)
	public ModelAndView updateBoard(HttpServletRequest request, HttpServletResponse response)throws Exception{
		BoardDBBean dto=new BoardDBBean();
		dto.setWriter(request.getParameter("writer"));
		dto.setEmail(request.getParameter("email"));
		dto.setContent(request.getParameter("content"));
		dto.setPasswd(request.getParameter("passwd"));
		dto.setSubject(request.getParameter("subject"));
		dto.setNum(ServletRequestUtils.getIntParameter(request, "num"));
		
		String msg=null;
		String url=null;
		if(boardDAO.pwCheck(dto.getNum(),dto.getPasswd())){
			int result=boardDAO.updateBoard(dto);
			url="board_list.do";
			if(result>0){
				msg="해당 글을 수정하였습니다.";
			}else{
				msg="수정에 실패하였습니다. 관리자에게 문의하세요";
			}
		}else{
			msg="비밀번호가 일치하지 않습니다.";
			url="board_update.do?num="+dto.getNum();
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
	
	private BoardDBBean getBoardDBBean(HttpServletRequest arg0) throws Exception{
		BoardDBBean dto=new BoardDBBean();
		String num=arg0.getParameter("num");
		if(num!=null)dto.setNum(Integer.parseInt(num));
		dto.setWriter(arg0.getParameter("writer"));
		dto.setEmail(arg0.getParameter("email"));
		dto.setSubject(arg0.getParameter("subject"));
		dto.setContent(arg0.getParameter("content"));
		dto.setPasswd(arg0.getParameter("passwd"));
		return dto;
	}
}
