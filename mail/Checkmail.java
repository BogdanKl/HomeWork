import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Checkmail {
	public static boolean checkmail(String str){
		String name = "[a-z][a-z[0-9]\u005F\u002E\u002D]*[a-z||0-9]";
		String adress = "([a-z]){2,4}";	
		//�\u002E� � �\u005F� - ��� ������� ����� � �������������
		Pattern p = Pattern.compile(name + "@" + name + "\u002E" + adress);
		Matcher m = p.matcher(str);
		boolean flag = m.matches();
		return (flag);
	}

}
