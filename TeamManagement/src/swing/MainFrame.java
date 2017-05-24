package swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ActionListener{
	int commandNum=0;
	boolean comOk=true;
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
			commandNum=1;
		}else if(e.getSource()==jbts[1]){
			commandNum=2;
		}else if(e.getSource()==jbts[2]){
			commandNum=3;
		}else if(e.getSource()==jbts[3]){
			commandNum=4;
		}
		comOk=false;
	}
	
	public int getCommandNum() {
		int num=0;
		
		while(true){
			System.out.println("g");
			if(!comOk){
				num=commandNum;
				commandNum=0;
				comOk=true;
				return num;
			}
		}
	}
	
}
