package swing2;

import javax.swing.JOptionPane;

import org.apache.commons.lang.StringUtils;

public class Utils {
	public static boolean isEmpty(String str,String field){
		if(StringUtils.isEmpty(str)){
			JOptionPane.showMessageDialog(null,field+"를 입력해주세요");
			return true;
		}
		return false;
	}
	
	public static boolean isNumeric(String str,String field){
		if(StringUtils.isNumeric(str)){
			return true;
		}
		JOptionPane.showMessageDialog(null,field+"는 숫자로 입력해주세요");
		return false;
	}
	
	public static boolean isLength(String name,String field, int length){//length는 최대값
		if(name==null)return false;
		if(length<name.length()){
			JOptionPane.showMessageDialog(null,field+"는"+length+"문자 이하로 입력해 주세요");
			return false;
		}
		return true;
	}
}
