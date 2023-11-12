package christmas.util;

import java.util.Calendar;

public class CheckCalendar {

    private final Calendar calendar;
    private static final int DEFAULT_YEAR = 2023;
    private static final int DEFAULT_MONTH = 12;

    public CheckCalendar(){
        this.calendar = Calendar.getInstance();
        this.calendar.set(Calendar.YEAR, DEFAULT_YEAR);
        this.calendar.set(Calendar.MONTH, DEFAULT_MONTH);
    }

    public int getDayOfWeek(int inputDate) {
        calendar.set(Calendar.DAY_OF_MONTH, inputDate); // 입력받은 날짜로 설정
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    public boolean isWeekday(int dayOfWeek) {
        return dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY;
    }

    public boolean isWeekend(int dayOfWeek) {
        return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
    }

    public boolean isSpecial(int dayOfMonth, int dayOfWeek) {
        return dayOfMonth == 25 || dayOfWeek == Calendar.SUNDAY;
    }

    public boolean isAfterChristmas(int dayOfMonth) {
        return dayOfMonth > 25 ;
    }
}
