import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.println("Welcome to the campus food delivery system!");
        System.out.print("Please enter your name: ");
        String username=InputOutput.safeStringInput();
        System.out.print("Please enter your ID: ");
        String userID=InputOutput.safeStringInput();
        String email=InputOutput.validEmailInput();
        System.out.print("Please enter your delivery location: ");
        int location=InputOutput.safeIntInput();
        Customer customer=new Customer(userID,username,email,location);
        customer.printWelcomeMessage();
        ArrayList<Restaurant> restaurants=new ArrayList<Restaurant>();
        //stuff for restaurant 1
        Restaurant coolPizza=new Restaurant("Cool Pizza", true, "Italian", null, 0);
        ArrayList<Dish> coolPizzaDishes=new ArrayList<>();
        coolPizzaDishes.add(new Dish("Margherita Pizza", 12.50));
        coolPizzaDishes.add(new Dish("Fettuccine Alfredo", 14.00));
        coolPizzaDishes.add(new Dish("Tiramisu", 6.50));
        coolPizzaDishes.add(new Dish("Medium-well Steak",20.26));
        coolPizza.setDishes(coolPizzaDishes);
        restaurants.add(coolPizza);
        //stuff for restaurant 2
        Restaurant busanBowl=new Restaurant("Busan Bowl", true, "Korean", null, 1);
        ArrayList<Dish> busanBowlDishes=new ArrayList<>();
        busanBowlDishes.add(new Dish("Kimbap rolls", 19.88));
        busanBowlDishes.add(new Dish("Fried Chicken", 17.35));
        busanBowlDishes.add(new Dish("Busan Specialty", 20.26));
        busanBowl.setDishes(busanBowlDishes);
        restaurants.add(busanBowl);
        //stuff for restaurant 3
        Restaurant sunsetPancakes=new Restaurant("Sunset Pancakes", true, "American", null, 0);
        ArrayList<Dish> sunsetPancakesDishes=new ArrayList<>();
        sunsetPancakesDishes.add(new Dish("Maple Syrup with Pancakes", 9.95));
        sunsetPancakesDishes.add(new Dish("French Fries", 9.90));
        sunsetPancakesDishes.add(new Dish("Chicken Sandwich", 10.15));
        sunsetPancakes.setDishes(sunsetPancakesDishes);
        restaurants.add(sunsetPancakes);
        System.out.println("---------------Menu---------------");
        for (Restaurant restaurant:restaurants){
            System.out.println(restaurant.toString());
        }
        System.out.print("Pick a restaurant (1-3): ");
        int userRestaurantChoice=InputOutput.safeIntInput();
        Restaurant userChoiceRestaurant=restaurants.get(userRestaurantChoice);
        System.out.println(userChoiceRestaurant.getMenu());

    }
}