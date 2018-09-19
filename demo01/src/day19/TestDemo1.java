package day19;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.Date;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class TestDemo1 {
    public static void main(String[] args) {
        System.out.println("Math.round(-2.5) = " + Math.round(-2.5));

        Date now = new Date();

        DateFormat df = DateFormat.getDateInstance();
        String format = df.format(now);
//        2018年9月3日
        System.out.println(format);

        DateFormat df2 = DateFormat.getDateTimeInstance();
//        2018年9月3日 下午7:08:14
        String format2 = df2.format(now);
        System.out.println(format2);

        //2018年09月03日  周一
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日  E");
        String format3 = sf.format(now);
        System.out.println(format3);
    }

    @Test
    public void test1(){
        DateTimeFormatter sf = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);

        // format
        LocalDate today = LocalDate.now();
        String str = sf.format(today);
        //2018年9月1日
        System.out.println(str);

        // parse
        TemporalAccessor parse = sf.parse("2018年9月12日");
        System.out.println("parse = " + parse.get(ChronoField.DAY_OF_WEEK));
    }
}
