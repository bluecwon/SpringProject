package view;

import java.util.Iterator;
import java.util.List;

import dao.TeamDAO;
import dto.TeamDTO;

public class SelectTeamView extends AbsView {
	
	private TeamDAO teamDAO;
	
	public void setTeamDAO(TeamDAO teamDAO){
		this.teamDAO=teamDAO;
	}

	@Override
	public void show() {
		showTeamList(teamDAO.getTeamList());
		msg("Enter∏¶ ¥©∏£ººø‰");
		getEnter();
	}
	
	protected void showTeamList(List teamList){
		System.out.println("*******************");
		System.out.println(">> ∆¿∏ÆΩ∫∆Æ");
		System.out.println("-------------------");
		System.out.println("∆¿ID\t\t\t∆¿∏Ì");
		System.out.println("-------------------");
		for(Iterator it=teamList.iterator();it.hasNext();){
			TeamDTO team=(TeamDTO)it.next();
			System.out.println(team.getId()+"\t\t\t"+team.getName());
		}
	}

}
