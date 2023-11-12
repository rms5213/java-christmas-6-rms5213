package christmas.Controller;

import christmas.View.InputView;
import christmas.View.OutputView;

import christmas.util.CheckCalendar;

public class Controller {

    public void run(){
        InputView inputView = new InputView();
        int date = inputView.readDate();

        int dayOfWeek = CheckCalendar.getDayOfWeek(date);
        boolean isWeekday = CheckCalendar.isWeekday(dayOfWeek);
        boolean isWeekend = CheckCalendar.isWeekend(dayOfWeek);
        boolean isSpecial = CheckCalendar.isSpecial(date);
        boolean isAfterChristmas =CheckCalendar.isAfterChristmas(date);

        System.out.println("입력한 날짜: " + date);
        System.out.println("Is Weekday: " + isWeekday);
        System.out.println("Is Weekend: " + isWeekend);
        System.out.println("Is Special: " + isSpecial);
        System.out.println("Is AfterChristmas: " + isAfterChristmas);
    }

}
