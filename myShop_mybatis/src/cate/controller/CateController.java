package cate.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cate.dao.CateDAO;
import cate.dto.CateDTO;

@Controller
public class CateController {
	@Autowired
	private CateDAO cateDAO;

	/*public void setCateDAO(CateDAO cateDAO) {
		this.cateDAO = cateDAO;
	}*/

	@RequestMapping(value = "/cate_list.do")
	public ModelAndView cateList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List list = cateDAO.listCate();
		return new ModelAndView("WEB-INF/myshop/cate_list.jsp", "cateList", list);
	}

	@RequestMapping(value = "/cate_input.do", method = RequestMethod.GET)
	public ModelAndView cateInputForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("WEB-INF/myshop/cate_inputform.jsp");
	}

	@RequestMapping(value = "/cate_input.do", method = RequestMethod.POST)
	public ModelAndView cateInput(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("EUC-KR");
		CateDTO dto = new CateDTO();
		dto.setCname(request.getParameter("cname"));
		dto.setCode(request.getParameter("code"));
		String msg=null;
		String url=null;
		int res=cateDAO.inputCate(dto);
		if(res>0){
			msg="카테고리 등록 성공!";
			url="cate_list.do";
		}else{
			msg="카테고리 등록 실패!";
			url="cate_input.do";
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
	
	@RequestMapping(value = "/cate_delete.do", method = RequestMethod.GET)
	public ModelAndView cateDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int num=ServletRequestUtils.getIntParameter(request, "cnum");
		String msg=null;
		String url="cate_list.do";
		int res=cateDAO.deleteCate(num);
		if(res>0){
			msg="카테고리 삭제 성공!";
		}else{
			msg="카테고리 삭제 실패!";
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
}
