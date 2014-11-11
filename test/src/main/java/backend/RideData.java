package backend;

/**
 * This class will be the one who keeps track of everything that is going on in the ride, for now it will only keep
 * track of the current stuff but in the future it should be able to tell you everything that happened in a ride(I'm not
 * sure what the best way to keep track of the history is)
 *
 * A likely implementation of this will require it to talk to the GPS class to get location and speed ; some sort of
 * android clock class to get the time, and the resistence_level class to get the current resistence
 *
 * This will need to be what's known as an immutable data type, all that it means is that any of the
 * underlying data elements shouldn't change within a single instance of Ride_Data. This is to keep
 * it safe from bugs when using multiple threads. See the update function for information on how we will
 * update the Ride_Data
 * @author Justin
 */
public class RideData {

    /**
     * Lvl E
     * The method to create an instance of the Ride_Data, you will likely need to put some arguments in here
     */
    public RideData (){}

    /**
     * Lvl E/M
     * This method should return the time since the beginning of the ride
     *  in seconds(may need to change units depending on requirements)
     * @return  time
     */
    public int getRideTime(){
        return 0;
    }

    /**
     * Lvl E
     * This method will return the current speed that we are traveling at
     * @return a speed in m/s
     */
    public float getCurrentSpeed(){
        return 0;
    }

    /**
     * Lvl M
     * You can probably guess what this will do, but it is good form for me to write it anyway,
     * This method will return the current power of the rider
     * @return a power in watts
     */
    public float getCurrentPower () {
        return 0;
    }

    /**
     * Lvl E
     * This method will return the total path length traveled by the rider
     * @return a distance in meters
     */
    public float getDistanceTraveled(){
        return 0;
    }

    /**
     * Lvl M/H
     * This method will return a new
     * Ride_Data that has the updated information.
     * It will have to call a bunch of other classes in order
     * to find out what the new speed, time, and power should be.
     */
    public  RideData update(){
        return new RideData();
    }


}
