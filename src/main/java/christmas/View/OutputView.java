package christmas.View;

import java.util.*;

public class OutputView {

    public void printInformation(int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public void printMenu(Map<String, Integer> menuMap) {
        System.out.println("<주문 메뉴>");
        for (Map.Entry<String, Integer> entry : menuMap.entrySet()) {
            String menu = entry.getKey();
            int count = entry.getValue();
            System.out.println(menu + " " + count + "개");
        }
    }

    public void printTotalPrice(int totalPrice) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(String.format("%,d", totalPrice) + "원");
    }

    public void printBenefitMenu(boolean present) {
        System.out.println("<증정 메뉴>");
        if(!present) doesntExist();
        if(present) System.out.println("샴페인 1개");
    }

    public void printBenefitList(int dDay, int week, int special, boolean gift) {
        int result = dDay + week + special;
        System.out.println("<혜택 내역>");
        if(result == 0 && !gift) doesntExist();
        if(result != 0){
            if(dDay != 0) {
                System.out.print("크리스마스 디데이 할인: ");
                System.out.println(String.format("%,d", (-1) * dDay) + "원");
            }
            if(week != 0) {
                System.out.print("평일 할인: ");
                System.out.println(String.format("%,d", (-1) * week) + "원");
            }
            if(special != 0) {
                System.out.print("특별 할인: ");
                System.out.println(String.format("%,d", (-1) * special) + "원");
            }
            if(gift) {
                System.out.print("증정 이벤트: ");
                System.out.println(String.format("%,d", -25000) + "원");
            }
        }


    }

    public void printTotalBenefitPrice(int benefitPrice, boolean gift) {
        if(gift) benefitPrice += 25000;
        System.out.println("<총혜택 금액>");
        System.out.println(String.format("%,d", (-1) * benefitPrice) + "원");
    }

    public void printPriceAfterDiscount(int priceAfterDisCount) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(String.format("%,d", priceAfterDisCount) + "원");
    }

    public void printBadge(int totalBenefitPrice) {
        System.out.println("<12월 이벤트 배지>");
        if(totalBenefitPrice < 5000) doesntExist();
        if(5000 <= totalBenefitPrice && totalBenefitPrice < 10000)
            System.out.println("별");
        if(10000 <= totalBenefitPrice && totalBenefitPrice < 20000)
            System.out.println("트리");
        if(20000 <= totalBenefitPrice)
            System.out.println("산타");
    }

    public void doesntExist(){
        System.out.println("없음");
    }

}