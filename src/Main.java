import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        int orderIndex=101;
        System.out.println("Welcome to the campus food delivery system!");
        System.out.print("Please enter your name: ");
        String username=InputOutput.safeStringInput();
        System.out.print("Please enter your ID: ");
        String userID=InputOutput.safeStringInput();
        String email=InputOutput.validEmailInput();
        System.out.print("Please enter your delivery location: ");
        int location=InputOutput.safeIntInput();
        Customer customer=new Customer(username,userID,email,location);
        customer.printWelcomeMessage();
        ArrayList<Restaurant> restaurants=new ArrayList<Restaurant>();
        //stuff for restaurant 1
        Restaurant coolPizza=new Restaurant("Cool Pizza", true, "Italian", null, 0);
        ArrayList<Dish> coolPizzaDishes=new ArrayList<Dish>();
        coolPizzaDishes.add(new Dish("Margherita Pizza", 12.50));
        coolPizzaDishes.add(new Dish("Fettuccine Alfredo", 14.00));
        coolPizzaDishes.add(new Dish("Medium-well Steak",20.26));
        coolPizza.setDishes(coolPizzaDishes);
        restaurants.add(coolPizza);
        //stuff for restaurant 2
        Restaurant busanBowl=new Restaurant("Busan Bowl", true, "Korean", null, 1);
        ArrayList<Dish> busanBowlDishes=new ArrayList<Dish>();
        busanBowlDishes.add(new Dish("Kimbap rolls", 19.88));
        busanBowlDishes.add(new Dish("Fried Chicken", 17.35));
        busanBowlDishes.add(new Dish("Busan Specialty", 20.26));
        busanBowl.setDishes(busanBowlDishes);
        restaurants.add(busanBowl);
        //stuff for restaurant 3
        Restaurant sunsetPancakes=new Restaurant("Sunset Pancakes", true, "American", null, 0);
        ArrayList<Dish> sunsetPancakesDishes=new ArrayList<Dish>();
        sunsetPancakesDishes.add(new Dish("Maple Syrup with Pancakes", 9.95));
        sunsetPancakesDishes.add(new Dish("French Fries", 9.90));
        sunsetPancakesDishes.add(new Dish("Chicken Sandwich", 10.15));
        sunsetPancakes.setDishes(sunsetPancakesDishes);
        restaurants.add(sunsetPancakes);
        boolean continueOrders=true;
        while (continueOrders){
            System.out.println("---------------Menu---------------");
            for (Restaurant restaurant:restaurants){
                System.out.println(restaurant.toString());
            }
            System.out.print("Pick a restaurant (1-3): ");
            int userRestaurantChoice=InputOutput.safeIntInput(1,3)-1;
            Restaurant userChoiceRestaurant=restaurants.get(userRestaurantChoice);
            if (!userChoiceRestaurant.isOpen()){
                System.out.println("Restaurant closed.");
                continue;
            }
            System.out.println(userChoiceRestaurant.getMenu());
            System.out.print("Do you want to order multiple different dishes? (true/false): ");
            boolean multipleDifferentDishes=InputOutput.safeBooleanInput();
            ArrayList<Dish> dishesOrdered=new ArrayList<Dish>();
            if (multipleDifferentDishes){
                boolean continueOrdering=true;
                while (continueOrdering){
                    System.out.print("Pick a dish (1-3): ");
                    int dishChoice=InputOutput.safeIntInput(1,3)-1;
                    System.out.print("How many? (1-10): ");
                    int dishQuantity=InputOutput.safeIntInput(1,10);
                    boolean isPastOrderQuantity=(Order.numberOfACertainDish(dishesOrdered, userChoiceRestaurant.getDishes().get(dishChoice))+dishQuantity>10);
                    if (isPastOrderQuantity){
                        System.out.println("Note: You could at max only order 10 instances of the same dish per order.");
                        System.out.print("Do you want to continue ordering? (true/false): ");
                        continueOrdering=InputOutput.safeBooleanInput();
                        continue;
                    }
                    for (int i=0;i<dishQuantity;i++){
                        dishesOrdered.add(userChoiceRestaurant.getDishes().get(dishChoice));
                    }
                    System.out.print("Do you want to continue ordering? (true/false): ");
                    continueOrdering=InputOutput.safeBooleanInput();
                }
            }
            else{
                System.out.print("Pick a dish (1-3): ");
                int dishChoice=InputOutput.safeIntInput(1,3)-1;
                System.out.print("How many? (1-10): ");
                int dishQuantity=InputOutput.safeIntInput(1,10);
                for (int i=0;i<dishQuantity;i++){
                    dishesOrdered.add(userChoiceRestaurant.getDishes().get(dishChoice));
                }
            }
            Order userOrder=new Order("ORD-"+orderIndex, dishesOrdered, customer, userChoiceRestaurant);
            orderIndex++;
            System.out.print("\n\n"+userOrder);
            System.out.print("Has the food been delivered? (y/n): ");
            String foodDeliveryStatus=InputOutput.safeStringInput();
            while (!foodDeliveryStatus.equals("y")){
                System.out.print("Has the food been delivered? (y/n): ");
                foodDeliveryStatus=InputOutput.safeStringInput();
                if (!foodDeliveryStatus.equals("y")){
                    System.out.print(userOrder.getOrderID()+" - still on the way.\n\n");
                }
            }
            System.out.print(userOrder.getOrderID()+" - delivered.\n\n");
            System.out.print("Do you want to make another order? (true/false): ");
            continueOrders=InputOutput.safeBooleanInput();
            System.out.println("\n\n\n");
        }
        System.out.println("Thank your for ordering, "+username+", enjoy your meal!");
    }
}