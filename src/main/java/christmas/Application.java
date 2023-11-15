package christmas;

import christmas.Model.EventChecker;
import christmas.View.DateValidation;
import christmas.View.InputView;
import christmas.View.OutputView;
import christmas.View.MenuValidation;
import christmas.util.CheckCalendar;
import christmas.Model.Menu;
import christmas.Controller.Controller;


public class Application {

    public static void main(String[] args) {
        Menu menu = new Menu();
        MenuValidation menuValidation = new MenuValidation(menu);
        DateValidation dateValidation = new DateValidation();
        InputView inputView = new InputView(menuValidation,dateValidation);
        OutputView outputView = new OutputView();
        CheckCalendar checkCalendar = new CheckCalendar();
        EventChecker eventChecker = new EventChecker(checkCalendar);
        Controller controller = new Controller(inputView, outputView, menu, eventChecker);
        controller.run();
    }
}
