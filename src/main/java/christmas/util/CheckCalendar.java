package christmas.util;

import java.util.Calendar;

public class CheckCalendar {

    private final Calendar calendar;
    private static final int DEFAULT_YEAR = 2023;
    private static final int DEFAULT_MONTH = Calendar.DECEMBER;
    private static final int CHRISTMAS = 25;

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
        return dayOfWeek >= Calendar.SUNDAY && dayOfWeek <= Calendar.THURSDAY;
    }

    public boolean isWeekend(int dayOfWeek) {
        return dayOfWeek == Calendar.FRIDAY || dayOfWeek == Calendar.SATURDAY;
    }

    public boolean isSpecial(int dayOfMonth, int dayOfWeek) {
        return dayOfMonth == CHRISTMAS || dayOfWeek == Calendar.SUNDAY; // 상수화
    }

    public boolean isAfterChristmas(int dayOfMonth) {
        return dayOfMonth > CHRISTMAS ;
    }
}
