package CoffeeExpressSystem.Classes;

import java.util.Scanner;

public class IngredientLevelMeter extends IngredientTemperatureAndPressureMeter{

    private Scanner scanner = new Scanner(System.in);

    private int gramsOfCoffee = 1500;
    private int gramsOfSugar = 0;
    private int mililitersOfMilk = 0;
    private int mililitersOfWater = 1500;

    // getters and setters

    int getGramsOfSugar() {
        return gramsOfSugar;
    }

    int getGramsOfCoffee() {
        return gramsOfCoffee;
    }

    int getMililitersOfMilk() {
        return mililitersOfMilk;
    }

    int getMililtersOfWater() {
        return mililitersOfWater;
    }

    void setGramsOfCoffee(int gramsOfCoffee){
        this.gramsOfCoffee = gramsOfCoffee;
    }

    void setGramsOfSugar(int gramsOfSugar){
        this.gramsOfSugar = gramsOfSugar;
    }

    void setMililitersOfMilk(int mililitersOfMilk){
        this.mililitersOfMilk = mililitersOfMilk;
    }

    void setMililtersOfWater(int mililitersOfWater){
        this.mililitersOfWater = mililitersOfWater;
    }

    void ingredientsShortageAlert() {
        System.out.println("ILOSC GRAM KAWY: " + gramsOfCoffee);
        System.out.println("ILOSC GRAM CUKRU: " + gramsOfSugar);
        System.out.println("ILOSC MILILITROW MLEKA: " + getMililitersOfMilk());
        System.out.println("ILOSC MILILITROW WODY: " + mililitersOfWater);
    }

    void addIngredients() {
        System.out.println("Czy chcesz uzupelnic braki? TAK/NIE");
        String topUp = scanner.nextLine();
        if (topUp.equalsIgnoreCase("tak")) {
            setGramsOfCoffee(1500);
            setGramsOfSugar(1500);
            setMililitersOfMilk(1500);
            setMililtersOfWater(1500);
            System.out.println("Braki uzupełnione");
        }
        else if (topUp.equalsIgnoreCase("nie")){
        }
        else{
            System.err.println("Niewlasciwy format odpowiedzi");
            System.exit(0);
        }
    }
}
