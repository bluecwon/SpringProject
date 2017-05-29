package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MemberLogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		arg0.getSession().invalidate();
		ModelAndView mav=new ModelAndView("message.jsp");
		mav.addObject("msg", "�α׾ƿ��� �����Ͽ����ϴ�.");
		mav.addObject("url", "index.jsp");
		return mav;
	}

}
