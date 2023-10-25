import java.util.Random;

public class Passenger {
    Random numGenerate;
// Data Fields
    /** The ID number for this passenger. */
    private int passengerId;
    /** The time needed to process this passenger. */
    private int processingTime;
    /** The time this passenger arrives. */
    private int arrivalTime;
    /** The maximum time to process a passenger. */

    /** The sequence number for passengers. */
    private static int idNum = 0;

    /** Create a new passenger.
     @param arrivalTime The time this passenger arrives */
    public Passenger(int arrivalTime,int maxProcessingTime) {
        this.arrivalTime = arrivalTime;
        numGenerate = new Random();
        processingTime = 1 + numGenerate.nextInt(maxProcessingTime);
        passengerId = idNum++;
    }
    /** Get the arrival time.
     @return The arrival time */
    public int getArrivalTime() {
        return arrivalTime;
    }
    /** Get the processing time.
     @return The processing time */
    public int getProcessingTime() {
        return processingTime;
    }
    /** Get the passenger ID.
     @return The passenger ID */
    public int getId() {
        return passengerId;
    }

}
