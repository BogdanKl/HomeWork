package gui2;


import java.io.*;
import java.net.*;
import java.util.*;

public class Course {
    private static double exchange_rub_dol = 31.20;
    private static double tran(String str)
    {
        int l = str.length();
        int i = 0;
        String s = "";
        while  (Character.isDigit(str.charAt(i)))
        {
            s += str.charAt(i);
            i++;
        }
        i++;
        s += ".";
        while  (i < l && Character.isDigit(str.charAt(i)))
        {
            s += str.charAt(i);
            i++;
        }
        return(Double.valueOf(s));
    }

    @SuppressWarnings("empty-statement")
    public static boolean refresh() throws Exception {
        Calendar c = new GregorianCalendar();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int mоnth = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        mоnth++;
        System.out.println(day+" "+mоnth+" "+ year);
        String date = (day < 10 ? "0" : "") + String.valueOf(day) + "." + (mоnth+1 < 10 ? "0" : "") + String.valueOf(mоnth+1) + "." + String.valueOf(year);
        URL bank = new URL("http://www.cbr.ru/currency_base/D_print.aspx?date_req=" + date);
        BufferedReader br = new BufferedReader(new InputStreamReader(bank.openStream(), "UTF-8"));
        String line;
        while ((line = br.readLine()).indexOf("USD") == -1);
        br.readLine();
        br.readLine();
        line = br.readLine();
        String s;
        s = line.substring(line.indexOf('>') + 1, line.indexOf('<', line.indexOf('>') + 1));
        System.out.println(s);
        Thread.sleep(9000);
        exchange_rub_dol = tran(s);    
        return true;
    }
    public static double getCourse()
    {
        return exchange_rub_dol;
    }
}