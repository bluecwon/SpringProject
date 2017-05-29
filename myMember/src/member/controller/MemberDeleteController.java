package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;

public class MemberDeleteController implements Controller {
	private MemberDAO memberDAO;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		int num=ServletRequestUtils.getIntParameter(arg0, "num");
		int result=memberDAO.deleteMember(num);
		String msg=null;
		String url="member_list.do";
		if(result>0){
			msg="삭제 성공!";
		}else{
			msg="삭제 실패!";
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}

}
