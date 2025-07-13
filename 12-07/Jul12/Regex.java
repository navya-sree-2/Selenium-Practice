package Jul12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String phn = "1234567891";
		Pattern p1 = Pattern.compile("^[0-9]{10}$");
		Matcher	m1 = p1.matcher(phn);
		if(m1.find()) {
			System.out.println("matched");
		}
		else {
			System.out.println("not matched");
		}
		
		String mail = "abcdef123@gmail.com";
		Pattern p2 = Pattern.compile("^[a-z0-9]*+@gmail.com");
		Matcher m2 = p2.matcher(mail);
		if(m2.find()) {
			System.out.println("matched");
		}
		else {
			System.out.println("not matched");
		}
	}

}
