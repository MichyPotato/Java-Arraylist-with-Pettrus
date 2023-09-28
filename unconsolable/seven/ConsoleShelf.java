/* Michelle Luo and Pettrus Konnoth
 * AP CSA
 * UnConsolable: unconsolable.seven.Main
 * September 28th
 * Period 7
 */

 //imports
package unconsolable.seven;
import java.util.Arrays;

public class ConsoleShelf {

    //fields for the shelf variable def (Michelle Luo)
    private double height;
    private int availableSpace;
    private boolean isFull;
    private String color;
    private Console[] consoleArray;

    //set up initial consoleArray with empty values (Michelle Luo)
    public Console[] consoleInitialization(){
        Console[] consoleArray = new Console[12];
        return consoleArray;
    }
    
    //default constructor console shelf (Pettrus Konnoth)
    public ConsoleShelf(){
        this.height = 0;
        this.availableSpace = 0;
        this.isFull = false;
        this.color = "black";
        this.consoleArray = consoleInitialization();
    }

    //partial constructor console shelf (Pettrus Konnoth)
    public ConsoleShelf(double height){
        this.height = height;
        this.availableSpace = 0;
        this.isFull = false;
        this.color = "black";
        this.consoleArray = consoleInitialization();
    }

    //full constructor console shelf (Michelle Luo)
    public ConsoleShelf(double height, int availableSpace, boolean isFull, String color, Console[] consoleArray){
        this.height = height;
        this.availableSpace = availableSpace;
        this.isFull = isFull;
        this.color = color;
        this.consoleArray = consoleInitialization();
    }

    // creating the crud functionality

    // creating the create method for adding consoles to the shelf or thown an error(Pettrus Konnoth)
    public void createConsole(Console console){
        if (this.availableSpace<consoleArray.length){
            this.consoleArray[this.availableSpace] = console;
            this.availableSpace++;
        }
        else{
            System.out.println("The shelf is full");
        }
    }
    //creating the read method for reading the consoles on the shelf checks if console on shelf and returns the console (Pettrus Konnoth)
    public void readConsole() {
        if (this.availableSpace > 0) {
            // Use a for loop to iterate up to availableSpace
            for (int i = 0; i < availableSpace; i++) {
                System.out.println(consoleArray[i]);
            }
        } else {
            System.out.println("There are no consoles on the shelf");
        }
    }

    //creating the update method for updating a console on the shelf (Pettrus Konnoth)
    public void update(int index, Console updatedConsole) {
        // Check if the provided index is valid
        if (index >= 0 && index < 11) {
            // Checks if there is no object to update (Michelle Luo)
            if (consoleArray[index]== null){
                System.out.println("No Console to Update Here!");
            }else{
            //if there is an object, updates it
            consoleArray[index] = updatedConsole;
            System.out.println("Console at index " + index + " updated.");
            }
        } else {
            // Invalid index provided, provide feedback to the user
            System.out.println("Invalid index. No console updated.");
        }
    }

    //creating the delete method for deleting a console from the shelf (Pettrus Konnoth)
    public void delete(int index) {
        // Check if the provided index is valid
        if (index >= 0 && index < availableSpace) {
            // Shift the consoles in the array to remove the console at the specified index
            for (int i = index; i < availableSpace - 1; i++) {
                consoleArray[i] = consoleArray[i + 1];
            }
            // Set the last slot to null and decrement availableSpace
            consoleArray[availableSpace - 1] = null;
            availableSpace--;

            // Update isFull status
            isFull = (availableSpace == consoleArray.length);

            System.out.println("Console at index " + index + " deleted.");
        } else {
            // Invalid index provided, provide feedback to the user
            System.out.println("Invalid index. No console deleted.");
        }
    }

    //creating the getters and setters for the shelf (Pettrus Konnoth)
    public double getHeight() {
        return this.height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public int getAvailableSpace() {
        return this.availableSpace;
    }
    public void setAvailableSpace(int availableSpace) {
        this.availableSpace = availableSpace;
    }
    public boolean getIsFull() {
        return this.isFull;
    }
    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }
    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Console[] getConsoleArray() {
        return this.consoleArray;
    }
    public void setConsoleArray(Console[] consoleArray) {
        this.consoleArray = consoleArray;
    }

    // toString method (Pettrus Konnoth)
    @Override
    public String toString(){
        String s = "This shelf is " +
                this.height + " inches tall, has " +
                this.availableSpace + " spaces left, is " +
                this.isFull + " and is " +
                this.color + ".";
        //Added Printing of COnsoles on ConsoleShelf (Michelle Luo)
        if (this.availableSpace > 0) {
            // Use a for loop to iterate up to availableSpace
            s += "\n It also has the following consoles on it: \n";
            for (int i = 0; i < availableSpace; i++) {
                s += consoleArray[i];
            }
        }else{
            s += "\nNo Consoles are stored on this Shelf.";
        }

        return s;
    }







}