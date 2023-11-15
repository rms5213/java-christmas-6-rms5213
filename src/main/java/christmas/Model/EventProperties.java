package christmas.Model;

public class EventProperties {
    private final boolean isWeekday;
    private final boolean isWeekend;
    private final boolean isSpecial;
    private final boolean isAfterChristmas;

    public EventProperties(boolean isWeekday, boolean isWeekend, boolean isSpecial, boolean isAfterChristmas) {
        this.isWeekday = isWeekday;
        this.isWeekend = isWeekend;
        this.isSpecial = isSpecial;
        this.isAfterChristmas = isAfterChristmas;
    }

    public boolean isWeekday() {
        return isWeekday;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public boolean isAfterChristmas() {
        return isAfterChristmas;
    }
}
