package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberInsertController implements Controller {
	private MemberDAO memberDAO;
	

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		MemberDTO dto=new MemberDTO();
		arg0.setCharacterEncoding("EUC-KR");
		dto.setId(arg0.getParameter("id"));
		dto.setName(arg0.getParameter("name"));
		dto.setEmail(arg0.getParameter("email"));
		dto.setPasswd(arg0.getParameter("passwd"));
		dto.setHp1(arg0.getParameter("hp1"));
		dto.setHp2(arg0.getParameter("hp2"));
		dto.setHp3(arg0.getParameter("hp3"));
		dto.setSsn1(arg0.getParameter("ssn1"));
		dto.setSsn2(arg0.getParameter("ssn2"));
		int res=memberDAO.insertMember(dto);
		String msg=null;
		String url=null;
		if(res>0){
			msg="회원가입 성공 로그인페이지로 이동";
			url="member_login_form.do";
		}else{
			msg="회원가입 실패 다시시도해 주세요";
			url="member_check_form.do";
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}

}
