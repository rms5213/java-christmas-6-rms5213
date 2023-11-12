package christmas.View;
import java.util.*;
public class OutputView {

    public void printInformation(int date){
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public void printMenu() {
        System.out.println("<주문 메뉴>");
    }

    public void printTotalPrice(int totalPrice){
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(String.format("%,d", totalPrice) + "원");
    }

    public void printBenefitMenu(){
        System.out.println("<증정 메뉴>");
    }

    public void printBenefitList(){
        System.out.println("<혜택 내역>");
    }

    public void printTotalBenefitPrice(int benefitPrice){
        System.out.println("<총혜택 금액>");
        System.out.println(String.format("%,d", benefitPrice) + "원");
    }
    public void printPriceAfterDiscount(int priceAfterDisCount){
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(String.format("%,d", priceAfterDisCount) + "원");
    }

    public void printBadge(){
        System.out.println("<12월 이벤트 배지>");
    }

}