package mall.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
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
import mall.bean.MallCartBean;
import mall.bean.MallProductList;
import prod.dto.ProductDTO;

@Controller
public class MallController {
	@Autowired
	private MallProductList mallProductList;
	@Autowired
	private CateDAO cateDAO;
	@Autowired //자동 di
	private MallCartBean mallCartBean;
	
	/*public void setMallCartBean(MallCartBean mallCartBean) {
		this.mallCartBean = mallCartBean;
	}
	public void setMallProductList(MallProductList mallProductList) {
		this.mallProductList = mallProductList;
	}
	public void setCateDAO(CateDAO cateDAO) {
		this.cateDAO = cateDAO;
	}*/
	@RequestMapping(value = "/mall.do", method = RequestMethod.GET)
	public ModelAndView mallIndex(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List cateList=cateDAO.listCate();
		String uppath=request.getServletContext().getRealPath("/img");
		String[] spec={"HIT","NEW","BEST"};
		List HIT=mallProductList.listSpecProduct(spec[0]);
		List NEW=mallProductList.listSpecProduct(spec[1]);
		List BEST=mallProductList.listSpecProduct(spec[2]);
		Hashtable mallht=mallProductList.getHt();
		ModelAndView mav=new ModelAndView("mall.jsp");
		mav.addObject("cateList", cateList);
		mav.addObject("spec", spec);
		mav.addObject("uppath", uppath);
		mav.addObject("HIT", HIT);
		mav.addObject("NEW", NEW);
		mav.addObject("BEST", BEST);
		return mav; 
	}
	
