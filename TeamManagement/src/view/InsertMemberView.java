package view;

import org.apache.commons.lang.StringUtils;

import dao.MemberDAO;
import dao.TeamDAO;
import dto.MemberDTO;
import dto.TeamDTO;

public class InsertMemberView extends AbsView {

	private MemberDAO memberDAO;
	private TeamDAO teamDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

	@Override
	public void show() {
		final String memberName = "���� �̸�";
		String name=getKeyInputString(memberName);
		if(Utils.isEmpty(name, memberName)) return;
		
		if(Utils.isLength(name, memberName, 128)){
			MemberDTO member=new MemberDTO();
			member.setName(name);
			showTeamField(member);
		}
	}
	
	public void showTeamField(MemberDTO member){
		final String teamId="�� ID";
		String id=getKeyInputString(teamId);
		
		if(Utils.isEmpty(id, teamId)) return;
		if(Utils.isNumeric(id, teamId)){
			TeamDTO team=teamDAO.getTeam(Integer.parseInt(id));
			if(team==null){
				msg("::::[" + id + "]�� ���� �������� �ʽ��ϴ�.");
				showTeamField(member);
			}else{
				member.setTeam(team);
				memberDAO.insertMember(member);
				msg("::::[" + team.getName() + "]�� ["+member.getName()+"]�� ����߽��ϴ�.");
			}
		}
	}

}
