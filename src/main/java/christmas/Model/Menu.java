package christmas.Model;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    public enum MenuItem {
        MUSHROOM_SOUP("양송이수프", 6000),
        TAPAS("타파스", 5500),
        CAESAR_SALAD("시저샐러드", 8000),
        T_BONE_STEAK("티본스테이크", 55000),
        BBQ_RIB("바비큐립", 54000),
        SEAFOOD_PASTA("해산물파스타", 35000),
        CHRISTMAS_PASTA("크리스마스파스타", 25000),
        CHOCO_CAKE("초코케이크", 15000),
        ICE_CREAM("아이스크림", 5000),
        ZERO_COLA("제로콜라", 3000),
        RED_WINE("레드와인", 60000),
        CHAMPAGNE("샴페인", 25000);

        private final String name;
        private final int price;

        MenuItem(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
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
        if(menuItem == null) return 0;
        return menuItem.getPrice();
    }

}
