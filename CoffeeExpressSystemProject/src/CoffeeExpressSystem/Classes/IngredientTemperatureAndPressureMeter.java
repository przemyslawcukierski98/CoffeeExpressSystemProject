package CoffeeExpressSystem.Classes;

public class IngredientTemperatureAndPressureMeter {

    private double waterTemperature;
    private double milkTemperature;
    private double milkPressure;
    private double waterPressure;

    void setWaterTemperature(double waterTemperature){
        if(waterTemperature <= 100) this.waterTemperature = waterTemperature;
            else{
                System.err.println("Ustaw mniejsza wartosc temperatury! Blad systemu");
                System.exit(0);
            }
        }

    void setMilkTemperature(double milkTemperature){
        if(milkTemperature <= 100) this.milkTemperature = milkTemperature;
        else{
            System.err.println("Ustaw mniejsza wartosc temperatury! Blad systemu");
            System.exit(0);
        }
    }

    void setWaterPressure(double waterPressure){
        if(waterPressure < 100) this.waterPressure = waterPressure;
        else {
            System.err.println("Ustaw mniejsza wartosc cisnienia! Blad systemu");
            System.exit(0);
        }
    }

    void setMilkPressure(double milkPressure) {
        if(milkPressure < 100) this.milkPressure = milkPressure;
        else {
            System.err.println("Ustaw mniejsza wartosc cisnienia! Blad systemu");
            System.exit(0);
        }
    }

    double getWaterTemperature(){
        return waterTemperature;
    }

    double getMilkTemperature(){
        return milkTemperature;
    }

    double getMilkPressure(){
        return milkPressure;
    }

    double getWaterPressure(){
        return waterPressure;
    }
}
