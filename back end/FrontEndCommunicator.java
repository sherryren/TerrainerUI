/**
 * This class has the job of passing messages between the front and back ends and doing the appropriate stuff
 * with those messages
 * @author Justin
 *
 */
public class FrontEndCommunicator {
    
    /**
     * Lvl M
     * Constructor
     */
    public FrontEndCommunicator(){}
    
    /**
     * Lvl E/M
     * a loop that will wait for messages from the front end and do the right stuff with them. 
     * This will be on it's own thread
     */
    private void receiveMessagesFromFrontLoop(){}
    
    /**
     * Lvl E
     * A method that can be called by anyone to send a message to the front end 
     */
    public void sendMessageToFrontEnd(){}

}
