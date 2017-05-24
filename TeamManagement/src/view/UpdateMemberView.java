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
		final String memberID = "선수 ID";
		String id=getKeyInputString(memberID);
		if(Utils.isEmpty(id, memberID)) return;
		if(Utils.isNumeric(id, memberID)){
			MemberDTO member=new MemberDTO();
			member.setId(Integer.valueOf(id));
			if(showMemberField(Integer.valueOf(id))){
				member=memberDAO.getMember(Integer.valueOf(id));
				showTeamField(member);
			}else{
				msg("해당 선수가 존재하지 않습니다 다시 입력해 주세요.");
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
		final String teamId="이적할 팀 ID";
		String id=getKeyInputString(teamId);
		System.out.println(id);
		if(Utils.isEmpty(id, teamId)) return;
		if(Utils.isNumeric(id, teamId)){
			TeamDTO team=teamDAO.getTeam(Integer.valueOf(id));
			if(team==null){
				msg("::::[" + id + "]의 팀은 존재하지 않습니다.");
				showTeamField(member);
			}else{
				member.setTeam(team);
				memberDAO.updateMember(member);
				msg("::::[" + team.getName() + "]에 ["+member.getName()+"]을 이적했습니다.");
			}
		}
	}
}
