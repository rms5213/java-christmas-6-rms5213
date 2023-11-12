package christmas.Controller;

import christmas.View.InputView;
import christmas.View.OutputView;
import christmas.util.CheckCalendar;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final CheckCalendar checkCalendar;

    public Controller(InputView inputView, OutputView outputView, CheckCalendar checkCalendar) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.checkCalendar = checkCalendar;
    }

    public void run() {
        int date = inputView.readDate();

        int dayOfWeek = checkCalendar.getDayOfWeek(date);
        boolean isWeekday = checkCalendar.isWeekday(dayOfWeek);
        boolean isWeekend = checkCalendar.isWeekend(dayOfWeek);
        boolean isSpecial = checkCalendar.isSpecial(date, dayOfWeek);
        boolean isAfterChristmas = checkCalendar.isAfterChristmas(date);

        System.out.println("입력한 날짜: " + date);
        System.out.println("Is Weekday: " + isWeekday);
        System.out.println("Is Weekend: " + isWeekend);
        System.out.println("Is Special: " + isSpecial);
        System.out.println("Is AfterChristmas: " + isAfterChristmas);
    }
}
