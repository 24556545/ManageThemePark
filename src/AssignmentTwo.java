public class AssignmentTwo {
    public static void main(String[] args) {

        AssignmentTwo assignmentTwo = new AssignmentTwo();
        assignmentTwo.partThree();
        assignmentTwo.partFourA();

    }
    public void partThree(){
        // Create a new Ride object
        Employee operator = new Employee("David", 30, "123 Main St","E567","Ride Operator");
        Ride ride = new Ride("DC Rivals HyperCoaster", 5, operator);

        // Create Visitor objects
        Visitor visitor1 = new Visitor("Tom", 25, "456 Oak St","V001","Locals One Pass");
        Visitor visitor2 = new Visitor("Sherly", 28, "789 Pine St","V002","Locals One Pass Lite");
        Visitor visitor3 = new Visitor("Ben", 22, "101 Maple St","V003","Mega Pass");
        Visitor visitor4 = new Visitor("David", 30, "202 Elm St","V004","One Pass");
        Visitor visitor5 = new Visitor("Jack", 27, "303 Birch St","V005","Single Day Pass");

        // Add Visitors to the Queue
        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        ride.addVisitorToQueue(visitor4);
        ride.addVisitorToQueue(visitor5);

        // Remove a Visitor from the Queue
        ride.removeVisitorFromQueue(visitor3);

        // Print all Visitors in the Queue
        ride.printQueue();
    }
    public void partFourA(){
        // Create a new Ride object
        Employee operator = new Employee("Dolly", 35, "789 Willow St", "E123", "Ride Operator");
        Ride ride = new Ride("The Amazing Ride", 7, operator);

        // Create Visitor objects
        Visitor visitor1 = new Visitor("Jack", 20, "321 Cedar St", "V101", "Annual Pass");
        Visitor visitor2 = new Visitor("Emma", 24, "654 Spruce St", "V102", "Single Day Pass");
        Visitor visitor3 = new Visitor("Leo", 30, "987 Oak St", "V103", "Weekly Pass");
        Visitor visitor4 = new Visitor("Bernny", 28, "543 Birch St", "V104", "Season Pass");
        Visitor visitor5 = new Visitor("Sharon", 22, "876 Pine St", "V105", "Monthly Pass");

        // Add Visitors to the Queue
        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
       // ride.addVisitorToQueue(visitor3);
        ride.addVisitorToQueue(visitor4);
        ride.addVisitorToQueue(visitor5);

        // Add Visitors to the Ride
        ride.runOneCycle();
        ride.runOneCycle();
        ride.runOneCycle();
        ride.runOneCycle();
        ride.runOneCycle();

        // Check if a Visitor is in the collection
        boolean isVisitorInHistory = ride.isVisitorInCollection(visitor3);
        System.out.println("Is Visitor " + visitor3.getName() + " in ride history? " + (isVisitorInHistory ? "Yes" : "No"));

        // Print the number of Visitors in the collection
        int numberOfVisitors = ride.getNumberOfVisitorsInCollection();
        System.out.println("Number of visitors who have taken the ride: " + numberOfVisitors);

        // Print all Visitors in the collection
        ride.printRideHistory();
    }
    public void partFourB(){
    }
    public void partFive(){
    }
    public void partSix(){
    }
    public void partSeven(){

    }
}