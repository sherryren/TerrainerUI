package backend;

/**
 * This class will keep track of the resistance level
 * @author Justin
 *
 *note to Justin, I think only one thread will be changing this, but it's possible you may
 *have to synchronize on the methods in order to keep this thread safe
 */
public class ResistanceLevel {
    private int resistance;
    private final int MAX_LEVEL = 5;
    private final int MIN_LEVEL = 0;
    /**
     * Creator method for a resistance level
     */
    public ResistanceLevel(){
        this.resistance = 0;
    }

    /**
     * Creator method for a resistance level, can be called with the
     * argument starting_resistance to set the starting resistance
     */
    public ResistanceLevel(int starting_resistance){
        this.resistance = starting_resistance;
    }

    /**
     * Lvl E
     * A method that tells you what the current resistance is(a note here is that there are two different values
     * we can consider, we can say what the person is actually feeling, or what the person will feel when the mechanical
     * system catches up. From a user feedback perspective I think it would be best to do the catch up one)
     * @return an int representing the current resistance level
     */
    public int getCurrentResistance(){
        return this.resistance;
    }

    /**
     * Lvl E
     * A method to increase the current resistance, this method should update the value that getCurrentResistance returns
     * @param changeAmount the amount by which you want to increase the resistance
     */
    public void changeResistance(int changeAmount){
        int new_resistance = this.resistance + changeAmount;
        if (new_resistance > MAX_LEVEL){
            new_resistance=MAX_LEVEL;
        }
        if (new_resistance<MIN_LEVEL){
            new_resistance = MIN_LEVEL;
        }
        this.resistance = new_resistance;
    }

    /**
     * Lvl E
     * This method should set the current resistance to the desired level
     * @param desiredLevel the level that the resistance level should be
     */
    public void setResistance(int desiredLevel){
        this.resistance = desiredLevel;
    }
}

