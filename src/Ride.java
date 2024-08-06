public class Ride {
    private String rideName;
    private int duration;
    private Employee operator;

    // Default constructor
    public Ride() {

    }

    public Ride(String rideName, int duration, Employee operator) {
        this.rideName = rideName;
        this.duration = duration;
        this.operator = operator;
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
}
