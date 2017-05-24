package view;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import swing.MainFrame;

public abstract class AbsViewTemplate extends AbsView{

	@Override
	public void show() {
		showMenu();
	}
	
	protected boolean isValidNumber(String str){
		if(StringUtils.isBlank(str)){//str의 값이 공백이냐?
			return false;
		}
		if(StringUtils.isNumeric(str)){//str의 값이 숫자이냐?
			int number=NumberUtils.toInt(str); //문자열을 숫자로 바꿔주기
			if(getMinMenuNumber()<=number&&number<=getMaxMenuNumber()){
				return true;
			}
		}
		return false;
	}
	
	abstract protected void showMenu();
	abstract protected int getMaxMenuNumber();
	abstract protected int getMinMenuNumber();
	abstract protected void execute(int number);
}
