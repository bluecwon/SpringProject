package swing2;

import java.util.Iterator;
import java.util.List;

import dao.TeamDAO;
import dto.TeamDTO;
import swing2.MainFrame;

public class SelectTeamView2 {
	
	private TeamDAO teamDAO;
	
	public void setTeamDAO(TeamDAO teamDAO){
		this.teamDAO=teamDAO;
	}

	public void show(MainFrame mf) {
		showTeamList(mf,teamDAO.getTeamList());
	}
	
	protected void showTeamList(MainFrame mf,List teamList){
		String str=">> ∆¿∏ÆΩ∫∆Æ\n"+"∆¿ID\t\t\t∆¿∏Ì\n";
		for(Iterator it=teamList.iterator();it.hasNext();){
			TeamDTO team=(TeamDTO)it.next();
			str+=team.getId()+"\t\t\t"+team.getName()+"\n";
		}
		mf.getTa().setText(str);
	}

}
