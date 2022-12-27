package Utils;

public class TextFormatUtils {
    public static String getCorrectFormOfWord(double price) {
        StringBuilder result = new StringBuilder("рубл");

        int roundedPriceLastDigits = (int) Math.floor(price) % 100;

        if (roundedPriceLastDigits >= 11 && roundedPriceLastDigits <= 14) {
            result.append("ей");
        } else {
            roundedPriceLastDigits %= 10;

            if (roundedPriceLastDigits == 1) {
                result.append("ь");
            } else if (roundedPriceLastDigits >= 2 && roundedPriceLastDigits <= 4) {
                result.append("я");
            } else {
                result.append("ей");
            }
        }

        return result.toString();
    }
}