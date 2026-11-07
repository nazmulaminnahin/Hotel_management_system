import java.util.ArrayList;

public class HotelService {
    private ArrayList<Room> rooms;
    private ArrayList<FoodItem> foodMenu;

    // Constructor to initialize default rooms and food items
    public HotelService() {
        rooms = new ArrayList<>();
        foodMenu = new ArrayList<>();
        initializeData();
    }

    private void initializeData() {
        // Adding hotel rooms
        rooms.add(new Room(101, "Single AC", 2000.0));
        rooms.add(new Room(102, "Single Non-AC", 1200.0));
        rooms.add(new Room(201, "Double AC", 3500.0));
        rooms.add(new Room(202, "Double Non-AC", 2500.0));
        rooms.add(new Room(301, "Deluxe Suite", 6000.0));

        // Adding restaurant food items
        foodMenu.add(new FoodItem(1, "Chicken Biryani", 250.0));
        foodMenu.add(new FoodItem(2, "Fried Rice with Chicken", 300.0));
        foodMenu.add(new FoodItem(3, "Club Sandwich", 180.0));
        foodMenu.add(new FoodItem(4, "Cold Coffee", 120.0));
        foodMenu.add(new FoodItem(5, "Bottled Water", 30.0));
    }

    // Display all rooms status
    public void displayAllRooms() {
        System.out.println("\n--- All Rooms List ---");
        for (Room room : rooms) {
            String status = room.isBooked() ? "Booked by " + room.getCustomerName() : "Available";
            System.out.println("Room: " + room.getRoomNumber() + " | Type: " + room.getRoomType() 
                + " | Price: BDT " + room.getPricePerNight() + " | Status: " + status);
        }
    }

    // Display only available rooms
    public void displayAvailableRooms() {
        System.out.println("\n--- Available Rooms ---");
        boolean found = false;
        for (Room room : rooms) {
            if (!room.isBooked()) {
                System.out.println("Room: " + room.getRoomNumber() + " | Type: " + room.getRoomType() 
                    + " | Price: BDT " + room.getPricePerNight());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Sorry, all rooms are currently booked!");
        }
    }

    // Book a room
    public void bookRoom(int roomNumber, String customerName) {
        Room room = findRoom(roomNumber);
        if (room == null) {
            System.out.println("Error: Room number does not exist.");
        } else if (room.isBooked()) {
            System.out.println("Error: Room is already booked!");
        } else {
            room.bookRoom(customerName);
            System.out.println("Success! Room " + roomNumber + " booked for " + customerName + ".");
        }
    }

    // Display food menu
    public void displayFoodMenu() {
        System.out.println("\n--- Restaurant Food Menu ---");
        for (FoodItem item : foodMenu) {
            System.out.println(item.getItemNumber() + ". " + item.getItemName() + " - BDT " + item.getPrice());
        }
    }

    // Order food for a booked room
    public void orderFood(int roomNumber, int itemNumber, int quantity) {
        Room room = findRoom(roomNumber);
        if (room == null) {
            System.out.println("Error: Room number does not exist.");
            return;
        }
        if (!room.isBooked()) {
            System.out.println("Error: Room is not booked. Only checked-in guests can order food.");
            return;
        }

        FoodItem food = findFoodItem(itemNumber);
        if (food == null) {
            System.out.println("Error: Invalid food item ID.");
            return;
        }
        if (quantity <= 0) {
            System.out.println("Error: Quantity must be at least 1.");
            return;
        }

        double totalCost = food.getPrice() * quantity;
        room.addFoodOrder(totalCost);
        System.out.println("Success! Added " + quantity + "x " + food.getItemName() + " to Room " + roomNumber + "'s bill.");
    }

    // Checkout room and generate invoice
    public void checkoutRoom(int roomNumber, int nights) {
        Room room = findRoom(roomNumber);
        if (room == null) {
            System.out.println("Error: Room number does not exist.");
            return;
        }
        if (!room.isBooked()) {
            System.out.println("Notice: This room is already vacant.");
            return;
        }
        if (nights <= 0) {
            System.out.println("Error: Number of nights must be at least 1.");
            return;
        }

        double roomBill = room.getPricePerNight() * nights;
        double foodBill = room.getFoodCharges();
        double totalBill = roomBill + foodBill;

        System.out.println("\n=========================================");
        System.out.println("           CHECKOUT & BILL INVOICE       ");
        System.out.println("=========================================");
        System.out.println(" Guest Name   : " + room.getCustomerName());
        System.out.println(" Room Number  : " + room.getRoomNumber() + " (" + room.getRoomType() + ")");
        System.out.println(" Stay Duration: " + nights + " Night(s)");
        System.out.println("-----------------------------------------");
        System.out.println(" Room Rent    : BDT " + roomBill);
        System.out.println(" Food Charges : BDT " + foodBill);
        System.out.println("-----------------------------------------");
        System.out.println(" Total Bill   : BDT " + totalBill);
        System.out.println("=========================================");
        System.out.println("   Software Developed by NAZMUL AMIN     ");
        System.out.println("=========================================");

        room.checkoutRoom();
        System.out.println("Success! Room " + roomNumber + " has been checked out.");
    }

    // Helper method to find room
    private Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    // Helper method to find food item
    private FoodItem findFoodItem(int itemNumber) {
        for (FoodItem item : foodMenu) {
            if (item.getItemNumber() == itemNumber) {
                return item;
            }
        }
        return null;
    }
}