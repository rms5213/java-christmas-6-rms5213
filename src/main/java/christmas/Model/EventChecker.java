package christmas.Model;

import christmas.util.CheckCalendar;

public class EventChecker {
    private final CheckCalendar checkCalendar;

    public EventChecker(CheckCalendar checkCalendar) {
        this.checkCalendar = checkCalendar;
    }

    public EventProperties checkDate(int date) {
        int dayOfWeek = checkCalendar.getDayOfWeek(date);
        boolean isWeekday = checkCalendar.isWeekday(dayOfWeek);
        boolean isWeekend = checkCalendar.isWeekend(dayOfWeek);
        boolean isSpecial = checkCalendar.isSpecial(date, dayOfWeek);
        boolean isAfterChristmas = checkCalendar.isAfterChristmas(date);

        return new EventProperties(isWeekday, isWeekend, isSpecial, isAfterChristmas);
    }
}
