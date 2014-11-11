package backend;

/**
 * Created by Justin on 11/10/2014.
 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This class has the job of passing messages between the front and back ends and doing the appropriate stuff
 * with those messages
 * @author Justin
 *
 */
public class FrontEndCommunicator {
    private BlockingQueue<String> MessageFromFront;
    private BlockingQueue<String> MessageFromBack;
    private String newMessageFromFront;
    private String newMessageFromBack;
    /**
     * Lvl M
     * Constructor
     */
    public FrontEndCommunicator(){
        this.MessageFromFront = new LinkedBlockingQueue<String>();
        this.MessageFromBack = new LinkedBlockingQueue<String>();
    }

    /**
     * Lvl E/M
     * a loop that will wait for messages from the front end.
     * This will be on it's own thread
     */
    private void receiveMessageFromFrontLoop(){
        try {
            newMessageFromFront = MessageFromFront.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void receiveMessageFromBackLoop(){
        try {
            newMessageFromBack = MessageFromBack.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lvl M
     * This method will take in a message from the front end and perform the appropriate action
     */
    private void parseMessageFromFront(String message){
        String [] args = message.split(" ");
        //still need to build
    }

    /**
     * Lvl M
     * This method will take in a message from the back end and perform the appropriate action
     */
    private void parseMessageFromBack(String message){
        String [] args = message.split(" ");
        //still need to build
    }

    /**
     * Lvl E
     * A method that can be called by anyone to send a message from the front to the backend
     */
    public void sendMessageFromFront(String message){
        try {
            MessageFromFront.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lvl E
     * A method that can be called by anyone to send a message from the backend to the front end
     */
    public void sendMessageFromBack(String message){
        try {
            MessageFromBack.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
