package christmas.View;

import christmas.Model.Menu;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuValidation {

    private static final String MENU_PATTERN = "([가-힣]+)-([1-9][0-9]*)";
    private static final Pattern pattern = Pattern.compile(MENU_PATTERN);
    private final Menu menu; // 추가된 부분

    public MenuValidation(Menu menu) {
        this.menu = menu;
    }

    public Map<String, Integer> validateMenuInput(String input) {
        Map<String, Integer> menuMap = new HashMap<>();
        String[] orders = input.split(",");
        int totalOrder = 0;
        for (String order : orders) {
            if (isValidFormat(order)) {
                String[] menuAndCount = order.split("-");
                String menu = menuAndCount[0];
                int count = Integer.parseInt(menuAndCount[1]);

                // 메뉴 이름과 주문 개수의 형식 검사
                if (isValidMenu(menu) && isValidCount(count)) {
                    menuMap.put(menu, count);
                    totalOrder += count;
                    if(isExceedMax(totalOrder)){
                        printErrorMessage("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 다시 입력해 주세요.");
                        menuMap = null;
                        break;
                    }
                } else {
                    printErrorMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                    menuMap = null;
                    break;
                }
            } else {
                printErrorMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
                menuMap = null;
                break;
            }
        }
        return menuMap;
    }


    private boolean isValidFormat(String input) {
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private boolean isValidMenu(String menu) {
        return this.menu.isValidMenu(menu);
    }

    private boolean isValidCount(int count) {
        return count > 0;
    }

    private void printErrorMessage(String message) {
        System.out.println(message);
    }

    private boolean isExceedMax(int totalCount) {
        return totalCount > 20;
    }

    private boolean isredundant(int count){

        return true;
    }
}
