package view;

import dao.MemberDAO;
import dto.MemberDTO;

public class DeleteMemberView extends AbsView {
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public void show() {
		final String memberID = "���� ID";
		String id=getKeyInputString(memberID);
		if(Utils.isEmpty(id, memberID)) return;
		if(Utils.isNumeric(id, memberID)){
			MemberDTO member=new MemberDTO();
			member.setId(Integer.parseInt(id));
			if(showMemberField(Integer.parseInt(id))){
				memberDAO.deleteMember(member);
			}
		}
	}
	
	public boolean showMemberField(int id){
		MemberDTO member=memberDAO.getMember(id);
			if(member!=null){
				msg("::::["+member.getName()+"]�� �����߽��ϴ�.");
				return true;
			}else{
				msg("::::[" + member.getName() + "]�� �������� �ʽ��ϴ�.");
				return false;
			}
	}
}
