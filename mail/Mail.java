import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Mail {
	public static void main(String args[]) throws IOException
	{
		String str;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		str = input.readLine();
		System.out.println(Checkmail.checkmail(str));
	}
}
