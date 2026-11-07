import java.io.Serializable;

public class Room implements Serializable {
    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isBooked;
    private String customerName;
    private double foodCharges;

    // Constructor to initialize room details
    public Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isBooked = false;
        this.customerName = "";
        this.foodCharges = 0.0;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getFoodCharges() {
        return foodCharges;
    }

    // Method to book the room
    public void bookRoom(String customerName) {
        this.isBooked = true;
        this.customerName = customerName;
        this.foodCharges = 0.0;
    }

    // Method to add food charges
    public void addFoodOrder(double amount) {
        this.foodCharges += amount;
    }

    // Method to checkout and reset room
    public void checkoutRoom() {
        this.isBooked = false;
        this.customerName = "";
        this.foodCharges = 0.0;
    }
}