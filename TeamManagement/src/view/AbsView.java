package view;

import java.util.Scanner;

import javax.swing.JOptionPane;

public abstract class AbsView {
	
	//키보드로 부터 입력을 받기 위한 메소드
	protected String getKeyInputString(String str){
		String input=JOptionPane.showInputDialog(str+"입력");
		return input;
	}
	
	//엔터키를 받기 위한 메소드
	protected String getEnter(){
		Scanner in=new Scanner(System.in);
		return in.nextLine();
	}
	
	//메세지를 출력하기위한 메소드
	protected void msg(String str){
		JOptionPane.showMessageDialog(null, str);
	}
	
	abstract public void show();
}
