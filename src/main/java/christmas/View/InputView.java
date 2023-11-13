package christmas.View;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;
import christmas.View.MenuValidation;


public class InputView {
    private static final String MENU_PATTERN = "([가-힣a-zA-Z0-9]+)-([1-9][0-9]*)";
    private static final Pattern PATTERN = Pattern.compile(MENU_PATTERN);
    private final MenuValidation menuValidation;
    private final DateValidation dateValidation;

    public InputView(MenuValidation menuValidation, DateValidation dateValidation) {
        this.menuValidation = menuValidation;
        this.dateValidation = dateValidation;
    }

    public int readDate() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");

        String input = Console.readLine();

        // 날짜 유효성 검증
        while (!dateValidation.isValidDate(input)) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            input = Console.readLine();
        }

        int date = Integer.parseInt(input);
        return date;
    }

    public Map<String, Integer> readMenu() {
        System.out.print("주문하실 메뉴를 메뉴와 개수를 알려 주세요. ");
        System.out.println("e.g. 해산물파스타-2,레드와인-1,타파스-1,제로콜라-1");
        String input = Console.readLine();
        while(true){
            Map <String, Integer > menuMap = menuValidation.validateMenuInput(input);
            if(menuMap != null && !menuMap.isEmpty())
                return menuMap;
            input = Console.readLine();
        }
    }
}