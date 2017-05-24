package view;

import java.util.Scanner;

import javax.swing.JOptionPane;

public abstract class AbsView {
	
	//Ű����� ���� �Է��� �ޱ� ���� �޼ҵ�
	protected String getKeyInputString(String str){
		String input=JOptionPane.showInputDialog(str+"�Է�");
		return input;
	}
	
	//����Ű�� �ޱ� ���� �޼ҵ�
	protected String getEnter(){
		Scanner in=new Scanner(System.in);
		return in.nextLine();
	}
	
	//�޼����� ����ϱ����� �޼ҵ�
	protected void msg(String str){
		JOptionPane.showMessageDialog(null, str);
	}
	
	abstract public void show();
}
