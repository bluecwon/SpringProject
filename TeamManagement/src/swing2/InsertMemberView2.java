package swing2;

import javax.swing.JOptionPane;

import dao.MemberDAO;
import dao.TeamDAO;
import dto.MemberDTO;
import dto.TeamDTO;

public class InsertMemberView2 {

	private MemberDAO memberDAO;
	private TeamDAO teamDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}

	public void show() {
		final String memberName = "���� �̸�";
		String name=JOptionPane.showInputDialog(memberName);
		if(Utils.isEmpty(name, memberName)) return;
		if(Utils.isLength(name, memberName, 128)){
			MemberDTO member=new MemberDTO();
			member.setName(name);
			showTeamField(member);
		}
	}
	
	public void showTeamField(MemberDTO member){
		final String teamId="�� ID";
		String id=JOptionPane.showInputDialog(teamId);
		
		if(Utils.isEmpty(id, teamId)) return;
		if(Utils.isNumeric(id, teamId)){
			TeamDTO team=teamDAO.getTeam(Integer.parseInt(id));
			if(team==null){
				JOptionPane.showMessageDialog(null, "::::[" + id + "]�� ���� �������� �ʽ��ϴ�.");
				showTeamField(member);
			}else{
				member.setTeam(team);
				memberDAO.insertMember(member);
				JOptionPane.showMessageDialog(null,"::::[" + team.getName() + "]�� ["+member.getName()+"]�� ����߽��ϴ�.");
			}
		}
	}

}
