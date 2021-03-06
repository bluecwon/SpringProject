package swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ManagementFrame extends JFrame implements ActionListener{
	int commandNum=0;
	boolean comOk=true;
	private JLabel jl=new JLabel("선수관리");
	private TextArea ta=new TextArea();
	
	public TextArea getTa() {
		return ta;
	}
	private JPanel jpn=new JPanel();
	private JButton[] jbts=new JButton[3];
	private String[] arr=new String[]{"뒤로가기","선수은퇴","선수이적"};
	public void init(){
		Container con=this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North", jl);
		con.add("Center", ta);
		jpn.setLayout(new GridLayout(1, 3));
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
	public ManagementFrame(String title){
		super(title);
		init();
		start();
		super.setSize(400, 300);
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		int xpos=(int)screen.getWidth()/2-(int)this.getWidth()/2;
		int ypos=(int)screen.getHeight()/2-(int)this.getHeight()/2;
		super.setLocation(xpos, ypos);
		super.setResizable(false);
		super.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbts[0]){
			commandNum=1;
		}else if(e.getSource()==jbts[1]){
			commandNum=2;
		}else if(e.getSource()==jbts[2]){
			commandNum=3;
		}
		comOk=false;
	}
	
	public int getCommandNum() {
		int num=0;
		while(true){
			System.out.println("확인");
			if(!comOk){
				num=commandNum;
				commandNum=0;
				comOk=true;
				return num;
			}
		}
	}
	
}
