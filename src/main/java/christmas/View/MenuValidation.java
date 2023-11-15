package christmas.View;

import christmas.Model.Menu;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuValidation {

    private static final String MENU_PATTERN = "([가-힣]+)-([1-9][0-9]*)";
    private static final Pattern pattern = Pattern.compile(MENU_PATTERN);

    private static final int NONE = 0;
    private static final int MAX_ORDER = 20;
    private final Menu menu;
    boolean isOrderCorrect = false;


    List<String> drinkMenuList = Arrays.asList("제로콜라", "레드와인", "샴페인"); //enum화 필요


    public MenuValidation(Menu menu) {
        this.menu = menu;
    }

    public Map<String, Integer> validateMenuInput(String input) {
        Map<String, Integer> menuMap = new HashMap<>();
        Set<String> uniqueMenus = new HashSet<>(); // 중복 체크를 위한 Set
        String[] orders = input.split(",");
        int totalOrder = 0;
        for (String order : orders) {
            if (isValidFormat(order)) {
                String[] menuAndCount = order.split("-");
                String menu = menuAndCount[0];
                int count = Integer.parseInt(menuAndCount[1]);

                if (!uniqueMenus.add(menu)) {
                    printErrorMessage("[ERROR] 중복된 메뉴가 있습니다. 다시 입력해 주세요.");
                    return null;
                }

                // 메뉴 이름과 주문 개수의 형식 검사
                if (isValidMenu(menu) && isValidCount(count) && isValidOrder(menu)) {
                    menuMap.put(menu, count);
                    totalOrder += count;
                    if (isExceedMax(totalOrder)) {
                        printErrorMessage("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요.");
                        return null;
                    }
                } else {
                    printErrorMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                    return null;
                }

            } else {
                printErrorMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                return null;
            }
        }
        return menuMap;
    }


    private boolean isValidFormat(String input) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private boolean isValidMenu(String menu) {
        return menu != null && this.menu.getPrice(menu) > 0;
    }

    private boolean isValidCount(int count) {
        return count > NONE;
    }

    private void printErrorMessage(String message) {
        System.out.println(message);
    }

    private boolean isExceedMax(int totalCount) {
        return totalCount > MAX_ORDER;
    }

    public boolean isValidOrder(String menu) {
        if (!isDrink(menu)) {
            isOrderCorrect = true;
        }
        return isOrderCorrect;
    }

    private boolean isDrink(String menu) {
        return drinkMenuList.contains(menu);
    }

}
