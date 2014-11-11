package backend;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * This class will be responsible for all communication with the arduino.
 * Most of the work for this will be figuring out how to send and receive
 * messages using bluetooth and how to connect with arduino
 * @author Justin
 *
 */
public class BlueToothCommunicator {
    private BlockingQueue<String> BackendMessageQueue;

    /**
     * Lvl E/M
     * The function that will be responsible for creating an instance of a
     * communicator
     */
    public BlueToothCommunicator(){
        //this. attaches BackendMessageQueue to this particular instance
        //this.BackendMessageQueue = new ArrayBlockingQueue<String>(); commenting this out so i can test the UI

    }

    /**
     * Lvl ?
     * This function will be used to connect to the arduino, I really don't know what this will
     * entail or what the result will be. This task will take a bit of investigation into the android API
     */
    private void connect (){}

    /**
     * Lvl ?
     * This method will be run on it's own thread to continually listen for input from the Arduino.
     * Since I don't know how th blue tooth works I can't really say what form that message will take,
     * and I'm not really sure what we would possibly need to do with the Arduino messages either
     */
    private void receiveMessageFromArduinoLoop(){}

    /**
     * Lvl M/E
     * This method will be run on it's own thread, continually listening for input from
     * the rest of the back end, the person who implements this will have to look into how
     * to use blocking queues
     */
    private void receiveMessageFromBackendLoop(){}

    /**
     * Lvl M
     * Technically speaking this doesn't need to be it's own method, and could just
     * live in the backend message loop. It just makes the code cleaner when you do it this way.
     * This method will take in a message from the back end and perform the appropriate action
     */
    private void parseBackendMessage (String message){
        String [] args = message.split(" ");
        if (args[0].equals("resistance")){
            int resistance = Integer.parseInt(args[1]);
            //tell the arduino that this is their new reisstance
        }
    }

    /**
     * Lvl E
     * This method will be called by other classes to send a message to the blue tooth communicator
     */
    public void sendMessageToBlueToothCommunicator(String message){
        //put message onto blocking queue
        try {
            BackendMessageQueue.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

