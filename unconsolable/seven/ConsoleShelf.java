/* Michelle Luo and Pettrus Konnoth
 * AP CSA
 * UnConsolable: unconsolable.seven.Main
 * October 2nd
 * Period 7
 */

 //imports
package unconsolable.seven;
import java.util.ArrayList;
import java.util.List;

public class ConsoleShelf {

    //fields for the shelf variable def (Michelle Luo)
    private double height;
    private int availableSpace;
    private boolean isFull;
    private String color;
    private ArrayList<Console> consoleArrayList;

    //set up initial consoleArrayList with empty values (Michelle Luo)
    public ArrayList<Console> consoleInitialization(){
        return new ArrayList<Console>();
    }
    
    //default constructor console shelf (Pettrus Konnoth)
    public ConsoleShelf(){
        this.height = 0;
        this.availableSpace = 0;
        this.isFull = false;
        this.color = "black";
        this.consoleArrayList = consoleInitialization();
    }
    // finding the average price of the consoles on the shelf (Michelle Luo)
    public float averagePrice() {//(pettrus Konnoth
        //i love java
        if (consoleArrayList.isEmpty()) {//check if the array is empty
            return 0.0f; // Return 0 if there are no consoles in the list to avoid division by zero
        }

        float sum = 0.0f;
        for (Console console : consoleArrayList) {
            sum += console.getCost(); // getting the sum
        }
        return sum / consoleArrayList.size(); // gettting the average

    }
    // this the method is for calculating the rating for each of the consoles on the shelf based on a formula (Pettrus Konnoth)
    public List<Float> getConsoleRatings() {
        List<Float> ratings = new ArrayList<>();

        for (Console console : consoleArrayList) {
            // Calculate the rating for each console using the formula: cost * storage / energy consumption
            float consoleRating = (float) (console.getCost() * console.getStorage() / console.getEnergyConsumption());
            ratings.add(consoleRating);
        }

        return ratings;
    }



    //partial constructor console shelf (Pettrus Konnoth)
    public ConsoleShelf(double height){
        this.height = height;
        this.availableSpace = 0;
        this.isFull = false;
        this.color = "black";
        this.consoleArrayList = consoleInitialization();
    }

    //full constructor console shelf (Michelle Luo)
    public ConsoleShelf(double height, int availableSpace, boolean isFull, String color, ArrayList<Console> consoleArrayList){
        this.height = height;
        this.availableSpace = availableSpace;
        this.isFull = isFull;
        this.color = color;
        this.consoleArrayList = consoleArrayList;
    }

    // creating the crud functionality

    //add new console to arrayList (Michelle Luo)
    public void createConsole(Console console){
            this.consoleArrayList.add(console);
    }
    //read the arrayList (Michelle Luo)
    public void readConsole() {
        String s = "";
        for (Console console : consoleArrayList) {
            s += console;
        }
        System.out.println(s);
    }

    //update an element in the arrayList at the index given in the parameter (Michelle Luo)
    public void update(int index, Console updatedConsole) {
        this.consoleArrayList.set(index, updatedConsole);
    }

    //delete an element in the arraylist at the given parametric index (Michelle Luo)
    public void delete(int index) {
        this.consoleArrayList.remove(index);
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
    //changed getters and setters for array to ArrayList (Michelle Luo)
    public ArrayList<Console> getconsoleArrayList() {
        return this.consoleArrayList;
    }
    public void setconsoleArrayList(ArrayList<Console> consoleArrayList) {
        this.consoleArrayList = consoleArrayList;
    }

    public int getSizeArrayList(){
        return this.consoleArrayList.size();
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
        if (consoleArrayList.size() > 0) {
            // Use a for loop to iterate through the arrayList (Michelle Luo)
            s += "\n It also has the following consoles on it: \n";
            for (int i = 0; i < consoleArrayList.size(); i++) {
                s += this.consoleArrayList.get(i);
            }
        }else{
            s += "\nNo Consoles are stored on this Shelf.";
        }

        return s;
    }








}