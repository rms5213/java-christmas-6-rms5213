package christmas.util;

import java.util.Calendar;

public class CheckCalendar {

    public static int getDayOfWeek(int inputDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2023); // 연도 설정
        calendar.set(Calendar.MONTH, Calendar.DECEMBER); // 12월로 설정
        calendar.set(Calendar.DAY_OF_MONTH, inputDate); // 입력받은 날짜로 설정
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static boolean isWeekday(int dayOfWeek) {
        return dayOfWeek == Calendar.MONDAY
                || dayOfWeek == Calendar.TUESDAY
                || dayOfWeek == Calendar.WEDNESDAY
                || dayOfWeek == Calendar.THURSDAY
                || dayOfWeek == Calendar.FRIDAY;
    }

    public static boolean isWeekend(int dayOfWeek) {
        return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
    }

    public static boolean isSpecial(int dayOfMonth) {
        return dayOfMonth == 25 || getDayOfWeek(dayOfMonth) == Calendar.SUNDAY;
    }

    public static boolean isAfterChristmas(int dayOfMonth) {
        return dayOfMonth > 25 ;
    }
}
