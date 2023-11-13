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
    boolean isWeekday;
    boolean isWeekend;
    boolean isSpecial;
    boolean isAfterChristmas;
    private final Menu menu;

    private Map<String, Integer> menuMap;
    boolean gift = false;

    public Controller(InputView inputView, OutputView outputView, CheckCalendar checkCalendar, Menu menu) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.checkCalendar = checkCalendar;
        this.menu = menu;
    }

    public void run() {
        int date = inputView.readDate();
        checkDate(date);
        menuMap = inputView.readMenu();
        printInformation(date);
        printMenu(menuMap);
        int totalPrice = calculateTotalPrice(menuMap);
        printTotalPrice(totalPrice);

        int totalBenefitPrice = 0;
        totalBenefitPrice += dDayDiscount(date);
        totalBenefitPrice += weekDiscount();
        totalBenefitPrice += specialDiscount();

        printGiftOrNot(totalPrice);
        //혜택 내역
        printBenefitList(dDayDiscount(date), weekDiscount(), specialDiscount());
        int expectedPrice = totalPrice - totalBenefitPrice;


        printTotalBenefitPrice(totalBenefitPrice);
        printPriceAfterDiscount(expectedPrice);

        printEventBadge(expectedPrice);
        //증정이벤트
        //배지

    }



    private void checkDate(int date) {
        int dayOfWeek = checkCalendar.getDayOfWeek(date);
        isWeekday = checkCalendar.isWeekday(dayOfWeek);
        isWeekend = checkCalendar.isWeekend(dayOfWeek);
        isSpecial = checkCalendar.isSpecial(date, dayOfWeek);
        isAfterChristmas = checkCalendar.isAfterChristmas(date);
    }

    private void printInformation(int date) {
        outputView.printInformation(date);
    }

    private int calculateTotalPrice(Map<String, Integer> menuMap) {
        int totalPrice = 0;

        for (Map.Entry<String, Integer> entry : menuMap.entrySet()) {
            String menuName = entry.getKey();
            int count = entry.getValue();
            int menuPrice = menu.getPrice(menuName); // 수정된 부분

            totalPrice += menuPrice * count;
        }

        return totalPrice;
    }

    private void printMenu(Map<String, Integer> menu) {
        outputView.printMenu(menu);
    }

    private void printTotalPrice(int totalPrice) {
        outputView.printTotalPrice(totalPrice);
    }

    private int dDayDiscount(int date) {
        if (isAfterChristmas) return 0;
        return 1000 + (date - 1) * 100;
    }

    private int weekDiscount() {
        int discount = 0;
        if (isWeekday) {
            for (Map.Entry<String, Integer> entry : menuMap.entrySet()) {
                String menu = entry.getKey();
                int count = entry.getValue();
                if(menu.equals("초코케이크") || menu.equals("아이스크림")){
                    discount += count * 2023;
                }
            }
        }

        if (isWeekend) {
            for (Map.Entry<String, Integer> entry : menuMap.entrySet()) {
                String menu = entry.getKey();
                int count = entry.getValue();
                if(menu.equals("티본스테이크") || menu.equals("바비큐립") ||
                        menu.equals("해산물파스타") || menu.equals("크리스마스파스타")){
                    discount += count * 2023;
                }
            }
        }
        return discount;
    }

    private int specialDiscount() {
        if(isSpecial) return 1000;
        return 0;
    }
    private void printGiftOrNot(int totalPrice){
        if(totalPrice >= 120000) gift = true;
        outputView.printBenefitMenu(gift);
    }

    private void printBenefitList(int dDay, int week, int special){
        outputView.printBenefitList(dDay, week, special, gift);
    }
    private void printTotalBenefitPrice(int totalBenefitPrice){
        outputView.printTotalBenefitPrice(totalBenefitPrice, gift);
    }
    private void printPriceAfterDiscount(int expectedPrice){
        outputView.printPriceAfterDiscount(expectedPrice);
    }

    private void printEventBadge(int totalBenefitPrice){
        outputView.printBadge(totalBenefitPrice);
    }




}
