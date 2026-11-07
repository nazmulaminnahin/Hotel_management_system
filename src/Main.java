import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelService hotelService = new HotelService();
        boolean running = true;

        System.out.println("=========================================");
        System.out.println("   HOTEL MANAGEMENT SYSTEM WITH DINING   ");
        System.out.println("       Developed by NAZMUL AMIN          ");
        System.out.println("=========================================");

        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. View All Rooms");
            System.out.println("2. Check Available Rooms");
            System.out.println("3. Book a Room");
            System.out.println("4. Order Food");
            System.out.println("5. Checkout Room & Generate Bill");
            System.out.println("6. Exit");
            System.out.print("Please enter your choice (1-6): ");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    hotelService.displayAllRooms();
                    break;

                case 2:
                    hotelService.displayAvailableRooms();
                    break;

                case 3:
                    System.out.print("\nEnter room number to book: ");
                    int roomNum = scanner.nextInt();
                    scanner.nextLine(); // Clear newline
                    System.out.print("Enter guest name: ");
                    String name = scanner.nextLine();
                    hotelService.bookRoom(roomNum, name);
                    break;

                case 4:
                    System.out.print("\nEnter room number for food order: ");
                    int orderRoomNum = scanner.nextInt();
                    hotelService.displayFoodMenu();
                    System.out.print("Enter food item ID to order: ");
                    int foodId = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();
                    hotelService.orderFood(orderRoomNum, foodId, qty);
                    break;

                case 5:
                    System.out.print("\nEnter room number for checkout: ");
                    int checkoutNum = scanner.nextInt();
                    System.out.print("Enter number of nights stayed: ");
                    int nights = scanner.nextInt();
                    hotelService.checkoutRoom(checkoutNum, nights);
                    break;

                case 6:
                    running = false;
                    System.out.println("\nThank you for using the Hotel Management System.");
                    System.out.println("System Developed by NAZMUL AMIN. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select between 1 and 6.");
            }
        }
        scanner.close();
    }
}