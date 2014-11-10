package backend;

/**
 * Lvl ?
 * This class will contain all the important gps information. I don't know how difficult this will be,
 * but it seems like once you get the GPS connection going it should be smooth sailing.
 * @author Justin
 *
 */
public class GPS {

    /**
     * Constructor, I really don't know what goes into this, but the android API would be a good
     * place to start
     */
    public GPS(){}

    /**
     * We will want some sort of way to represent a location, that may just be a lattitude and longitude,
     * this can be figured out at some point. You will have to change void to whatever represents the location
     * @return
     */
    public void getLocation(){}

    /**
     * Use this to find out how fast the cyclist is traveling. Preferably in m/s
     * @return
     */
    public float getSpeed(){}

}
