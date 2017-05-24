package view;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import swing.MainFrame;
import swing.ManagementFrame;

public class MainView extends AbsViewTemplate {
	
	private SelectTeamView selectTeamView;
	private InsertMemberView insertMemberView;
	private ManagementMemberView managementMemberView;
	private MainFrame mainFrame;

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	public void setSelectTeamView(SelectTeamView selectTeamView) {
		this.selectTeamView = selectTeamView;	
	}

	public void setInsertMemberView(InsertMemberView insertMemberView) {
		this.insertMemberView = insertMemberView;
	}
	
	public void setManagementMemberView(ManagementMemberView managementMemberView) {
		this.managementMemberView = managementMemberView;
	}

	@Override
	protected void showMenu() {
		int num=mainFrame.getCommandNum();
		System.out.println(num);
		execute(num);
	}
	

	@Override
	protected int getMaxMenuNumber() {
		return 4;
	}

	@Override
	protected int getMinMenuNumber() {
		return 1;
		
	}

	@Override
	protected void execute(int number) {
		switch(number){
		case 1:
			msg("프로그램을 종료합니다.");
			System.exit(0);
		case 2:
			selectTeamView.show();
			break;
		case 3:
			insertMemberView.show();
			break;
		case 4:
			managementMemberView.show();
			mainFrame.setVisible(false);
			break;
		}
	}
	
	public static void main(String[] args){
		GenericApplicationContext ac=new GenericXmlApplicationContext("appContext.xml");
		MainView mu=(MainView)ac.getBean("mainView");
		while(true){	
			mu.show();
		}
	}
}
