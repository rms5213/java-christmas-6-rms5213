package christmas.util;

import java.util.Calendar;

public class CheckCalendar {

    private final Calendar calendar;

    public CheckCalendar(){
        this.calendar = Calendar.getInstance();
        this.calendar.set(Calendar.YEAR, 2023);
        this.calendar.set(Calendar.MONTH, 12);
    }

    public int getDayOfWeek(int inputDate) {
        calendar.set(Calendar.DAY_OF_MONTH, inputDate); // 입력받은 날짜로 설정
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public static boolean isWeekday(int dayOfWeek) {
        return dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY;
    }

    public static boolean isWeekend(int dayOfWeek) {
        return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
    }

    public static boolean isSpecial(int dayOfMonth, int dayOfWeek) {
        return dayOfMonth == 25 || dayOfWeek == Calendar.SUNDAY;
    }

    public static boolean isAfterChristmas(int dayOfMonth) {
        return dayOfMonth > 25 ;
    }
}
