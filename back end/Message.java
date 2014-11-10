/**
 * I think this bit of code will have to be touched by a number of people, and it will help to make sure
 * all relevant people know when something changes here
 * A message will be used to communicate between different portions of code, that
 * will likely be running on different threads. You will you use the static constructors to make sure that
 * the messages that get sent will be consistent no matter what. The code that receives
 * the message will be responsible for deciding what to do with it An example of a message constructor and the way
 * the code should be commented and implemented can be seen below in the example. It is hard to  predict exactly what
 * messages will need to be passed. Additionally it is common practice to separate important parts of the message with spaces
 * or at least thats what the instructors did on a pset they gave us once in 6.005
 * @author Justin
 *
 */
public class Message {
    
    /**
     * This method writes a message for the BTC connector telling it to update the resistance. 
     * The message will have the following form
     * message = "resistance" + " " + x 
     * x = [0-9]*
     * note the above line is just something called a regular expression. The [0-9] means any digit between 0 and 9
     * and the * after means that it can have any number of those digits in a row
     * @return a message with the defined format
     */
    public static String writeResistanceUpdateForBTC(int resistanceLevel){
        return "resistance " + Integer.toString(resistanceLevel);
    }

   
}
