import java.util.ArrayList;
import java.util.Scanner;

// User class to store user details
class User {
  private String username;
  private String password;
  private String location;

  public User(String username, String password, String location) {
    this.username = username;
    this.password = password;
    this.location = location;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getLocation() {
    return location;
  }
}

// Truck class to store truck details
class Truck {
  private String truckId;
  private boolean isAvailable;
  private String currentLocation;

  public Truck(String truckId, String currentLocation) {
    this.truckId = truckId;
    this.isAvailable = true;
    this.currentLocation = currentLocation;
  }

  public String getTruckId() {
    return truckId;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }

  public String getCurrentLocation() {
    return currentLocation;
  }
}

// PickupRequest class to store pickup request details
class PickupRequest {
  private String requestId;
  private User user;
  private Truck truck;
  private String status;

  public PickupRequest(String requestId, User user) {
    this.requestId = requestId;
    this.user = user;
    this.truck = null;
    this.status = "Pending";
  }

  public String getRequestId() {
    return requestId;
  }

  public User getUser() {
    return user;
  }

  public Truck getTruck() {
    return truck;
  }

  public void setTruck(Truck truck) {
    this.truck = truck;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}

// SystemManager class to handle system operations
class SystemManager {
  private ArrayList<User> users;
  private ArrayList<Truck> trucks;
  private ArrayList<PickupRequest> requests;
  private Scanner scanner;

  public SystemManager() {
    users = new ArrayList<>();
    trucks = new ArrayList<>();
    requests = new ArrayList<>();
    scanner = new Scanner(System.in);
  }

  // Add sample data for testing
  public void initializeData() {
    users.add(new User("user1", "pass1", "Location A"));
    users.add(new User("user2", "pass2", "Location B"));
    users.add(new User("user3", "pass3", "Location C"));

    trucks.add(new Truck("T1", "Location A"));
    trucks.add(new Truck("T2", "Location B"));
  }

  // User login
  public User login() {
    System.out.print("Enter username: ");
    String username = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    for (User user : users) {
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
        System.out.println("Login successful!");
        return user;
      }
    }
    System.out.println("Login failed!");
    return null;
  }

  // Display menu and handle user input
  public void displayMenu(User user) {
    while (true) {
      System.out.println("\n1. Request Pickup");
      System.out.println("2. Exit");
      System.out.print("Select option: ");
      int choice = scanner.nextInt();
      scanner.nextLine(); // Clear buffer

      if (choice == 1) {
        requestPickup(user);
      } else if (choice == 2) {
        break;
      } else {
        System.out.println("Invalid option!");
      }
    }
  }

  // Handle pickup request
  private void requestPickup(User user) {
    String requestId = "REQ" + (requests.size() + 1);
    PickupRequest request = new PickupRequest(requestId, user);
    requests.add(request);
    System.out.println("Pickup request " + requestId + " created for location: " + user.getLocation());

    // Allocate truck
    allocateTruck(request);

    // Notify admin and user
    notifyAdmin(request);
    notifyUser(request);
  }

  // Allocate available truck
  private void allocateTruck(PickupRequest request) {
    for (Truck truck : trucks) {
      if (truck.isAvailable() && truck.getCurrentLocation().equals(request.getUser().getLocation())) {
        request.setTruck(truck);
        request.setStatus("Allocated");
        truck.setAvailable(false);
        System.out.println("Truck " + truck.getTruckId() + " allocated to request " + request.getRequestId());
        return;
      }
    }
    System.out.println("No available trucks for request " + request.getRequestId());
    request.setStatus("Waiting");
  }

  // Notify admin
  private void notifyAdmin(PickupRequest request) {
    System.out.println("Admin notified: Request " + request.getRequestId() + " status: " + request.getStatus());
  }

  // Notify user
  private void notifyUser(PickupRequest request) {
    System.out.println("User notified: Request " + request.getRequestId() + " status: " + request.getStatus());
  }

  // Simulate test run
  public void runTests() {
    System.out.println("\n=== Test Run ===");
    // Simulate 5 pickup requests
    for (int i = 1; i <= 5; i++) {
      User user = users.get(i % users.size()); // Cycle through users
      requestPickup(user);
    }

    // Display all requests
    System.out.println("\n=== Request Status ===");
    for (PickupRequest request : requests) {
      System.out.println("Request " + request.getRequestId() + ": Status = " + request.getStatus() +
          ", User = " + request.getUser().getUsername() +
          ", Truck = " + (request.getTruck() != null ? request.getTruck().getTruckId() : "None"));
    }
  }
}

// Main class to run the system
public class WasteCollectionSystem {
  public static void main(String[] args) {
    SystemManager manager = new SystemManager();
    manager.initializeData();

    // Simulate user login
    User user = manager.login();
    if (user != null) {
      manager.displayMenu(user);
    }

    // Run test scenario
    manager.runTests();
  }
}