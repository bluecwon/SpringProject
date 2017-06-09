package prod.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import cate.dao.CateDAO;
import prod.dao.ProductDAO;
import prod.dto.ProductDTO;

@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CateDAO cateDAO;
	/*public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	public void setCateDAO(CateDAO cateDAO) {
		this.cateDAO = cateDAO;
	}*/

	@RequestMapping(value = "/prod_input.do", method = RequestMethod.GET)
	public ModelAndView prodInputForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List cateList=cateDAO.listCate();
		return new ModelAndView("WEB-INF/myshop/prod_inputform.jsp","cateList",cateList);
	}
	
	@RequestMapping(value = "/prod_input.do", method = RequestMethod.POST)
	public ModelAndView prodInput(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*request.setCharacterEncoding("EUC-KR");
		MultipartRequest mr=null;
		DefaultFileRenamePolicy dp;
		String upPath=request.getServletContext().getRealPath("/img");
		int len=30*1024*1024;
		try{
			dp=new DefaultFileRenamePolicy();
			mr=new MultipartRequest(request,upPath,len,"EUC-KR",dp);
		}catch(IOException e){
			e.printStackTrace();
		}*/
		/*ProductDTO pdto=new ProductDTO();
		pdto.setPname(mr.getParameter("pname"));
		pdto.setPcompany(mr.getParameter("pcompany"));
		pdto.setPimage(mr.getFilesystemName("pimage"));
		pdto.setPqty(Integer.parseInt(mr.getParameter("pqty")));
		pdto.setPrice(Integer.parseInt(mr.getParameter("price")));
		pdto.setPspec(mr.getParameter("pspec"));
		pdto.setPcontents(mr.getParameter("pcontents"));
		pdto.setPoint(Integer.parseInt(mr.getParameter("point")));
		String categorycode=mr.getParameter("categorycode");
		String productcode=mr.getParameter("productcode");
		String pcategory_fk=categorycode+"+"+productcode;
		pdto.setPcategory_fk(pcategory_fk);*/
		
		ProductDTO dto=makeProduct(request);
		int res=productDAO.inputProduct(dto);
		String msg=null;
		String url=null;
		if(res>0){
			msg="상품 등록 성공!";
			url="prod_list.do";
		}else{
			msg="상품 등록 실패!";
			url="prod_input.do";
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
	
	@RequestMapping(value = "/prod_list.do", method = RequestMethod.GET)
	public ModelAndView prodList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List prodList=productDAO.listProduct();
		String upPath=request.getServletContext().getRealPath("/img");
		ModelAndView mav= new ModelAndView("WEB-INF/myshop/prod_list.jsp");
		mav.addObject("prodList", prodList);
		mav.addObject("upPath",upPath);
		return mav;
	}
	
	@RequestMapping(value = "/prod_delete.do", method = RequestMethod.GET)
	public ModelAndView prodDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("EUC-KR");
		String pnum=request.getParameter("pnum");
		String pimage=request.getParameter("pimage");
		
		int res = productDAO.deleteProduct(Integer.parseInt(pnum));
		String msg = null;
		String url = "prod_list.do";
		if (res>0){
			String delPath = request.getServletContext().getRealPath("/img");
			File file = new File(delPath, pimage);
			if (file.exists()){
				file.delete();
				msg = "상품삭제성공!! 상품목록으로 이동합니다.";
			}else {
				msg = "상품삭제성공(이미지삭제는 실패)!! 상품목록으로 이동합니다.";
			}
		}else {
			msg = "상품삭제실패!! 상품목록으로 이동합니다.";
		}
		ModelAndView mav=new ModelAndView("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url",url);
		return mav;
	}
	
	@RequestMapping(value = "/prod_view.do", method = RequestMethod.GET)
	public ModelAndView prodView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int num=ServletRequestUtils.getIntParameter(request,"pnum");
		ProductDTO prodDTO=productDAO.getProduct(num);
		String upPath=request.getServletContext().getRealPath("/img");
		ModelAndView mav=new ModelAndView("WEB-INF/myshop/prod_view.jsp");
		mav.addObject("prodDTO", prodDTO);
		mav.addObject("upPath", upPath);
		return mav;
	}
	
	@RequestMapping(value = "/prod_update.do", method = RequestMethod.GET)
	public ModelAndView prodUpdateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int num=ServletRequestUtils.getIntParameter(request,"pnum");
		ProductDTO prodDTO=productDAO.getProduct(num);
		String upPath=request.getServletContext().getRealPath("/img");
		String[] spec={"NORMAL","HIT","BEST","NEW"};
		ModelAndView mav=new ModelAndView("WEB-INF/myshop/prod_updateform.jsp");
		mav.addObject("spec", spec);
		mav.addObject("prodDTO", prodDTO);
		mav.addObject("upPath", upPath);
		return mav;
	}
	
	@RequestMapping(value = "/prod_update.do", method = RequestMethod.POST)
	public ModelAndView prodUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductDTO pdto=makeProduct(request);
		int res=productDAO.updateProduct(pdto);
		String msg=null;
		String url=null;
		if(res>0){
			msg="상품 수정 성공!";
			url="prod_list.do";
		}else{
			msg="상품 수정 실패!";
			url="prod_update.do?pnum="+pdto.getPnum();
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
	
	private ProductDTO makeProduct(HttpServletRequest arg0) throws Exception{
		ProductDTO dto=new ProductDTO();
		//스프링에서 파일 multipart 처리
		//파일 받기
		MultipartHttpServletRequest mr=(MultipartHttpServletRequest)arg0;
		MultipartFile mf=mr.getFile("pimage");
		String filename=mf.getOriginalFilename();
		
		//파일경로 지정하기
		HttpSession session=arg0.getSession();
		String upPath=session.getServletContext().getRealPath("/img");
				
		//서버에 파일쓰기
		File file=new File(upPath,filename);
		for(int k=0;true;k++){
			if(file.exists()){
				String tempfilename=filename+"("+k+")";
				file=new File(upPath,tempfilename);
				continue;
			}
			break;
		}
		if(!mf.isEmpty()){
			mf.transferTo(file);
			dto.setPimage(filename);
			if(arg0.getParameter("pimage1")!=null){
				File file2=new File(upPath+"/"+arg0.getParameter("pimage1"));
				file2.delete();
				dto.setPnum(Integer.parseInt(arg0.getParameter("pnum")));
			}
		}else{
			if(arg0.getParameter("pimage1")!=null){
				dto.setPimage(arg0.getParameter("pimage1"));
				dto.setPnum(Integer.parseInt(arg0.getParameter("pnum")));
			}
		}
		dto.setPname(arg0.getParameter("pname"));
		dto.setPcompany(arg0.getParameter("pcompany"));
		dto.setPqty(Integer.parseInt(arg0.getParameter("pqty")));
		dto.setPrice(Integer.parseInt(arg0.getParameter("price")));
		dto.setPspec(arg0.getParameter("pspec"));
		dto.setPcontents(arg0.getParameter("pcontents"));
		dto.setPoint(Integer.parseInt(arg0.getParameter("point")));
		String categorycode=arg0.getParameter("categorycode");
		String productcode=arg0.getParameter("productcode");
		String pcategory_fk=categorycode+"+"+productcode;
		dto.setPcategory_fk(pcategory_fk);
		return dto;
	}
	
}
