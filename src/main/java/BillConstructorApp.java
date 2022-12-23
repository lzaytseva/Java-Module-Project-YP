import Utils.InputValidationUtils;
import Utils.TextFormatUtils;

import java.util.Scanner;

public class BillConstructorApp {

    Scanner scanner = new Scanner(System.in);
    BillConstructor constructor;

    void run() {
        createBillConstructor();
        addItemsToBC();
        showBCItems();
        showPersonalTotal();
    }

    private void createBillConstructor() {
        constructor = new BillConstructor(getNumberOfGuests());
    }

    private int getNumberOfGuests() {
        int numberOfGuests;
        String error = "Введите число больше 1";

        System.out.println("На сколько человек необходимо разделить счёт?");

        while (true) {
            String input = scanner.nextLine();

            if (InputValidationUtils.isPositiveNumber(input)) {
                numberOfGuests = Integer.parseInt(input);
                if (InputValidationUtils.isEnough(numberOfGuests)) {
                    break;
                } else {
                    System.out.println(error);
                }
            }
            else {
                System.out.println(error);
            }
        }

        return numberOfGuests;
    }


    private void addItemsToBC() {
        System.out.println("Теперь добавляем товары :)");

        do {
            System.out.println("Введите название:");
            String name = setName();

            System.out.println("Введите цену в формате \"рубли.копейки:\"");
            double price = setPrice();

            constructor.addItem(name, price);
            System.out.println("Товар успешно добавлен!\n");

            System.out.println("Желаете добавить еще товар? Если нет, то напишите \"завершить\". Для продолжения введите любой символ");
        } while (!isInputCompleted());
    }

    private String setName() {
        return scanner.nextLine();
    }

    private double setPrice() {
        double price;

        while (true) {
            String input = scanner.nextLine();
            if (InputValidationUtils.isPositiveDouble(input)) {
                price = Double.parseDouble(input);
                break;
            } else {
                System.out.println("Некорректная цена, попробуйте еще раз.");
            }
        }

        return price;
    }

    private boolean isInputCompleted() {
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("завершить");
    }

    private void showBCItems() {
        if (constructor.hasItems()) {
            System.out.println("Добавленные товары:");
            constructor.showItems();
        } else {
            System.out.println("А тут пусто :(");
        }
    }

    private void showPersonalTotal() {
        double total = constructor.getPersonalTotal();
        String result = String.format("%.2f %s\n", total, TextFormatUtils.getCorrectFormOfWord(total));

        System.out.println("\nСумма к оплате с человека:");
        System.out.println(result);
    }

}
