package christmas.View;

import java.util.Map;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_INFORMATION_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String RESERVATION_DATE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ORDER_MENU = "주문하실 메뉴를 메뉴와 개수를 알려 주세요.Z";
    private static final String ORDER_EXAMPLE = "(e.g. 해산물파스타-2,레드와인-1,타파스-1,제로콜라-1)";


    private final MenuValidation menuValidation;
    private final DateValidation dateValidation;

    public InputView(MenuValidation menuValidation, DateValidation dateValidation) {
        this.menuValidation = menuValidation;
        this.dateValidation = dateValidation;
    }
    public int readDate() {
        System.out.println(INPUT_INFORMATION_MESSAGE);
        System.out.println(RESERVATION_DATE);

        String input = Console.readLine();
        while (!dateValidation.isValidDate(input)) {
            input = Console.readLine();
        }
        return Integer.parseInt(input);
    }

    public Map<String, Integer> readMenu() {
        System.out.print(ORDER_MENU);
        System.out.println(ORDER_EXAMPLE);
        String input = Console.readLine();
        while(true){
            Map <String, Integer > menuMap = menuValidation.validateMenuInput(input);
            if(menuMap != null && !menuMap.isEmpty())
                return menuMap;
            input = Console.readLine();
        }
    }
}