/* Michelle Luo and Pettrus Konnoth
 * AP CSA
 * UnConsolable: Console
 * October 2nd
 * Period 7
 */


package unconsolable.seven;

public class Console {
    // define variables (Michelle Luo)
    private String name;
    private Brand brand;
    private double storage;
    //added cost with this version!  
    private float cost;
    private int energyConsumption;
    private boolean hasColorDisplay;

    //defult constructor (Pettrus Konnoth)
    public Console(){
        this.name = "Oculus Quest 2";
        this.brand = Brand.META;
        this.storage = 0;
        this.cost = 0;
        this.energyConsumption = 0;
        this.hasColorDisplay = false;
    }
    //partial constructor - 1 parameter (Pettrus Konnoth)
    public Console(String name){
        this.name = name;
        this.brand = Brand.META;
        this.storage = 0;
        this.cost = 0;
        this.energyConsumption = 0;
        this.hasColorDisplay = false;
    }
    //partial constructor - 2 parameters (Pettrus Konnoth)
    public Console(String name, Brand brand){
        this.name = name;
        this.brand = brand;
        this.storage = 0;
        this.cost = 0;
        this.energyConsumption = 0;
        this.hasColorDisplay = false;
    }
    //partial constructor - 3 parameters (Michelle Luo)
    public Console(String name, Brand brand, double storage){
        this.name =  name;
        this.brand = brand;
        this.storage = storage;
        this.cost = 0;
        this.energyConsumption = 0;
        this.hasColorDisplay = true;
    }

    //partial constructor - 4 parameters (Michelle Luo)
    public Console(String name, Brand brand, double storage, float cost){
        this.name =  name;
        this.brand = brand;
        this.storage = storage;
        this.cost = cost;
        this.energyConsumption = 0;
        this.hasColorDisplay = true;
    }
    //partial constructor - 5 parameters (Michelle Luo)
    public Console(String name, Brand brand, double storage, float cost, int energyConsumption){
        this.name =  name;
        this.brand = brand;
        this.storage = storage;
        this.cost = cost;
        this.energyConsumption = energyConsumption;
        this.hasColorDisplay = true;
    }

    //partial constructor - 6 parameters (Michelle Luo)
    public Console(String name, Brand brand, double storage, float cost, int energyConsumption, boolean hasColorDisplay){
        this.name =  name;
        this.brand = brand;
        this.storage = storage;
        this.cost = cost;
        this.energyConsumption = energyConsumption;
        this.hasColorDisplay = hasColorDisplay;
    }

    //creating getters (Pettrus Konnoth) (Michelle Luo put minor edits)
    public String getName() {
        return this.name;
    }
    //creating setters (Pettrus Konnoth)
    public void setName(String name) {
        this.name = name;
    }
    //creating getters (Pettrus Konnoth) (Michelle Luo put minor edits)
    public Brand getBrand() {
        return this.brand;
    }
    //creating setters (Pettrus Konnoth)
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    //creating getters (Pettrus Konnoth) (Michelle Luo put minor edits)
    public double getStorage() {
        return this.storage;
    }
    //creating setters (Pettrus Konnoth)
    public void setStorage(double storage) {
        this.storage = storage;
    }
    //creating getters (Pettrus Konnoth) (Michelle Luo put minor edits)
    public int getEnergyConsumption() {
        return this.energyConsumption;
    }
    //creating setters (Pettrus Konnoth)
    public void setEnergyConsumption(int energyConsumption) {
        this.energyConsumption = energyConsumption;
    }
    //creating getters (Pettrus Konnoth) (Michelle Luo put minor edits)
    public boolean hasColorDisplay() {
        return this.hasColorDisplay;
    }
    //creating setters (Pettrus Konnoth)
    public void setHasColorDisplay(boolean hasColorDisplay) {
        this.hasColorDisplay = hasColorDisplay;
    }
    //creating getters (Michelle luo)
    public float getCost() {
        return this.cost;
    }
    //creating setters (Michelle Luo)
    public void setCost(float cost) {
        this.cost = cost;
    }

    // creating the toString method (Pettrus Konnoth)
    @Override
    public String toString(){
        String colorDisplayString = "";
        if (hasColorDisplay){
            colorDisplayString = "Yes";
        }else{
            colorDisplayString = "No";
        }
        //return String
        return  "---VIDEO GAME CONSOLE---" + "\n" +
                "Name: " + this.name + "\n" +
                "Brand: " + this.brand + "\n" +
                "Storage: " + this.storage + "\n" +
                "Cost: " + this.cost + "\n" +
                "Energy Consumption: " + this.energyConsumption + "\n" +
                "Does it display in Color: " + colorDisplayString + "\n";
    }


}

