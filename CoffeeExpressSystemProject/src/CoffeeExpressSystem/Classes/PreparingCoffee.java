package CoffeeExpressSystem.Classes;

import java.util.Scanner;

public class PreparingCoffee extends IngredientLevelMeter{

    Scanner scanner = new Scanner(System.in);

    void coffeeGrinding(){
        System.out.println("Mielenie kawy...");
    }

    void coffeeSpilling(){
        System.out.println("Przesypywanie kawy do glowicy...");
    }

    void turningOnTheHeater(double temperatureOfWater, double temperatureOfMilk){
        super.setWaterTemperature(temperatureOfWater);
        super.setMilkTemperature(temperatureOfMilk);
        System.out.println("Temperatura wody: " + temperatureOfWater);
        System.out.println("Temperatura mleka: " + temperatureOfMilk);
    }

    void pressureWaterAndMilk(double pressureOfWater, double pressureOfMilk){
        super.setWaterPressure(pressureOfWater);
        super.setMilkPressure(pressureOfMilk);
        System.out.println("Cisnienie wody: " + pressureOfWater + "b");
        System.out.println("Cisnienie mleka: " + pressureOfMilk + "b");
    }
}
