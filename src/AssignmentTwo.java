public class AssignmentTwo {
    public static void main(String[] args) {

        AssignmentTwo assignmentTwo = new AssignmentTwo();
        assignmentTwo.partThree();


    }
    public void partThree(){
        // Create a new Ride object
        Employee operator = new Employee("David", 30, "123 Main St","E567","Operator");
        Ride ride = new Ride("DC Rivals HyperCoaster", 5, operator);

        // Create Visitor objects
        Visitor visitor1 = new Visitor("Michele", 25, "456 Oak St","V001","Locals One Pass");
        Visitor visitor2 = new Visitor("Kevin", 28, "789 Pine St","V002","Locals One Pass Lite");
        Visitor visitor3 = new Visitor("Charlie", 22, "101 Maple St","V003","Mega Pass");
        Visitor visitor4 = new Visitor("Disney", 30, "202 Elm St","V004","One Pass");
        Visitor visitor5 = new Visitor("Eve", 27, "303 Birch St","V005","Single Day Pass");

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