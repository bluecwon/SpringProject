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
		final String teamId="팀 ID";
		String id=getKeyInputString(teamId);
		if(Utils.isEmpty(id, teamId)) return;
		if(Utils.isNumeric(id, teamId)){
			showMemberList(memberDAO.getMembers(Integer.valueOf(id)));
		}
		msg("Enter를 누르세요");
		getEnter();
		super.show();
	}
	
	protected void showMemberList(List memberList){
		System.out.println("*************************************");
		System.out.println(">> 멤버리스트");
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
		System.out.println("1.뒤로 가기");
		System.out.println("2.멤버 삭제");
		System.out.println("3.멤버 수정");
		System.out.println("******************");
		System.out.println("번호 입력(Enter)");
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
