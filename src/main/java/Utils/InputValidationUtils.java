package Utils;

public class InputValidationUtils {
    public static boolean isPositiveNumber(String input) {
        return input.matches("\\d+");
    }

    public static boolean isPositiveDouble(String input) {
        return input.matches("\\d+(\\.\\d+)?");
    }

    public static boolean isEnough(int number) {
        final int MIN_AMOUNT = 1;
        return number > MIN_AMOUNT;
    }
}
