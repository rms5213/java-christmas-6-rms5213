package christmas.Controller;

import christmas.View.InputView;
import christmas.View.OutputView;
import christmas.util.CheckCalendar;
import christmas.Model.Menu;

import java.util.Map;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final CheckCalendar checkCalendar;
    private final Menu menu;
    private Map<String, Integer> menuMap;


    public Controller(InputView inputView, OutputView outputView, CheckCalendar checkCalendar, Menu menu) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.checkCalendar = checkCalendar;
        this.menu = menu;
    }

    public void run() {
        int date = inputView.readDate();
        checkDate(date);
        printInformation(date);
        menuMap = inputView.readMenu();
        checkMenu(menuMap);
        printMenu(menuMap);
        System.out.println("주문한 메뉴: " + menuMap);
        int totalValue = calculateTotalValue(menuMap);
        printTotalValue(totalValue);

        System.out.println(totalValue);

        //메뉴확인
        //디데이할인
        //평일/주말할인
        //특별할인
        //증정이벤트
        //배지

    }


    private void checkDate(int date) {
        int dayOfWeek = checkCalendar.getDayOfWeek(date);
        boolean isWeekday = checkCalendar.isWeekday(dayOfWeek);
        boolean isWeekend = checkCalendar.isWeekend(dayOfWeek);
        boolean isSpecial = checkCalendar.isSpecial(date, dayOfWeek);
        boolean isAfterChristmas = checkCalendar.isAfterChristmas(date);
    }

    private void printInformation(int date) {
        outputView.printInformation(date);
    }

    private int calculateTotalValue(Map<String, Integer> menuMap) {
        int totalValue = 0;

        for (Map.Entry<String, Integer> entry : menuMap.entrySet()) {
            String menuName = entry.getKey();
            int count = entry.getValue();
            int menuPrice = menu.getPrice(menuName); // 수정된 부분

            totalValue += menuPrice * count;
        }

        return totalValue;


    }

    private void checkMenu(Map<String, Integer> menu) {


    }

    private void printMenu(Map<String, Integer> menu) {
    }

    private void printTotalValue(int totalValue){
        outputView.printTotalPrice(totalValue);
    }
}
