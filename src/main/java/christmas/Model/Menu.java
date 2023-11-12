package christmas.Model;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final Map<String, Integer> menuPrices;

    public Menu() {
        menuPrices = new HashMap<>();
        initializeMenu();
    }

    private void initializeMenu() {
        // 애피타이저
        menuPrices.put("양송이수프", 6000);
        menuPrices.put("타파스", 5500);
        menuPrices.put("시저샐러드", 8000);

        // 메인
        menuPrices.put("티본스테이크", 55000);
        menuPrices.put("바비큐립", 54000);
        menuPrices.put("해산물파스타", 35000);
        menuPrices.put("크리스마스파스타", 25000);

        // 디저트
        menuPrices.put("초코케이크", 15000);
        menuPrices.put("아이스크림", 5000);

        // 음료
        menuPrices.put("제로콜라", 3000);
        menuPrices.put("레드와인", 60000);
        menuPrices.put("샴페인", 25000);
    }

    public int getPrice(String menu) {
        return menuPrices.getOrDefault(menu, 0);
    }
}
