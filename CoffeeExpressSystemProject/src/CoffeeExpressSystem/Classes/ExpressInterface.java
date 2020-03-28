package CoffeeExpressSystem.Classes;

import CoffeeExpressSystem.Enums.TypesOfCoffee;

import java.util.Scanner;

public class ExpressInterface extends PreparingCoffee{

    private Scanner scanner = new Scanner(System.in);

    private boolean expressOn;

    void viewMainMenu(){
        System.out.println();
        System.out.println("1. PRZYRZĄDŹ KAWĘ");
        System.out.println("2. SPRAWDZ I UZUPELNIJ WODE/MLEKO/CUKIER/KAWE");
        System.out.println("3. WYŁĄCZ EKSPRES");
    }

    void turnOnExpress(){
        expressOn = true;
        System.out.println("EKSPRES WLĄCZONY");
    }

    void turnOffExpress(){
        expressOn = false;
        System.out.println("EKSPRES WYŁĄCZONY");
    }

    void chooseCoffee(){
        System.out.println();
        System.out.println("Wybierz rodzaj kawy: ");
        System.out.println("1. CAPPUCINO");
        System.out.println("2. AMERICANO");
        System.out.println("3. LATTE MACHIATO");
        System.out.println("4. LATTE");
        System.out.println("5. ESPRESSO");
        System.out.println("6. SKOMPONUJ WLASNA KAWE");
    }

    void selectAmountOfCoffee(){
        System.out.println("Wybierz ilosc łyżeczek kawy (1-5)");
        int yourNumberOfCoffee = scanner.nextInt();
        int yourGramsOfCoffee = yourNumberOfCoffee*5;
        if(yourNumberOfCoffee < 1 || yourNumberOfCoffee > 5) {
            System.err.println("Niepoprawna ilosc kawy. Blad systemu");
            System.exit(0);
        }
        if(yourGramsOfCoffee > super.getGramsOfCoffee()){
            System.err.println("Brak wystarczającej ilości kawy!");
            System.exit(0);
        }
    }

    void selectAmountOfSugar(){
        System.out.println("Wybierz ilosc lyzeczek cukru (0-5)");
        int yourNumberOfSugar = scanner.nextInt();
        int yourGramsOfSugar = yourNumberOfSugar*5;
        if(yourNumberOfSugar < 0 || yourNumberOfSugar > 5) {
            System.err.println("Niepoprawna ilosc cukru. Blad systemu");
            System.exit(0);
        }
        if(yourGramsOfSugar > super.getGramsOfSugar()){
            System.err.println("Brak wystarczającej ilości cukru!");
            System.exit(0);
        }
    }

    void selectAmountOfMilk(){
        System.out.println("Wybierz ilosc mililitrów mleka (5-100)");
        int yourNumberOfMilk = scanner.nextInt();
        if(yourNumberOfMilk < 5 || yourNumberOfMilk> 100) {
            System.err.println("Niepoprawna ilosc mleka. Blad systemu");
            System.exit(0);
        }
        if(yourNumberOfMilk > super.getMililitersOfMilk()){
            System.err.println("Brak wystarczającej ilości mleka!");
            System.exit(0);
        }
    }

    void cappucino(){
        System.out.println();
        ingredientsAlert();
        super.setMililitersOfMilk(super.getMililitersOfMilk()-150);
        espresso();
        finish("CAPPUCINO");
    }

    void espresso(){
        System.out.println();
        ingredientsAlert();
        System.out.println("Rozpoczeto parzenie kawy...");
        super.setGramsOfCoffee(super.getGramsOfCoffee()-10);

        coffeeGrinding();
        coffeeSpilling();
        turningOnTheHeater(96, 60);
        pressureWaterAndMilk(9, 9);

        System.out.println("Dodac cukier?");
        Scanner scanner = new Scanner(System.in);
        if(scanner.nextLine().equalsIgnoreCase("TAK")){
            super.setMililtersOfWater(super.getMililtersOfWater()-30);
            super.setGramsOfSugar(super.getGramsOfSugar()-10);
        }
        else{
            super.setMililtersOfWater(super.getMililtersOfWater()-30);
        }
        finish("ESPRESSO");
    }

    void americano(){
        System.out.println();
        ingredientsAlert();
        espresso();

        super.setMililtersOfWater(super.getMililtersOfWater()-60);
        System.out.println("Dolewanie wody w propocjach 2:1...");
        finish("AMERICANO");
    }

    void latteMachiato(){
        System.out.println();
        ingredientsAlert();
        super.setMililitersOfMilk(super.getMililitersOfMilk()-100);
        espresso();

        System.out.println("Wlewanie goracego mleka...");
        System.out.println("Wlewanie zaparzonego espresso");
        System.out.println("Spienianie mleka, aby utworzyc pianke...");
        finish("LATTE MACHIATO");
    }

    void latte(){
        System.out.println();
        ingredientsAlert();
        super.setMililitersOfMilk(super.getMililitersOfMilk()-100);
        espresso();

        System.out.println("Wlewanie zaparzonego espresso");
        System.out.println("Wlewanie goracego mleka...");
        System.out.println("Spienianie mleka, aby utworzyc pianke...");
        finish("LATTE");

    }

    void ingredientsAlert(){
        if(super.getGramsOfCoffee()<10){
            System.err.println("Brak kawy! Uzupelnij skladniki");
            System.exit(0);
        }
        if(super.getMililitersOfMilk()<150){
            System.err.println("Brak mleka! Uzupelnij skladniki");
            System.exit(0);
        }
        if(super.getGramsOfSugar()<10){
            System.err.println("Brak cukru! Uzupelnij skladniki");
            System.exit(0);
        }
        if(super.getMililtersOfWater()<30){
            System.err.println("Brak wody! Uzupelnij skladniki");
            System.exit(0);
        }
    }

    void yourCoffee(){
        double tempWater, tempMilk, pressWater, pressMilk;
        String nameOfYourCoffee;

        coffeeGrinding();
        coffeeSpilling();

        System.out.println("Ustaw temperature wody: ");
        tempWater = scanner.nextDouble();
        super.setWaterTemperature(tempWater);
        System.out.println("Ustaw temperature mleka: ");
        tempMilk = scanner.nextDouble();
        super.setMilkTemperature(tempMilk);

        System.out.println("Ustaw cisnienie wody: ");
        pressWater = scanner.nextDouble();
        super.setWaterPressure(pressWater);
        System.out.println("Ustaw cisnienie mleka: ");
        pressMilk = scanner.nextDouble();
        super.setMilkTemperature(pressMilk);

        System.out.println("Podgrzewanie wody do temperatury " + super.getWaterTemperature());
        System.out.println("Podgrzewanie mleka do temperatury: " + super.getMilkTemperature());
        System.out.println("Kawa gotowa!");
    }

    void finish(String nameOfCoffee){
        System.out.println(nameOfCoffee + " GOTOWE");
    }
}
