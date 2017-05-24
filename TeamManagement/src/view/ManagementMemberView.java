package view;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;

import dao.MemberDAO;
import dto.MemberDTO;

public class ManagementMemberView extends AbsViewTemplate {
	
	private MemberDAO memberDAO;
	private DeleteMemberView deleteMemberView;

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void setDeleteMemberView(DeleteMemberView deleteMemberView) {
		this.deleteMemberView = deleteMemberView;
	}

	public void show() {
		final String teamId="�� ID";
		String id=getKeyInputString(teamId);
		if(Utils.isEmpty(id, teamId)) return;
		if(Utils.isNumeric(id, teamId)){
			showMemberList(memberDAO.getMembers(Integer.valueOf(id)));
		}
		msg("Enter�� ��������");
		getEnter();
		super.show();
	}
	
	protected void showMemberList(List memberList){
		System.out.println("*************************************");
		System.out.println(">> �������Ʈ");
		System.out.println("-------------------------------------");
		for(Iterator it=memberList.iterator();it.hasNext();){
			MemberDTO member=(MemberDTO)it.next();
			System.out.println(member.getTeam().getId()+"\t"+member.getTeam().getName()+"\t"+member.getId()+"\t"+member.getName());
		}
	}
	
	@Override
	protected void showMenu() {
		System.out.println("******************");
		System.out.println("");
		System.out.println("1.�ڷ� ����");
		System.out.println("2.��� ����");
		System.out.println("3.��� ����");
		System.out.println("******************");
		System.out.println("��ȣ �Է�(Enter)");
	}

	@Override
	protected int getMaxMenuNumber() {
		return 3;
	}

	@Override
	protected int getMinMenuNumber() {
		return 1;
	}

	@Override
	protected void execute(int number) {
		switch(number){
		case 1:
			return;
		case 2:
			deleteMemberView.show();
			break;
		case 3:
			break;
		}
	}

}
