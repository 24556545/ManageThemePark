import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private int duration;
    private Employee operator;
    private Queue<Visitor> visitorQueue;
    private LinkedList<Visitor> rideHistory;

    // Default constructor
    public Ride() {
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();


    }

    public Ride(String rideName, int duration, Employee operator) {
        this.rideName = rideName;
        this.duration = duration;
        this.operator = operator;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
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

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        visitorQueue.add(visitor);
        System.out.println(visitor.getName() + " has been added to the queue for " + rideName + ".");
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        visitorQueue.remove(visitor);
        System.out.println(visitor.getName() + " has been removed from the queue for " + rideName + ".");
    }

    @Override
    public void printQueue() {
        System.out.println("Queue for " + rideName + ":");
        for (Visitor visitor : visitorQueue) {
            System.out.println(visitor.getName());
        }
    }

    @Override
    public void runOneCycle() {
        if (!visitorQueue.isEmpty()) {
            Visitor visitor = visitorQueue.poll();
            System.out.println(visitor.getName() + " is taking the ride " + rideName + ".");
            rideHistory.add(visitor);
        } else {
            System.out.println("No visitors in the queue for " + rideName + ".");
        }
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride history for " + rideName + ":");
        for (Visitor visitor : rideHistory) {
            System.out.println(visitor.getName());
        }
    }
}
