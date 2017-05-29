package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;

public class MemberFindIDController implements Controller {
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
		String id=memberDAO.findId(name, ssn1, ssn2);
		String msg=null;
		String url="member_login_form.do";
		if(id==null){
			msg="�ش� ������ ���̵�� �������� �ʽ��ϴ�.";
		}else{
			msg="ȸ������ ���̵�� "+id+"�Դϴ�.";
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}

}
