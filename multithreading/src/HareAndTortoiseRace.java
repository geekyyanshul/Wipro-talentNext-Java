
public class HareAndTortoiseRace {

    static volatile boolean raceWon = false;

    public static void main(String[] args) throws InterruptedException {

        // --- Scenario A: A simple race ---
        System.out.println("--- Starting Scenario A: Simple Race ---");
        System.out.println("Ready... Set... GO!");
        runRace(false, false);
        resetRace();
        Thread.sleep(1000); // Pause between races for clarity

        // --- Scenario B: Race with thread priority ---
        System.out.println("\n--- Starting Scenario B: Race with Priority ---");
        System.out.println("Ready... Set... GO!");
        runRace(true, false);
        resetRace();
        Thread.sleep(1000); // Pause between races for clarity

        // --- Scenario C: Race with the Hare sleeping ---
        System.out.println("\n--- Starting Scenario C: Race with Hare Sleeping ---");
        System.out.println("Ready... Set... GO!");
        runRace(false, true);
    }

    /**
     * Configures and runs a single race.
     * [cite_start]@param setPriority If true, sets high priority for Hare and low for Tortoise[cite: 1].
     * [cite_start]@param hareSleeps If true, makes the Hare sleep mid-race[cite: 1].
     */
    public static void runRace(boolean setPriority, boolean hareSleeps) {
        // Create a Runnable instance for each racer.
      //  [cite_start]// The project allows creating threads by extending Thread or implementing Runnable[cite: 1].
        // Implementing Runnable is often preferred as it allows the class to extend other classes.
        Racer hareRunnable = new Racer(hareSleeps);
        Racer tortoiseRunnable = new Racer(false); // The Tortoise never sleeps.


      //  [cite_start]// Create two threads named 'Hare' and 'Tortoise'[cite: 1].
        Thread hare = new Thread(hareRunnable, "Hare");
        Thread tortoise = new Thread(tortoiseRunnable, "Tortoise");

     //   [cite_start]// Part B: Set thread priorities[cite: 1, 3].
        if (setPriority) {
            System.out.println(">> Setting high priority for the Hare. <<");
      ///      [cite_start]// Use static variables from the Thread class for priority[cite: 5].
            hare.setPriority(Thread.MAX_PRIORITY);
            tortoise.setPriority(Thread.MIN_PRIORITY);
        }

        // Start both threads to begin the race.
        hare.start();
        tortoise.start();

        try {
            // Wait for both threads to finish before starting the next scenario.
            hare.join();
            tortoise.join();
        } catch (InterruptedException e) {
            System.err.println("The race was interrupted.");
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Resets the shared race flag for the next scenario.
     */
    public static void resetRace() {
        raceWon = false;
        System.out.println("--------------------------------------");
    }
}

/**
 * Implements the Runnable interface to define the racer's behavior.
 */
class Racer implements Runnable {

    private final boolean shouldSleep;

    public Racer(boolean shouldSleep) {
        this.shouldSleep = shouldSleep;
    }

    @Override
    public void run() {
       // [cite_start]// The race is 100 meters long, simulated with a for loop[cite: 1].
        for (int distance = 1; distance <= 100; distance++) {

          //  [cite_start]// When one thread wins, the second thread must be stopped[cite: 1].
            // This check ensures the losing thread stops running.
            if (HareAndTortoiseRace.raceWon) {
                break;
            }

            System.out.println(Thread.currentThread().getName() + " has run " + distance + " meters.");

           // [cite_start]// Part C: Make the 'Hare' thread 'sleep'[cite: 1, 6].
         //   [cite_start]// Get the thread's name to check if it's the Hare[cite: 10].
            if (shouldSleep && Thread.currentThread().getName().equals("Hare") && distance == 60) {
                try {
                    System.out.println(">>>> The Hare gets cocky and takes a nap at 60 meters! <<<<");
                 //   [cite_start];// Pause the Hare thread for 1000 milliseconds[cite: 1, 8].
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println("The Hare's nap was interrupted.");
                    Thread.currentThread().interrupt();
                }
            }
        }

        // The first thread to finish the loop wins.
        // This 'if' check prevents the loser from also claiming victory.
        if (!HareAndTortoiseRace.raceWon) {
            HareAndTortoiseRace.raceWon = true;
            System.out.println("******************************************");
            System.out.println("WINNER: " + Thread.currentThread().getName() + " has finished the race!");
            System.out.println("******************************************");
        }
    }
}