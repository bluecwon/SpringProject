package cate.dao;

import java.util.List;

import cate.dto.CateDTO;
import ibatis.ShopMapper;

public class CateDAOImpl implements CateDAO{
	
	@Override
	public List listCate() {
		return ShopMapper.listCate();
	}

	@Override
	public int inputCate(CateDTO dto) {
		return ShopMapper.inputCate(dto);
	}

	@Override
	public int deleteCate(int cnum) {
		return ShopMapper.deleteCate(cnum);
	}

	@Override
	public String searchName(String code) {
		CateDTO dto=ShopMapper.searchCname(code);
		return dto.getCname();
	}	
}
