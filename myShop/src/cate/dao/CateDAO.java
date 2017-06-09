package cate.dao;

import java.util.List;

import cate.dto.CateDTO;

public interface CateDAO {
	public List listCate();
	public int inputCate(CateDTO dto);
	public int deleteCate(int cnum);
	public String searchName(String code);
}
