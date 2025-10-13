import java.util.Scanner;

/**
 * Main class to launch the video rental inventory system.
 */
public class project2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VideoStore store = new VideoStore();

        while (true) {
            System.out.println("\nMAIN MENU");
            System.out.println("==========");
            System.out.println("1. Add Videos");
            System.out.println("2. Check Out Video");
            System.out.println("3. Return Video");
            System.out.println("4. Receive Rating");
            System.out.println("5. List Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1..6): ");

            int choice;
            // Input validation for menu choice
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
                continue;
            }
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the video you want to add: ");
                    store.addVideo(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter the name of the video you want to check out: ");
                    store.doCheckout(scanner.nextLine());
                    break;
                case 3:
                    System.out.print("Enter the name of the video you want to Return: ");
                    store.doReturn(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Enter the name of the video you want to Rate: ");
                    String nameToRate = scanner.nextLine();
                    System.out.print("Enter the rating for this video: ");
                    int rating = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    store.receiveRating(nameToRate, rating);
                    break;
                case 5:
                    store.listInventory();
                    break;
                case 6:
                    System.out.println("Exiting...!! Thanks for using the application.");
                    scanner.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }
    }
}

/**
 * Represents the video store's inventory and operations.
 */
class VideoStore {
    Video[] store;
    private int videoCount;

    public VideoStore() {
        // Set a maximum capacity for the store
        this.store = new Video[20];
        this.videoCount = 0;
    }

    public void addVideo(String name) {
        if (videoCount < store.length) {
            store[videoCount] = new Video(name);
            videoCount++;
            System.out.println("Video \"" + name + "\" added successfully.");
        } else {
            System.out.println("The store is full, cannot add more videos.");
        }
    }

    public void doCheckout(String name) {
        Video video = findVideo(name);
        if (video != null) {
            if (!video.getCheckout()) {
                video.doCheckout();
                System.out.println("Video \"" + name + "\" checked out successfully.");
            } else {
                System.out.println("Video \"" + name + "\" is already checked out.");
            }
        } else {
            System.out.println("Video \"" + name + "\" not found in the inventory.");
        }
    }

    public void doReturn(String name) {
        Video video = findVideo(name);
        if (video != null) {
            if (video.getCheckout()) {
                video.doReturn();
                System.out.println("Video \"" + name + "\" returned successfully.");
            } else {
                System.out.println("Video \"" + name + "\" is already in the store.");
            }
        } else {
            System.out.println("Video \"" + name + "\" not found in the inventory.");
        }
    }

    public void receiveRating(String name, int rating) {
        Video video = findVideo(name);
        if (video != null) {
            video.receiveRating(rating);
            System.out.println("Rating \"" + rating + "\" has been mapped to the Video \"" + name + "\".");
        } else {
            System.out.println("Video \"" + name + "\" not found in the inventory.");
        }
    }

    public void listInventory() {
        if (videoCount == 0) {
            System.out.println("The inventory is empty.");
            return;
        }
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-20s | %-15s | %-10s\n", "Video Name", "Checkout Status", "Rating");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < videoCount; i++) {
            if (store[i] != null) {
                System.out.printf("%-20s | %-15s | %-10d\n", store[i].getName(), store[i].getCheckout(), store[i].getRating());
            }
        }
        System.out.println("---------------------------------------------------------");
    }

    private Video findVideo(String name) {
        for (int i = 0; i < videoCount; i++) {
            if (store[i] != null && store[i].getName().equalsIgnoreCase(name)) {
                return store[i];
            }
        }
        return null;
    }
}

/**
 * Represents a single video with its properties.
 */
class Video {
    String videoName;
    boolean checkout;
    int rating;

    public Video(String name) {
        this.videoName = name;
        this.checkout = false;
        this.rating = 0;
    }

    public String getName() {
        return videoName;
    }

    public void doCheckout() {
        this.checkout = true;
    }

    public void doReturn() {
        this.checkout = false;
    }

    public void receiveRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public boolean getCheckout() {
        return checkout;
    }
}