import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class Ride implements RideInterface {
    private String rideName;
    private int duration;
    private Employee operator;
    private Queue<Visitor> visitorQueue;
    public LinkedList<Visitor> rideHistory;
    private int maxRider;
    private int numOfCycles;
    private final ReentrantLock lock = new ReentrantLock();

    // Default constructor
    public Ride() {

    }

    public Ride(String rideName, int duration, Employee operator) {
        this.rideName = rideName;
        this.duration = duration;
        this.operator = operator;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.maxRider = 1;  // Default value
        this.numOfCycles = 0;
    }

    // Getters and Setters
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public void assignOperator(Employee operator) {
        this.operator = operator;
    }
    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }


    @Override
    public void addVisitorToQueue(Visitor visitor) {
        lock.lock();
        try {
            visitorQueue.add(visitor);
            System.out.println(visitor.getName() + " has been added to the queue for " + rideName + ".");
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        lock.lock();
        try {
            if (visitorQueue.remove(visitor)) {
                System.out.println(visitor.getName() + " has been removed from the queue for " + rideName + ".");
            } else {
                System.out.println(visitor.getName() + " is not in the queue for " + rideName + ".");
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void printQueue() {
        lock.lock();
        try {
            System.out.println("Queue for " + rideName + ":");
            if (visitorQueue.isEmpty()) {
                System.out.println("No visitors in the queue.");
            } else {
                for (Visitor visitor : visitorQueue) {
                    System.out.println(visitor.getName() + " (Age: " + visitor.getAge() + ", Address: " + visitor.getAddress() + ")");
                }
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void runOneCycle() {
        lock.lock();
        try {
            if (operator == null) {
                System.out.println("No operator assigned. Cannot run the ride.");
                return;
            }

            if (visitorQueue.isEmpty()) {
                System.out.println("No visitors in the queue for " + rideName + ".");
                return;
            }

            numOfCycles++;
            int riders = 0;
            while (riders < maxRider && !visitorQueue.isEmpty()) {
                Visitor visitor = visitorQueue.poll();
                addVisitorToCollection(visitor);
                System.out.println(visitor.getName() + " is taking the ride " + rideName + ".");
                riders++;
            }
        } finally {
            lock.unlock();
        }
    }

    public void addVisitorToCollection(Visitor visitor) {
        lock.lock();
        try {
            rideHistory.add(visitor);
            System.out.println(visitor.getName() + " has been added to the ride history.");
        } finally {
            lock.unlock();
        }
    }


    @Override
    public void printRideHistory() {
        lock.lock();
        try {
            System.out.println("Ride history for " + rideName + ":");
            if (rideHistory.isEmpty()) {
                System.out.println("No visitors have taken the ride yet.");
            } else {
                for (Visitor visitor : rideHistory) {
                    System.out.println(visitor.getName() + " (Age: " + visitor.getAge() + ", Address: " + visitor.getAddress() + ")");
                }
            }
        } finally {
            lock.unlock();
        }
    }
    // Method to check if a Visitor is in the collection
    public boolean isVisitorInCollection(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    // Method to get the number of Visitors in the collection
    public int getNumberOfVisitorsInCollection() {
        return rideHistory.size();
    }
    // Method to sort the ride history
    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Ride history has been sorted.");
    }

    // export data
    public void exportVisitorsToFile(String filename) {
        lock.lock();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getAddress() + "," + visitor.getVisitorId() + "," + visitor.getTicketType());
                writer.newLine();
            }
            System.out.println("Visitor details have been successfully written to the file: " + filename);
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        } finally {
            lock.unlock();
        }
    }
    // Import ride history from a file
    public void importVisitorsFromFile(String filename) {
        lock.lock();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String address = parts[2];
                    String visitorId = parts[3];
                    String ticketType = parts[4];
                    Visitor visitor = new Visitor(name, age, address, visitorId, ticketType);
                    addVisitorToCollection(visitor);
                } else {
                    System.err.println("Invalid data format: " + line);
                }
            }
            System.out.println("Visitor details have been successfully imported from the file: " + filename);
        } catch (IOException e) {
            System.err.println("An error occurred while reading from the file: " + e.getMessage());
        } finally {
            lock.unlock();
        }
    }
}
