package swing2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainFrame extends JFrame implements ActionListener{
	private SelectTeamView2 selectTeamView2;
	private InsertMemberView2 insertMemberView2;
	private ManagementFrame managementFrame;

	public void setManagementFrame(ManagementFrame managementFrame) {
		this.managementFrame = managementFrame;
	}
	public void setInsertMemberView2(InsertMemberView2 insertMemberView2) {
		this.insertMemberView2 = insertMemberView2;
	}
	public void setSelectTeamView2(SelectTeamView2 selectTeamView2) {
		this.selectTeamView2 = selectTeamView2;	
	}
	
	private JLabel jl=new JLabel("메인");
	private TextArea ta=new TextArea();
	
	public TextArea getTa() {
		return ta;
	}
	private JPanel jpn=new JPanel();
	private JButton[] jbts=new JButton[4];
	private String[] arr=new String[]{"종료","팀 리스트","팀원추가","팀원관리"};
	public void init(){
		Container con=this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", jl);
		con.add("Center", ta);
		jpn.setLayout(new GridLayout(1, 4));
		for(int i=0;i<jbts.length;i++){
			jbts[i]=new JButton(arr[i]);
			jbts[i].addActionListener(this);
			jpn.add(jbts[i]);
		}
		con.add("South" ,jpn);
	}
	public void start(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public MainFrame(String title){
		super(title);
		init();
		start();
		super.setSize(400, 300);
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		int xpos=(int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos=(int)screen.getHeight()/2-(int)this.getHeight()/2;
		super.setLocation(xpos, ypos);
		super.setResizable(false);
		super.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbts[0]){
			JOptionPane.showMessageDialog(null, "프로그램을 종료합니다.");
			System.exit(0);
		}else if(e.getSource()==jbts[1]){
			selectTeamView2.show(this);
		}else if(e.getSource()==jbts[2]){
			insertMemberView2.show();
		}else if(e.getSource()==jbts[3]){
			managementFrame.setVisible(true);
			this.setVisible(false);
		}
	}
	
	public static void main(String[] args){
		GenericApplicationContext ac=new GenericXmlApplicationContext("appContext.xml");
	}
}
