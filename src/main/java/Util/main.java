package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);
        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date.toString());
        System.out.println(date1);
    }
}
