/* Michelle Luo and Pettrus Konnoth
 * AP CSA
 * UnConsolable: unconsolable.seven.Main
 * October 2nd
 * Period 7
 */
package unconsolable.seven;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class Main {

    //get an integer for the index of Array (Pettrus Konnoth)
    private static int getUserInputForIndex(String message) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print(message);
        return inputScanner.nextInt();
    }

    //Makes a new Console Object based on user input (Pettrus Konnoth)
    private static Console newConsole(){
        Scanner inputConsoleScanner = new Scanner(System.in);

        System.out.print("Enter the name of the console: ");
        String name = inputConsoleScanner.nextLine();


        Brand brand = null;
        boolean isValidBrand = false;

        do {
            System.out.print("Enter the brand of the console (XBOX, PLAYSTATION, NINTENDO, ATARI, SEGA, META): ");
            String brandStr = inputConsoleScanner.nextLine().toUpperCase();

            try {
                brand = Brand.valueOf(brandStr);
                isValidBrand = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid brand. Please enter a valid brand from the given options.");
            }
        } while (!isValidBrand);

        double storage = 0;

        do {
            System.out.print("Enter the storage capacity of the console: ");

            if (inputConsoleScanner.hasNextDouble()) {
                storage = inputConsoleScanner.nextDouble();
                break; // Exit the loop when a valid double is provided
            } else {
                System.out.println("Invalid storage capacity. Please enter a valid storage capacity.");
                inputConsoleScanner.next(); // Consume the invalid input to prevent an infinite loop
            }
        } while (true);
        //Michelle Luo

        float cost = 0;
        do {
            System.out.print("Enter the cost of the console: ");
            //pettrus Konnoth added minor changes
            if (inputConsoleScanner.hasNextFloat()) {
                cost = inputConsoleScanner.nextFloat();
                break; // Exit the loop when a valid float is provided
            } else {
                System.out.println("Invalid cost. Please enter a valid cost.");
                inputConsoleScanner.next(); // Consume the invalid input to prevent an infinite loop
            }
        } while (true);

        int energyConsumption = 0;
        do {
            System.out.print("Enter the energy consumption of the console: ");

            if (inputConsoleScanner.hasNextInt()) {
                energyConsumption = inputConsoleScanner.nextInt();
                break; // Exit the loop when a valid int is provided
            } else {
                System.out.println("Invalid energy consumption. Please enter a valid energy consumption.");
                inputConsoleScanner.next(); // Consume the invalid input to prevent an infinite loop
            }
        } while (true);



        System.out.print("Does it have a color display (true/false): ");
        boolean hasColorDisplay = false;
        if (inputConsoleScanner.hasNextBoolean()) {
            hasColorDisplay = inputConsoleScanner.nextBoolean();
        }
        return new Console(name, brand, storage, cost, energyConsumption, hasColorDisplay);
    }

    public static void main(String[] args) {
        // Changed to ArrayList (Michelle Luo)
        ArrayList<Console> newConsoleShelf = new ArrayList<Console>();
        ConsoleShelf consoleShelf = new ConsoleShelf(1.8, 0, false, "gray", newConsoleShelf);

        Scanner userInputObject = new Scanner(System.in);
        int userInput;

        do {
            //CRUD Menu (Michelle Luo)
            System.out.println("Choose a CRUD Option for the Array:");
            System.out.println("1. Create a new Console to be added to the shelf");
            System.out.println("2. Read off all the Consoles on the Shelf");
            System.out.println("3. Update a specific Console on the shelf");
            System.out.println("4. Delete a Console from the shelf");
            System.out.println("5. Print ConsoleShelf");
            System.out.println("6. find the average price of the consoles on the shelf");
            System.out.println("7. see the average rating of the consoles on the shelf");
            System.out.println("8. Exit the program");
            System.out.println("User Input of an above Number:");
            userInput = userInputObject.nextInt();

            switch (userInput) {
                //Create a new Console on the shelf (Pettrus Konnoth) (Michelle Luo cleaned it up)
                case 1 -> {
                    // add a new console to the consoleShelf Object 
                    consoleShelf.createConsole(newConsole()); // Add the new console to the shelf
                    System.out.println("Console added to the shelf.\n");
                }
                //Read off all the Consoles on the shelf (Michelle Luo)
                case 2 -> {
                    consoleShelf.readConsole();
                }
                //Update a Console on the Shelf (Pettrus Konnoth and Michelle Luo)
                case 3 -> {
                    int indexToUpdate = getUserInputForIndex("Enter the index of the console to update: ");
                    //if the index is within the twelve limit of a shelf:
                    if (indexToUpdate >= 0 && indexToUpdate < 11) {
                        consoleShelf.update(indexToUpdate,newConsole());
                    } else {
                        System.out.println("Invalid index. No console updated.");
                    }
                }
                //Delete Console on the shelf (Pettrus Konnoth)
                case 4 -> {
                    int indexToDelete = getUserInputForIndex("Enter the index of the console to delete: ");
                    //if the index is within the numbers of console existing on the shelf:
                    if (indexToDelete >= 0 && indexToDelete < consoleShelf.getSizeArrayList()) {
                        consoleShelf.delete(indexToDelete);
                        System.out.println("Console deleted from the shelf.");
                    } else {
                        System.out.println("Invalid index. No console deleted.");
                    }
                }
                //Print out the Container Object (Michelle Luo)
                case 5 -> {
                    System.out.println("Printing consoleShelf");
                    System.out.println(consoleShelf);
                    System.out.println("\n");
                }

                case 6 -> {
                    // Calculate and print the average price (Pettrus Konnoth)
                    float averagePrice = consoleShelf.averagePrice();
                    System.out.println("Average Price of Consoles in shelf: $" + averagePrice);
                    System.out.println("\n");

                }
                //case 7 for the rating of the consoles (Pettrus Konnoth)
                case 7 -> {
                    // Get the ratings for each console
                    List<Float> consoleRatings = consoleShelf.getConsoleRatings();

                    // Print the ratings for each console
                    for (int i = 0; i < consoleRatings.size(); i++) {
                        System.out.println("Rating for Console " + (i + 1) + ": " + consoleRatings.get(i));

                    }
                    System.out.println("\n");
                }

                //leave the program (Pettrus Konnoth)
                case 8 -> System.out.println("exiting program");
                //Default (Pettrus Konnoth)
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (userInput != 5);
        //Close the system.in connected scanners (Michelle Luo)
        userInputObject.close();
    }
}
