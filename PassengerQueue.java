
import java.util.LinkedList;
import java.util.Queue;
public class PassengerQueue {
    //Data Fields
    /**
     * The queue of passengers.
     */
    private Queue<Passenger> theQueue;
    /**
     * The number of passengers served.
     */
    private int numServed;
    /**
     * The total time passengers were waiting.
     */
    private int totalWait;
    /**
     * The name of this queue.
     */
    private String queueName;
    /**
     * The average arrival rate.
     */
    private double arrivalRate;
    private int maxProcessingTime;
    // Constructor

    /**
     * Construct a PassengerQueue with the given name.
     *
     * @param queueName The name of this queue
     */
    public PassengerQueue(String queueName) {
        numServed = 0;
        totalWait = 0;
        this.queueName = queueName;
        theQueue = new LinkedList<Passenger>();
    }

    public int update(int clock, boolean showAll) {
        Passenger nextPassenger = theQueue.remove();
        int timeStamp = nextPassenger.getArrivalTime();
        int wait = clock - timeStamp;
        totalWait += wait;
        numServed++;
        if (showAll) {
            System.out.println("Time is " + clock
                    + ": Serving "
                    + queueName
                    + " with time stamp "
                    + timeStamp);
        }
        return clock + nextPassenger.getProcessingTime();
    }
    /** Method to show the statistics. */


    /** Check if a new arrival has occurred.
     @param clock The current simulated time
     @param showAll Flag to indicate that detailed
     data should be output
     */
    public void checkNewArrival(int clock, boolean showAll) {
        if (Math.random() < arrivalRate) {
            theQueue.add(new Passenger(clock,maxProcessingTime));
            if (showAll) {
                System.out.println("Time is "
                        + clock + ": "
                        + queueName
                        + " arrival, new queue size is "
                        + theQueue.size());
            }
        }
    }

    public void setArrivalRate(Double input){
        arrivalRate = input/60.0;
    }
    public void setMaxProcessingTime(int value){
        maxProcessingTime = value;
    }
    public int getNumServed() {
        return numServed;
    }

    public  int getTotalWait() {
        return totalWait;
    }



    public int size() {
        return theQueue.size();
    }

    public boolean isEmpty() {
        return theQueue.isEmpty();
    }
}
