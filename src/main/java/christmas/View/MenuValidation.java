package christmas.View;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuValidation {

    private static final String MENU_PATTERN = "([가-힣a-zA-Z0-9]+)-([1-9][0-9]*)";
    private static final Pattern pattern = Pattern.compile(MENU_PATTERN);

    public Map<String, Integer> validateMenuInput(String input) {
        Map<String, Integer> menuMap = new HashMap<>();
        System.out.println("Valid?");
        String[] orders = input.split(",");
        for (String order : orders) {
            if (isValidFormat(order)) {
                String[] menuAndCount = order.split("-");
                String menu = menuAndCount[0];
                int count = Integer.parseInt(menuAndCount[1]);

                // 메뉴 이름과 주문 개수의 형식 검사
                if (isValidMenu(menu) && isValidCount(count)) {
                    menuMap.put(menu, count);
                } else {
                    printErrorMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                    return null; // 에러가 발생하면 null 반환
                }
            } else {
                printErrorMessage("[ERROR] 유효하지 않은 주문 형식입니다. 다시 입력해 주세요.");
                return null; // 에러가 발생하면 null 반환
            }
        }
        return menuMap;
    }


    private boolean isValidFormat(String input) {
        Matcher matcher = pattern.matcher(input);
        System.out.println("input : " + input);
        return matcher.matches();
    }

    private boolean isValidMenu(String menu) {
        // 실제 메뉴가 있는지 확인하는 로직 추가
        return true;
    }

    private boolean isValidCount(int count) {
        return count > 0;
    }

    private void printErrorMessage(String message) {
        System.out.println(message);
    }
}
