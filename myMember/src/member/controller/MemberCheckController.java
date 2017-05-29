package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataAccessException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;

public class MemberCheckController implements Controller {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		arg0.setCharacterEncoding("EUC-KR");
		String name=arg0.getParameter("name");
		String ssn1=arg0.getParameter("ssn1");
		String ssn2=arg0.getParameter("ssn2");
		String msg=null;
		String url=null;
		if(memberDAO.checkMember(name, ssn1, ssn2)){
			msg="회원가입 페이지로 이동합니다.";
			url="member_insert_form.do";
		}else{
			msg="이미 회원가입을 하셨습니다. 로그인 페이지로 이동합니다.";
			url="member_login_form.do";
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		arg0.getSession().setAttribute("name",name);
		arg0.getSession().setAttribute("ssn1",ssn1);
		arg0.getSession().setAttribute("ssn2",ssn2);
		return mav;
	}

}
