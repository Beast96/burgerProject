package controller;

import model.Burger;
import model.Topping;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {

    private static Scanner input;
    private static ArrayList<Burger> allBurgers;
    private static ArrayList<Topping> allToppings;

    public Restaurant(){
        allBurgers = Fridge.prepareBurgers();
        allToppings = Fridge.prepareToppings();
    }

    public static ArrayList<Burger> getBurgers(){
        return allBurgers;
    }

    public static ArrayList<Topping> getToppings(){return allToppings; }

    public static Burger selectBurger(){
        Burger burger;
        System.out.print("Select: ");

        try{
            input  = new Scanner(System.in);

            int choice = input.nextInt();

            // if user chooses the wrong burger.
            if (choice > 3 || choice < 1){
                Error("Please select the burger shown in the list.");
                burger = selectBurger();
            }else{
                burger = allBurgers.get(choice - 1);
            }

        }catch (Exception e){
            Error("Please select the burger shown in the list.");
            burger = selectBurger();
        }

        return burger;
    }


    public static void chooseToppings(Burger selectedBurger){

        System.out.print(String.format("Choose any %d toppings : ",selectedBurger.getMaxToppings()-selectedBurger.getToppings().size()));

        try{
            input = new Scanner(System.in);
            int choice = input.nextInt();

            if(choice==0){
                return;
            }else if(choice > allToppings.size() || choice < 1){
                Error("Please select the right topping.");
                chooseToppings(selectedBurger);
            }else{
                selectedBurger.setToppings(allToppings.get(choice-1));
            }

            if(selectedBurger.getMaxToppings() !=  selectedBurger.getToppings().size()){
                chooseToppings(selectedBurger);
            }

        }catch (Exception e){
            Error("Please select the right topping.");
            chooseToppings(selectedBurger);
        }

    }

    private static void Error(String error){
        System.out.println(error);
    }
}
