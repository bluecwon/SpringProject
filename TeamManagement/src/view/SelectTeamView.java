package view;

import java.util.Iterator;
import java.util.List;

import dao.TeamDAO;
import dto.TeamDTO;
import swing.MainFrame;

public class SelectTeamView extends AbsView {
	
	private TeamDAO teamDAO;
	private MainFrame mainFrame;
	
	public void setTeamDAO(TeamDAO teamDAO){
		this.teamDAO=teamDAO;
	}
	
	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void show() {
		showTeamList(teamDAO.getTeamList());
		msg("Enter�� ��������");
		getEnter();
	}
	
	protected void showTeamList(List teamList){
		String str=">> ������Ʈ\n"+"��ID\t\t\t����\n";
		for(Iterator it=teamList.iterator();it.hasNext();){
			TeamDTO team=(TeamDTO)it.next();
			str+=team.getId()+"\t\t\t"+team.getName()+"\n";
		}
		mainFrame.getTa().setText(str);
	}

}
