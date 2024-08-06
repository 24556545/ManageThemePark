import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private int duration;
    private Employee operator;
    private Queue<Visitor> visitorQueue;
    private LinkedList<Visitor> rideHistory;
    private int maxRider;
    private int numOfCycles;


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
        visitorQueue.add(visitor);
        System.out.println(visitor.getName() + " has been added to the queue for " + rideName + ".");
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (visitorQueue.remove(visitor)) {
            System.out.println("***************"+visitor.getName() + " has been removed from the queue for " + rideName + "********************");
        } else {
            System.out.println(visitor.getName() + " is not in the queue for " + rideName + ".");
        }
    }

    @Override
    public void printQueue() {
       // System.out.println("-----------------Queue for " + rideName + "--------------------------");
        if (visitorQueue.isEmpty()) {
            System.out.println("No visitors in the queue.");
        } else {
            for (Visitor visitor : visitorQueue) {
                System.out.println(visitor.getName() + " (Age: " + visitor.getAge() + ", Address: " + visitor.getAddress() + ")");
            }
        }
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("No ride operator assigned. The ride cannot be run.");
            return;
        }

        if (visitorQueue.isEmpty()) {
            System.out.println("No visitors in the queue. The ride cannot be run.");
            return;
        }

        int count = 0;
        while (count < maxRider && !visitorQueue.isEmpty()) {
            Visitor visitor = visitorQueue.poll();
            addVisitorToCollection(visitor);
            count++;
        }

        numOfCycles++;
        System.out.println("Ride has been run for cycle " + numOfCycles + ".");
    }

    public void addVisitorToCollection(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " has been added to the ride history.");
    }


    @Override
    public void printRideHistory() {
        System.out.println("Ride history for " + rideName + ":");
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have taken the ride yet.");
        } else {
            Iterator<Visitor> iterator = rideHistory.iterator();
            while (iterator.hasNext()) {
                Visitor visitor = iterator.next();
                System.out.println(visitor.getName() + " (Age: " + visitor.getAge() + ", Address: " + visitor.getAddress() + ")");
            }
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

}
