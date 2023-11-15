package christmas.Controller;

import christmas.Model.EventProperties;
import christmas.View.InputView;
import christmas.View.OutputView;
import christmas.util.CheckCalendar;
import christmas.Model.Menu;
import christmas.Model.EventChecker;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final EventChecker eventChecker;
    private final Menu menu;

    private final List<String> weekdayDiscountList = Arrays.asList("초코케이크", "아이스크림");
    private final List<String> weekendDiscountList = Arrays.asList("티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타");


    public Controller(InputView inputView, OutputView outputView, Menu menu,EventChecker eventChecker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.menu = menu;
        this.eventChecker = eventChecker;
    }

    public void run() {
        int date = inputView.readDate();
        Map<String, Integer> menuMap = inputView.readMenu();
        int totalPrice = calculateTotalPrice(menuMap);

        beforeApplyBenefit(date, totalPrice, menuMap);

        afterApplyBenefit(date, totalPrice, menuMap);
    }

    private void beforeApplyBenefit(int date, int totalPrice, Map<String, Integer> menuMap) {
        outputView.printInformation(date);
        outputView.printMenu(menuMap);
        outputView.printTotalPrice(totalPrice);
    }

    private void afterApplyBenefit(int date, int totalPrice, Map<String, Integer> menuMap) {
        EventProperties eventProperties = eventChecker.checkDate(date);

        int totalBenefitPrice = calculateBenefit(totalPrice, date, menuMap, eventProperties);
        int expectedPrice = totalPrice - totalBenefitPrice;

        outputView.printBenefitMenu(totalPrice);
        outputView.printTotalBenefitPrice(totalBenefitPrice, totalPrice);
        outputView.printPriceAfterDiscount(expectedPrice);
        outputView.printBadge(totalBenefitPrice);

    }


    private int calculateTotalPrice(Map<String, Integer> menuMap) {
        int totalPrice = 0;

        for (Map.Entry<String, Integer> entry : menuMap.entrySet()) {
            String menuName = entry.getKey();
            int count = entry.getValue();
            int menuPrice = menu.getPrice(menuName);
            totalPrice += menuPrice * count;
        }

        return totalPrice;
    }



    private int dDayDiscount(int date, EventProperties eventProperties) {
        if (eventProperties.isAfterChristmas()) return 0;
        return 1000 + (date - 1) * 100;
    }

    private int weekDiscount(Map<String, Integer> menuMap, EventProperties eventProperties) {
        int discount = 0;
        for (Map.Entry<String, Integer> entry : menuMap.entrySet()) {
            String menu = entry.getKey();
            int count = entry.getValue();

            if ((eventProperties.isWeekday() && weekdayDiscountList.contains(menu)) || (eventProperties.isWeekend() && weekendDiscountList.contains(menu))) {
                discount += count * 2023;
            }
        }
        return discount;
    }

    private int specialDiscount(EventProperties eventProperties) {
        if (eventProperties.isSpecial()) return 1000;
        return 0;
    }

    private void printBenefitList(int dDay, int week, int special, int totalPrice) {
        outputView.printBenefitList(dDay, week, special, totalPrice);
    }

    private int calculateBenefit(int totalPrice, int date, Map<String, Integer> menuMap, EventProperties eventProperties) {
        int benefitPrice = 0;
        if (totalPrice < 10000) printBenefitList(0, 0, 0, 0);
        if (totalPrice >= 10000) {
            int dDay = dDayDiscount(date, eventProperties);
            int week = weekDiscount(menuMap, eventProperties);
            int special = specialDiscount(eventProperties);
            benefitPrice += dDay;
            benefitPrice += week;
            benefitPrice += special;
            printBenefitList(dDay, week, special, totalPrice);
        }
        return benefitPrice;
    }

}
