package Utils;

public class TextFormatUtils {
    public static String getCorrectFormOfWord(double price) {
        String result = "рубл";
        int roundedPriceLastDigits = (int) Math.floor(price) % 100;

        if (roundedPriceLastDigits >= 11 && roundedPriceLastDigits <= 14) {
            result += "ей";
        } else {
            roundedPriceLastDigits %= 10;

            if (roundedPriceLastDigits == 1) {
                result += "ь";
            } else if (roundedPriceLastDigits >= 2 && roundedPriceLastDigits <= 4) {
                result += "я";
            } else {
                result += "ей";
            }
        }

        return result;
    }
}