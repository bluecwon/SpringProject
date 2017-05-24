package view;

import java.util.Iterator;
import java.util.List;

import dao.MemberDAO;
import dto.MemberDTO;
import swing.MainFrame;
import swing.ManagementFrame;

public class ManagementMemberView extends AbsViewTemplate {
	
	private MemberDAO memberDAO;
	private DeleteMemberView deleteMemberView;
	private UpdateMemberView updateMemberView;
	private ManagementFrame managementFrame;
	private MainFrame mainFrame;
	

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public void setManagementFrame(ManagementFrame managementFrame) {
		this.managementFrame = managementFrame;
	}

	public void setUpdateMemberView(UpdateMemberView updateMemberView) {
		this.updateMemberView = updateMemberView;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void setDeleteMemberView(DeleteMemberView deleteMemberView) {
		this.deleteMemberView = deleteMemberView;
	}

	public void show() {
		final String teamId="ÆÀ ID";
		String id=getKeyInputString(teamId);
		if(Utils.isEmpty(id, teamId)) return;
		if(Utils.isNumeric(id, teamId)){
			showMemberList(memberDAO.getMembers(Integer.valueOf(id)));
			managementFrame.setVisible(true);
		}
		super.show();
	}
	
	protected void showMemberList(List memberList){
		String str=">> ¸â¹ö¸®½ºÆ®\n"+"ÆÀID\tÆÀÀÌ¸§\t¼±¼öID\t¼±¼öÀÌ¸§\n";
		for(Iterator it=memberList.iterator();it.hasNext();){
			MemberDTO member=(MemberDTO)it.next();
			str+=member.getTeam().getId()+"\t"+member.getTeam().getName()+"\t"+member.getId()+"\t"+member.getName()+"\n";
		}
		managementFrame.getTa().setText(str);
	}
	
	@Override
	protected void showMenu() {
		int num=managementFrame.getCommandNum();
		System.out.println(num);
		execute(num);
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
			mainFrame.setVisible(true);
			managementFrame.setVisible(false);
			return;
		case 2:
			deleteMemberView.show();
			break;
		case 3:
			updateMemberView.show();
			break;
		}
	}

}