	@RequestMapping(value = "/mall_prodview.do", method = RequestMethod.GET)
	public ModelAndView mall_ProdView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List cateList=cateDAO.listCate();
		String cate=request.getParameter("cate");
		String spec=request.getParameter("pspec");
		String key=null;
		int pnum=ServletRequestUtils.getIntParameter(request, "pnum");
		String uppath=request.getServletContext().getRealPath("/img");
		if(cate==null){
			key=spec;
		}else{
			key=cate;
		}
		ProductDTO dto= mallProductList.searchProduct(key, pnum);
		ModelAndView mav=new ModelAndView("/WEB-INF/myshop/mall/mall_prodview.jsp");
		mav.addObject("key", key);
		mav.addObject("dto", dto);
		mav.addObject("uppath", uppath);
		mav.addObject("cateList", cateList);
		return mav; 
	}
	
	@RequestMapping(value = "/mall_cgprodlist.do", method = RequestMethod.GET)
	public ModelAndView mall_Cgprodlist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cate=request.getParameter("cate");
		String name=cateDAO.searchName(cate);	
		String uppath=request.getServletContext().getRealPath("/img");
		List list= mallProductList.listCateProduct(cate);
		ModelAndView mav=new ModelAndView("/WEB-INF/myshop/mall/mall_cgprodlist.jsp");
		mav.addObject("list", list);
		mav.addObject("uppath", uppath);
		mav.addObject("cname", name);
		mav.addObject("cate",cate);
		List cateList=cateDAO.listCate();
		mav.addObject("cateList", cateList);
		return mav; 
	}
	
	@RequestMapping(value = "/mall_cartAdd.do", method = RequestMethod.POST)
	public ModelAndView mall_CartAdd(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String key=request.getParameter("key");
		int pnum=ServletRequestUtils.getIntParameter(request, "pnum");
		int qty=ServletRequestUtils.getIntParameter(request, "qty");
		String msg=null;
		String url="mall_cartList.do";
		if(mallCartBean.cartAdd(key, pnum, qty)){
			msg="장바구니 등록 성공!";
		}else{
			msg="장바구니 등록 실패!";
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
	
	@RequestMapping(value = "/mall_cartList.do", method = RequestMethod.GET)
	public ModelAndView mall_CartList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List cateList=cateDAO.listCate();
		int cartTotalPrice = 0;
		int cartTotalPoint = 0;
		List list=new ArrayList();
		Hashtable<String, ProductDTO> hlist = mallCartBean.listCart();
		if (hlist == null || hlist.size()==0){
			
		}else{
			Enumeration<String> enu = hlist.keys();
			while(enu.hasMoreElements()){
			String pnum = enu.nextElement();
			ProductDTO dto = hlist.get(pnum);
			list.add(dto);
			int qty = dto.getPqty();
			cartTotalPrice += dto.getPrice()*qty;
			cartTotalPoint += dto.getPoint()*qty;
			}
		}
		ModelAndView mav=new ModelAndView("WEB-INF/myshop/mall/mall_cartList.jsp");
		mav.addObject("uppath", request.getServletContext().getRealPath("/img"));
		mav.addObject("cateList", cateList);
		mav.addObject("list",list);
		mav.addObject("cartTotalPrice", cartTotalPrice);
		mav.addObject("cartTotalPoint", cartTotalPoint);
		return mav;
	}
	
	@RequestMapping(value = "/mall_cartEdit.do", method = RequestMethod.POST)
	public ModelAndView mall_CartEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pnum=ServletRequestUtils.getIntParameter(request, "pnum");
		int qty=ServletRequestUtils.getIntParameter(request, "pqty");
		String msg=null;
		String url="mall_cartList.do";
		if(mallCartBean.cartEdit(pnum, qty)){
			msg="수량 수정 성공!";
		}else{
			msg="수량 수정 실패!";
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
	
	@RequestMapping(value = "/mall_cartDel.do", method = RequestMethod.GET)
	public ModelAndView mall_CartDel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pnum=ServletRequestUtils.getIntParameter(request, "pnum");
		String msg=null;
		String url="mall_cartList.do";
		if(mallCartBean.cartDelete(pnum)){
			msg="장바구니 삭제 성공!";
		}else{
			msg="장바구니 삭제 실패!";
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("message.jsp");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}
	
	@RequestMapping(value = "/mall_order.do", method = RequestMethod.GET)
	public ModelAndView mall_CartOrder1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List cateList=cateDAO.listCate();
		int cartTotalPrice = 0;
		int cartTotalPoint = 0;
		List list=new ArrayList();
		Hashtable<String, ProductDTO> hlist = mallCartBean.listCart();
		if (hlist == null || hlist.size()==0){
			
		}else{
			Enumeration<String> enu = hlist.keys();
			while(enu.hasMoreElements()){
			String pnum = enu.nextElement();
			ProductDTO dto = hlist.get(pnum);
			list.add(dto);
			int qty = dto.getPqty();
			cartTotalPrice += dto.getPrice()*qty;
			cartTotalPoint += dto.getPoint()*qty;
			}
		}
		ModelAndView mav=new ModelAndView("WEB-INF/myshop/mall/mall_order.jsp");
		mav.addObject("uppath", request.getServletContext().getRealPath("/img"));
		mav.addObject("cateList", cateList);
		mav.addObject("list",list);
		mav.addObject("mode",1);
		mav.addObject("cartTotalPrice", cartTotalPrice);
		mav.addObject("cartTotalPoint", cartTotalPoint);
		return mav;
	}
	
	@RequestMapping(value = "/mall_order.do", method = RequestMethod.POST)
	public ModelAndView mall_CartOrder2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pname=request.getParameter("pname");
		int price=ServletRequestUtils.getIntParameter(request, "price");
		int qty=ServletRequestUtils.getIntParameter(request, "qty");
		int totalprice=price*qty;
		ModelAndView mav=new ModelAndView("WEB-INF/myshop/mall/mall_order.jsp");
		mav.addObject("pname", pname);
		mav.addObject("qty", qty);
		mav.addObject("mode",2);
		mav.addObject("totalprice", totalprice);
		return mav;
	}

}