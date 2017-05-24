package swing2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.MemberDAO;
import dao.TeamDAO;
import dto.MemberDTO;
import dto.TeamDTO;
import view.Utils;

public class ManagementFrame extends JFrame implements ActionListener{
	private JLabel jl=new JLabel("선수관리");
	private TextArea ta=new TextArea();
	private MainFrame mainFrame;
	private MemberDAO memberDAO;
	private TeamDAO teamDAO;
	
	public void setTeamDAO(TeamDAO teamDAO) {
		this.teamDAO = teamDAO;
	}
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
	public TextArea getTa() {
		return ta;
	}
	private JPanel jpn=new JPanel();
	private JButton[] jbts=new JButton[4];
	private String[] arr=new String[]{"팀 선택","선수은퇴","선수이적","뒤로가기"};
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
			final String teamId="팀 ID";
			String id=JOptionPane.showInputDialog(teamId);
			if(Utils.isEmpty(id, teamId)) return;
			if(Utils.isNumeric(id, teamId)){
				showMemberList(memberDAO.getMembers(Integer.valueOf(id)));
			}
		}else if(e.getSource()==jbts[1]){
			final String memberID = "선수 ID";
			String id=JOptionPane.showInputDialog(memberID);
			if(Utils.isEmpty(id, memberID)) return;
			if(Utils.isNumeric(id, memberID)){
				MemberDTO member=new MemberDTO();
				member.setId(Integer.parseInt(id));
				if(showMemberField(Integer.parseInt(id))){
					memberDAO.deleteMember(member);
				}
			}
		}else if(e.getSource()==jbts[2]){
			final String memberID = "선수 ID";
			String id=JOptionPane.showInputDialog(memberID);
			if(Utils.isEmpty(id, memberID)) return;
			if(Utils.isNumeric(id, memberID)){
				MemberDTO member=new MemberDTO();
				member.setId(Integer.valueOf(id));
				if(showMemberField2(Integer.valueOf(id))){
					member=memberDAO.getMember(Integer.valueOf(id));
					showTeamField(member);
				}else{
					JOptionPane.showMessageDialog(null,"해당 선수가 존재하지 않습니다 다시 입력해 주세요.");
				}
			}
		}else if(e.getSource()==jbts[3]){
			mainFrame.setVisible(true);
			this.setVisible(false);
		}
	}
	
	protected void showMemberList(List memberList){
		String str=">> 멤버리스트\n"+"팀ID\t팀이름\t선수ID\t선수이름\n";
		for(Iterator it=memberList.iterator();it.hasNext();){
			MemberDTO member=(MemberDTO)it.next();
			str+=member.getTeam().getId()+"\t"+member.getTeam().getName()+"\t"+member.getId()+"\t"+member.getName()+"\n";
		}
		ta.setText(str);
	}
	
	public boolean showMemberField(int id){
		MemberDTO member=memberDAO.getMember(id);
			if(member!=null){
				JOptionPane.showMessageDialog(null, "::::["+member.getName()+"]가 은퇴했습니다.");
				return true;
			}else{
				JOptionPane.showMessageDialog(null,"::::[" + member.getName() + "]은 존재하지 않습니다.");
				return false;
			}
	}
	public boolean showMemberField2(int id){
		MemberDTO member=memberDAO.getMember(id);
			if(member!=null){
				return true;
			}else{
				return false;
			}
	}
	
	public void showTeamField(MemberDTO member){
		final String teamId="이적할 팀 ID";
		String id=JOptionPane.showInputDialog(teamId);
		System.out.println(id);
		if(Utils.isEmpty(id, teamId)) return;
		if(Utils.isNumeric(id, teamId)){
			TeamDTO team=teamDAO.getTeam(Integer.valueOf(id));
			if(team==null){
				JOptionPane.showMessageDialog(null,"::::[" + id + "]의 팀은 존재하지 않습니다.");
				showTeamField(member);
			}else{
				member.setTeam(team);
				memberDAO.updateMember(member);
				JOptionPane.showMessageDialog(null,"::::[" + member.getName() + "]가 ["+team.getName()+"]로 이적했습니다.");
			}
		}
	}
}
