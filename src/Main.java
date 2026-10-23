import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.println("Welcome to the campus food delivery system!");
        System.out.print("Please enter your name: ");
        String username=input.nextLine();
        System.out.print("Please enter your ID: ");
        String userID=input.nextLine();
        String email=InputOutput.validEmailInput();
        System.out.print("Please enter your delivery location: ");
        int location=input.nextInt();
        input.nextLine();
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
        Restaurant busanBowl=new Restaurant("Busan Bowl", true, "Korean", null, 0);
        ArrayList<Dish> busanBowlDishes=new ArrayList<>();
        busanBowlDishes.add(new Dish("Kimbap rolls", 19.88));
        busanBowlDishes.add(new Dish("Fried Chicken", 17.35));
        busanBowlDishes.add(new Dish("Busan Specialty", 20.26));
        busanBowl.setDishes(busanBowlDishes);
        restaurants.add(busanBowl);
        //stuff for restaurant 3
    }
}