import java.util.*;

public class BillConstructor {
    private List<Item> items;
    private int numberOfGuests;
    private double total;

    public BillConstructor(int numberOfGuests) {
        this.items = new ArrayList<>();
        this.numberOfGuests = numberOfGuests;
        this.total = 0;
    }

    void addItem(String name, double price) {
        Item item = new Item(name, price);
        items.add(item);
        changeTotal(item);
    }

    boolean hasItems() {
        return !items.isEmpty();
    }

    void showItems() {
        for (Item i: items) {
            System.out.println(i);
        }
    }

    void changeTotal(Item item) {
        total += item.getPrice();
    }

    double getPersonalTotal() {
        return total / numberOfGuests;
    }


}


