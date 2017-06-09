package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DeleteFormController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//int num=ServletRequestUtils.getIntParameter(arg0, "num");
		ModelAndView mav=new ModelAndView("WEB-INF/board/delete_form.jsp");
		return mav;
	}

}
