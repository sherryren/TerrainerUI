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
    private BlueToothCommunicator btc;
    /**
     * Creator method for a resistance level
     */
    public ResistanceLevel(BlueToothCommunicator btc){
        this.resistance = 0;
        this.btc = btc;
    }

    /**
     * Creator method for a resistance level, can be called with the
     * argument starting_reisstance to set the starting resistance
     */
    public ResistanceLevel(int starting_resistance, BlueToothCommunicator btc){
        this.resistance = starting_resistance;
        this.btc = btc;
    }

    /**
     * Lvl E
     * A method that tells you what the current resistance is(a note here is that there are two different values
     * we can consider, we can say what the person is actually feeling, or what the person will feel when the mechanical
     * system catches up. From a user feedback perspective I think it would be best to do the catch up one)
     * @return an int reporesenting the currest resistance level
     */
    public int getCurrentresistance(){
        return this.resistance;
    }

    /**
     * Lvl E
     * A method to increase the current resistance, this method should update the value that getCurrenresistance returns
     * as well as send a message to the BlueToothCommunicator with the good news of the increased resistance
     * @param increaseAmount the amount by which you want to increase the resistance
     */
    public void increaseresistance(int increaseAmount){
        int new_resistance = this.resistance + increaseAmount;
        btc.sendMessageToBlueToothCommunicator(Message.writeResistanceUpdateForBTC(new_resistance));
        this.resistance = new_resistance;


    }

    /**
     * Lvl E
     * A method to decrease the current resistance, this method should update the value that getCurrenresistance returns
     * as well as send a message to the BlueToothCommunicator with the good news of the decreased resistance
     * @param decreaseAmount the amount by which you want to increase the resistance
     */
    public void decreaseResistance(int decreaseAmount){}

    /**
     * Lvl E
     * This method should set the current resistance to the desired level, a
     * lso make sure to tell the BlueToothCommunicator
     * @param desiredLevel the level that the resistance level should be
     */
    public void setResistance(int desiredLevel){}
}

