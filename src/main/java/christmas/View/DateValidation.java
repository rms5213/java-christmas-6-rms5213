package christmas.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class DateValidation {
    private static final String DATE_PATTERN = "([1-9]|[12][0-9]|3[01])";
    private static final Pattern PATTERN = Pattern.compile(DATE_PATTERN);

    public boolean isValidDate(String input) {
        boolean isValid = isValidFormat(input) && isValidRange(input);
        if(!isValid) System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        return isValid;
    }

    private boolean isValidFormat(String input) {
        Matcher matcher = PATTERN.matcher(input);
        return matcher.matches();
    }

    private boolean isValidRange(String input) {
        int date = Integer.parseInt(input);
        return date >= 1 && date <= 31;
    }
}
