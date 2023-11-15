package christmas.util;

import christmas.Model.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuValidation {

    private static final String ERROR_INVALID_MENU = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";


    private static final String MENU_PATTERN = "([가-힣]+)-([1-9][0-9]*)";
    private static final Pattern pattern = Pattern.compile(MENU_PATTERN);

    private static final int NONE = 0;
    private static final int MAX_ORDER = 20;
    private final Menu menu;
    boolean isOrderCorrect = false;


    public MenuValidation(Menu menu) {
        this.menu = menu;
    }

    public Map<String, Integer> validateMenuInput(String input) {
        Map<String, Integer> menuMap = new HashMap<>();
        Set<String> uniqueMenus = new HashSet<>(); // 중복 체크를 위한 Set
        String[] orders = input.split(",");
        int totalOrder = 0;

        try {
            boolean checkNonDrink = false;
            for (String order : orders) {

                checkException(!isValidFormat(order));

                String[] menuAndCount = order.split("-");
                String menu = menuAndCount[0];
                int count = Integer.parseInt(menuAndCount[1]);


                checkException(!uniqueMenus.add(menu));

                if (isValidOrder(menu)) {
                    checkNonDrink = true;
                }

                checkException(!isValidMenu(menu) || !isValidCount(count));

                menuMap.put(menu, count);
                totalOrder += count;

                checkException(isExceedMax(totalOrder));

            }
            checkException(!checkNonDrink);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_INVALID_MENU);
            return null;
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


    private boolean isExceedMax(int totalCount) {
        return totalCount > MAX_ORDER;
    }

    public boolean isValidOrder(String menu) {
        if (!isDrink(menu)) {
            isOrderCorrect = true;
        }
        return isOrderCorrect;
    }

    private boolean isDrink(String menuName) {
        Menu.Category category = menu.getCategory(menuName);
        return category == Menu.Category.DRINK;
    }


    private void checkException(boolean validation) {
        if (validation) {
            throw new IllegalArgumentException(ERROR_INVALID_MENU);
        }
    }
}
