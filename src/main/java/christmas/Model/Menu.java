package christmas.Model;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    public enum Category {
        APPETIZER,
        MAIN,
        DESSERT,
        DRINK
    }

    public enum MenuItem {
        //애피타이저
        MUSHROOM_SOUP("양송이수프", 6000, Category.APPETIZER),
        TAPAS("타파스", 5500, Category.APPETIZER),
        CAESAR_SALAD("시저샐러드", 8000, Category.APPETIZER),

        //메인
        T_BONE_STEAK("티본스테이크", 55000, Category.MAIN),
        BBQ_RIB("바비큐립", 54000, Category.MAIN),
        SEAFOOD_PASTA("해산물파스타", 35000, Category.MAIN),
        CHRISTMAS_PASTA("크리스마스파스타", 25000, Category.MAIN),

        //디저트
        CHOCO_CAKE("초코케이크", 15000, Category.DESSERT),
        ICE_CREAM("아이스크림", 5000, Category.DESSERT),

        //음료
        ZERO_COKE("제로콜라", 3000, Category.DRINK),
        RED_WINE("레드와인", 60000, Category.DRINK),
        CHAMPAGNE("샴페인", 25000, Category.DRINK);

        private final String name;
        private final int price;
        private final Category category;

        MenuItem(String name, int price, Category category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        public Category getCategory() {
            return category;
        }
    }

    private final Map<String, MenuItem> menuMap;

    public Menu() {
        menuMap = new HashMap<>();
        initializeMenu();
    }

    private void initializeMenu() {
        for (MenuItem item : MenuItem.values()) {
            menuMap.put(item.getName(), item);
        }
    }

    public int getPrice(String menu) {
        MenuItem menuItem = menuMap.get(menu);
        if (menuItem == null) return 0;
        return menuItem.getPrice();
    }
    public Category getCategory(String menu) {
        MenuItem menuItem = menuMap.get(menu);
        if (menuItem == null) return null;
        return menuItem.getCategory();
    }

}
