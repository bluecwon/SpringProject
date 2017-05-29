package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;
import member.dto.MemberDTO;

public class MemberUpdateController implements Controller {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		String oldpasswd=arg0.getParameter("oldpasswd");
		int num=ServletRequestUtils.getIntParameter(arg0, "no");
		String id=arg0.getParameter("id");
		String msg=null;
		String url="member_info.do";
		if(memberDAO.checkPW(num, oldpasswd)){
			MemberDTO dto=new MemberDTO();
			dto.setNo(ServletRequestUtils.getIntParameter(arg0, "no"));
			dto.setEmail(arg0.getParameter("email"));
			dto.setHp1(arg0.getParameter("hp1"));
			dto.setHp2(arg0.getParameter("hp2"));
			dto.setHp3(arg0.getParameter("hp3"));
			dto.setPasswd(arg0.getParameter("passwd"));
			int res=memberDAO.updateMember(dto);
			if(res>0){
				MemberDTO result=memberDAO.selectMember(id);
				arg0.getSession().setAttribute("dto", result);
				msg="수정 성공!";
			}else{
				msg="수정 실패!";
			}
		}else{
			msg="비밀번호가 일치하지 않습니다.";
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}

}
