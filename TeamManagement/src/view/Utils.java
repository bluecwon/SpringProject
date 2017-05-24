package view;

import org.apache.commons.lang.StringUtils;

public class Utils {
	public static boolean isEmpty(String str,String field){
		if(StringUtils.isEmpty(str)){
			System.out.println(field+"�� ���� �Է��� �ּ���");
			return true;
		}
		return false;
	}
	
	public static boolean isNumeric(String str,String field){
		if(StringUtils.isNumeric(str)){
			return true;
		}
		System.out.println(field+"�� ���ڷ� �Է����ּ���");
		return false;
	}
	
	public static boolean isLength(String name,String field, int length){//length�� �ִ밪
		if(name==null)return false;
		if(length<name.length()){
			System.out.println(field+"��"+length+"���� ���Ϸ� �Է��� �ּ���");
			return false;
		}
		return true;
	}
}
