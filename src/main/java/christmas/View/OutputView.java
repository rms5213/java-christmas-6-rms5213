package christmas.View;

import java.util.*;

public class OutputView {
    private static final String OUTPUT_INFORMATION_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDERED_MENU = "\n<주문 메뉴>";
    private static final String MENU_COUNT = "%s %d개\n";

    private static final String TOTAL_PRICE = "\n<할인 전 총주문 금액>";
    private static final String GIFT_MENU = "\n<증정 메뉴>";
    private static final String EVENT_GIFT = "샴페인 1개";

    private static final String BENEFIT_LIST = "\n<혜택 내역>";

    private static final String GIFT_EVENT = "증정 이벤트: ";
    private static final String CHRISTMAS_DAY_DISCOUNT = "크리스마스 디데이 할인: ";
    private static final String WEEKDAY_DISCOUNT = "평일 할인: ";
    private static final String WEEKEND_DISCOUNT = "주말 할인: ";
    private static final String SPECIAL_DISCOUNT = "특별 할인: ";
    private static final String DOESNT_EXIST = "없음";


    private static final String TOTAL_BENEFIT_PRICE = "\n<총혜택 금액>";
    private static final String PRICE_AFTER_DISCOUNT = "\n<할인 후 예상 결제 금액>";
    private static final String EVENT_BADGE = "\n<12월 이벤트 배지>";

    private static final int CHAMPAGNE_PRICE = 25000;
    private static final int STAR_BADGE_PRICE = 5000;
    private static final int TREE_BADGE_PRICE = 10000;
    private static final int SANTA_BADGE_PRICE = 20000;
    private static final int GIFT_STANDARD = 120000;

    private static final String STAR = "별";
    private static final String TREE = "트리";
    private static final String SANTA = "산타";

    public void printInformation(int date) {
        System.out.printf(OUTPUT_INFORMATION_MESSAGE,date);
    }

    public void printMenu(Map<String, Integer> menuMap) {
        System.out.println(ORDERED_MENU);
        for (Map.Entry<String, Integer> entry : menuMap.entrySet()) {
            String menu = entry.getKey();
            int count = entry.getValue();
            System.out.printf(MENU_COUNT, menu, count);
        }
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println(TOTAL_PRICE);
        printPriceFormat(totalPrice);
    }

    public void printBenefitMenu(int totalPrice) {
        System.out.println(GIFT_MENU);
        if(totalPrice < GIFT_STANDARD) doesntExist();
        if(totalPrice >= GIFT_STANDARD) System.out.println(EVENT_GIFT);
    }

    public void printBenefitList(int dDay, int week, int special, int totalPrice) {
        int result = dDay + week + special;
        System.out.println(BENEFIT_LIST);
        if(result == 0){
            if(totalPrice < GIFT_STANDARD) doesntExist();
            if(totalPrice >= GIFT_STANDARD ) {
                System.out.print(GIFT_EVENT);
                printPriceFormat(-CHAMPAGNE_PRICE);
            }
        }
        if(result != 0){
            if(dDay != 0) {
                System.out.print(CHRISTMAS_DAY_DISCOUNT);
                printPriceFormat(-dDay);
            }
            if(week != 0) {
                System.out.print(WEEKDAY_DISCOUNT);
                printPriceFormat(-week);
            }
            if(special != 0) {
                System.out.print(SPECIAL_DISCOUNT);
                printPriceFormat(-special);
            }
            if(totalPrice >= GIFT_STANDARD) {
                System.out.print(GIFT_EVENT);
                printPriceFormat(-CHAMPAGNE_PRICE);            }
        }
    }

    public void printTotalBenefitPrice(int benefitPrice, int totalPrice) {
        if(totalPrice >= GIFT_STANDARD) benefitPrice += CHAMPAGNE_PRICE;
        System.out.println(TOTAL_BENEFIT_PRICE);
        printPriceFormat(-benefitPrice);
    }

    public void printPriceAfterDiscount(int priceAfterDiscount) {
        System.out.println(PRICE_AFTER_DISCOUNT);
        printPriceFormat(priceAfterDiscount);
    }

    public void printBadge(int totalBenefitPrice) {
        System.out.println(EVENT_BADGE);
        if(totalBenefitPrice < STAR_BADGE_PRICE) doesntExist();
        if(STAR_BADGE_PRICE <= totalBenefitPrice && totalBenefitPrice < TREE_BADGE_PRICE)
            System.out.println(STAR);
        if(TREE_BADGE_PRICE <= totalBenefitPrice && totalBenefitPrice < SANTA_BADGE_PRICE)
            System.out.println(TREE);
        if(SANTA_BADGE_PRICE <= totalBenefitPrice)
            System.out.println(SANTA);
    }
    public void doesntExist(){
        System.out.println(DOESNT_EXIST);
    }

    public void printPriceFormat(int price){
        System.out.println(String.format("%,d", price) + "원");
    }
}