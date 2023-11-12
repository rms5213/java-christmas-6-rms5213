package christmas;

import christmas.View.InputView;
import christmas.View.OutputView;
import christmas.util.CheckCalendar;

import christmas.Controller.Controller;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CheckCalendar checkCalendar = new CheckCalendar();

        Controller controller = new Controller(inputView, outputView, checkCalendar);
        controller.run();
    }
}
