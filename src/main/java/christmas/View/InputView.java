package christmas.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readDate() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        int date = Integer.parseInt(input);
        //datevalidator 추후 변경

        return date;
    }

    public String readMenu() {
        System.out.print("주문하실 메뉴를 메뉴와 개수를 알려 주세요. ");
        System.out.println("e.g. 해산물파스타-2,레드와인-1,타파스-1,제로콜라-1");
        String input = Console.readLine();
        //메뉴를 어떻게 받을 것인가?

        return input;
    }
}