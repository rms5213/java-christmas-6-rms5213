package christmas;

import christmas.View.InputView;
import christmas.View.OutputView;
import christmas.View.MenuValidation;
import christmas.util.CheckCalendar;
import christmas.Model.Menu;
import christmas.Controller.Controller;


public class Application {

    public static void main(String[] args) {
        MenuValidation menuValidation = new MenuValidation();
        InputView inputView = new InputView(menuValidation);
        OutputView outputView = new OutputView();
        CheckCalendar checkCalendar = new CheckCalendar();
        Menu menu = new Menu();

        Controller controller = new Controller(inputView, outputView, checkCalendar, menu);
        controller.run();
    }
}
