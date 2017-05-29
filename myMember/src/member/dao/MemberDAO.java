package member.dao;

import java.util.List;

import member.dto.MemberDTO;

public interface MemberDAO {
	public boolean memberLogin(String id,String passwd);
	public boolean checkMember(String name,String ssn1,String ssn2);
	public int insertMember(MemberDTO dto);
	public MemberDTO selectMember(String id);
	public List listMember();
	public String findId(String name,String ssn1,String ssn2);
	public String findPw(MemberDTO dto);
	public int deleteMember(int num);
	public int updateMember(MemberDTO dto);
	public boolean checkPW(int num,String passwd);
}
