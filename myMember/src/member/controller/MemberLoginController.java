package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberLoginController implements Controller {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String id=arg0.getParameter("id");
		String passwd=arg0.getParameter("passwd");
		String msg=null;
		String url=null;
		try{
			if(memberDAO.memberLogin(id, passwd)){
				msg="로그인에 성공!!";
				url="index.jsp";
			}else{
				msg="로그인에 실패!! 비밀번호를 확인하세요";
				url="member_login_form.do";
			}
		}catch(DataAccessException e){
			msg="로그인에 실패!! 아이디를 확인하세요";
			url="member_login_form.do";
		}
		MemberDTO dto=memberDAO.selectMember(id);
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		arg0.getSession().setAttribute("dto", dto);
		return mav;
	}

}
