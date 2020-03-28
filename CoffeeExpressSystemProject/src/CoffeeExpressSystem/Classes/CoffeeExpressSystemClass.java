package CoffeeExpressSystem.Classes;

import java.util.Scanner;

public class CoffeeExpressSystemClass extends ExpressInterface{

    public static void main(String[] args) {

        int yourChoiceInMenu;

        Scanner scanner = new Scanner(System.in);
        ExpressInterface expressInterface = new ExpressInterface();

        expressInterface.turnOnExpress();

        outer:
        while(true) {
            expressInterface.viewMainMenu();
            yourChoiceInMenu = scanner.nextInt();

            if (yourChoiceInMenu == 1) {
                expressInterface.chooseCoffee();
                int yourNumberOfCoffee = scanner.nextInt();
                if(yourNumberOfCoffee == 1){
                    expressInterface.cappucino();
                }
                else if(yourNumberOfCoffee == 2){
                    expressInterface.americano();
                }
                else if(yourNumberOfCoffee == 3){
                    expressInterface.latteMachiato();
                }
                else if(yourNumberOfCoffee == 4){
                    expressInterface.latte();
                }
                else if(yourNumberOfCoffee == 5){
                    expressInterface.espresso();
                }
                else if(yourNumberOfCoffee == 6) {
                    System.out.println("Rozpoczeto parzenie kawy...");
                    expressInterface.selectAmountOfCoffee();
                    expressInterface.selectAmountOfMilk();
                    expressInterface.selectAmountOfSugar();
                    expressInterface.yourCoffee();
                }
            } else if (yourChoiceInMenu == 2) {
                expressInterface.ingredientsShortageAlert();
                expressInterface.addIngredients();
                continue outer;
            } else if (yourChoiceInMenu == 3) {
                System.out.println("Autor: Przemysław Cukierski, 2019");
                expressInterface.turnOffExpress();
                break outer;
            }
            else{
                System.err.println("Niepoprawny wybor! Wybierz inna opcje");
            }
        }
    }
}



