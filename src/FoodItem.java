public class FoodItem {
    private int itemNumber;
    private String itemName;
    private double price;

    // Constructor to initialize food item
    public FoodItem(int itemNumber, String itemName, double price) {
        this.itemNumber = itemNumber;
        this.itemName = itemName;
        this.price = price;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }
}