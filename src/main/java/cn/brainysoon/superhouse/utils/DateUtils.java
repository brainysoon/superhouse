package cn.brainysoon.superhouse.utils;


import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by brainy on 17-2-22.
 */
public class DateUtils {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private static final int[] DAYS_OF_MONTH = new int[]{
            0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    private static DateUtils dateUtils = new DateUtils();

    private DateUtils() {

    }

    public static DateUtils getInstances() {

        return dateUtils;
    }

    public boolean isDateDepress(Date date, Integer usefullife) {

        try {

            int usefulDays = countDays(date.toString());

            int nowDays = countDays(sdf.format(new java.util.Date()));

            return usefulDays + usefullife - nowDays <= 0;

        } catch (Exception ex) {

            ex.printStackTrace();

            return false;
        }
    }

    /**
     * @param date 格式必须为 xxxx-xx-xx
     * @return
     */
    int countDays(String date) {

        String[] dates = date.split("-");

        int year = Integer.valueOf(dates[0]);
        int month = Integer.valueOf(dates[1]) + 1;
        int day = Integer.valueOf(dates[2]);

        int days = 0;

        //闰年
        if (year % 4 == 0 && year % 400 != 0 && month >= 2) {

            days++;
        }

        for (int i = 1; i < month; i++) {

            days += DAYS_OF_MONTH[i];
        }

        days += day;

        for (int i = 1; i < year; i++) {

            if (year % 4 == 0 && year % 400 != 0) {

                days += 366;
            } else {

                days += 365;
            }
        }

        return days;
    }
}
