/* Michelle Luo and Pettrus Konnoth
 * AP CSA
 * UnConsolable: unconsolable.seven.Main
 * September 24th
 * Period 7
 */
package unconsolable.seven;
import java.util.Scanner;

public class Main {

    //get an integer for the index of Array (Pettrus Konnoth)
    private static int getUserInputForIndex(String message) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print(message);
        int intInput = inputScanner.nextInt();
        return intInput;
    }

    //Makes a new Console Object based on user input (Pettrus Konnoth)
    private static Console newConsole(){
        Scanner inputConsoleScanner = new Scanner(System.in);

        System.out.print("Enter the name of the console: ");
        String name = inputConsoleScanner.nextLine();

        System.out.print("Enter the brand of the console (XBOX, PLAYSTATION, NINTENDO, ATARI, SEGA, META): ");
        String brandStr = inputConsoleScanner.nextLine();

        Brand brand = Brand.valueOf(brandStr.toUpperCase());

        System.out.print("Enter the storage capacity of the console: ");
        double storage = 0;
        if (inputConsoleScanner.hasNextDouble()) {
            storage = inputConsoleScanner.nextDouble();
        }

        System.out.print("Enter the energy consumption of the console: ");
        int energyConsumption = 0;
        if (inputConsoleScanner.hasNextInt()) {
            energyConsumption = inputConsoleScanner.nextInt();
        }

        System.out.print("Does it have a color display (true/false): ");
        boolean hasColorDisplay = false;
        if (inputConsoleScanner.hasNextBoolean()) {
            hasColorDisplay = inputConsoleScanner.nextBoolean();
        }
        Console newConsole = new Console(name, brand, storage, energyConsumption, hasColorDisplay);
        return newConsole;
    }

    public static void main(String args[]) {
        // Create a ConsoleShelf object (Michelel Luo)
        Console[] newConsoleShelf = new Console[12];
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
            System.out.println("6. Exit");
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
                    int indexToUpdate = getUserInputForIndex("Enter the index of the console to update: ") -1;
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
                    if (indexToDelete >= 0 && indexToDelete < consoleShelf.getAvailableSpace()) {
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
                }   
                //leave the program (Pettrus Konnoth)
                case 6 -> System.out.println("exiting program");
                //Default (Pettrus Konnoth)
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (userInput != 5);
        //Close the system.in connected scanners (Michelle Luo)
        userInputObject.close();
    }
}
