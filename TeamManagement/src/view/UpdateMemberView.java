package view;

import dao.MemberDAO;
import dao.TeamDAO;
import dto.MemberDTO;
import dto.TeamDTO;

public class UpdateMemberView extends AbsView {
	private MemberDAO memberDAO;
	private TeamDAO teamDAO;
	
	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

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
			member.setId(Integer.valueOf(id));
			if(showMemberField(Integer.valueOf(id))){
				member=memberDAO.getMember(Integer.valueOf(id));
				showTeamField(member);
			}else{
				msg("�ش� ������ �������� �ʽ��ϴ� �ٽ� �Է��� �ּ���.");
				show();
			}
		}
	}
	
	public boolean showMemberField(int id){
		MemberDTO member=memberDAO.getMember(id);
			if(member!=null){
				return true;
			}else{
				return false;
			}
	}
	
	public void showTeamField(MemberDTO member){
		final String teamId="������ �� ID";
		String id=getKeyInputString(teamId);
		System.out.println(id);
		if(Utils.isEmpty(id, teamId)) return;
		if(Utils.isNumeric(id, teamId)){
			TeamDTO team=teamDAO.getTeam(Integer.valueOf(id));
			if(team==null){
				msg("::::[" + id + "]�� ���� �������� �ʽ��ϴ�.");
				showTeamField(member);
			}else{
				member.setTeam(team);
				memberDAO.updateMember(member);
				msg("::::[" + team.getName() + "]�� ["+member.getName()+"]�� �����߽��ϴ�.");
			}
		}
	}
}
