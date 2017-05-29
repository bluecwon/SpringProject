package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberFindPWController implements Controller {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		arg0.setCharacterEncoding("EUC-KR");
		MemberDTO dto=new MemberDTO();
		dto.setId(arg0.getParameter("id"));
		dto.setName(arg0.getParameter("name"));
		dto.setHp1(arg0.getParameter("hp1"));
		dto.setHp2(arg0.getParameter("hp2"));
		dto.setHp3(arg0.getParameter("hp3"));
		String passwd = memberDAO.findPw(dto);
		String msg=null;
		String url="member_login_form.do";
		if(passwd==null){
			msg="정보가 일치하지 않습니다 다시 확인해 주세요";
		}else{
			msg="회원님의 비밀번호는 "+passwd+"입니다.";
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}

}
