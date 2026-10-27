import java.util.ArrayList;
import java.util.HashMap;

public class Order{
    private String orderID;
    private ArrayList<Dish> dishes;
    private double total;
    private Customer customer;
    private Restaurant restaurant;
    private boolean hasExtraDeliveryFee;
    public Order(String orderID, ArrayList<Dish> dishes, Customer customer, Restaurant restaurant){
        this.orderID=orderID;
        this.dishes=dishes;
        this.total=0;
        this.hasExtraDeliveryFee=false;
        for (Dish dish: dishes){
            total+=dish.getPrice();
        }
        if (total<25){
            total+=2.5;
            hasExtraDeliveryFee=true;
        }
        this.customer=new Customer(customer.getName(), customer.getUserID(), customer.getEmail(), customer.getRoomNumber());
        restaurant.setSoldTimes(restaurant.getSoldTimes()+1);
        this.restaurant=restaurant;
    }
    public String toString(){
        String returnString="Order: "+orderID+"\n";
        returnString+="Customer: "+customer.getName()+"\n";
        returnString+="Customer Email: "+customer.getEmail()+"\n";
        returnString+="Restaurant: "+restaurant.getName()+"\n";
        returnString+="Delivers to: "+customer.getRoomNumber()+"\nItems: \n";
        HashMap<Dish, Integer> dishNumbers=new HashMap<>();
        for (Dish dish: dishes){
            //refer to https://www.w3schools.com/java/java_hashmap.asp
            dishNumbers.put(dish, dishNumbers.getOrDefault(dish,0)+1);
        }
        for (Dish dish: dishNumbers.keySet()){
            if (dishNumbers.get(dish)==0){
                continue;
            }
            returnString+=dishNumbers.get(dish)+" x "+dish.getName()+"\n";
        }
        if (hasExtraDeliveryFee){
            returnString+="Delivery fee: $2.5\n";
        }
        returnString+="Total: $"+total+"\n";
        return returnString;
    }
    public String getOrderID(){
        return orderID;
    }
    public static int numberOfACertainDish(ArrayList<Dish> dishes, Dish dishToSearch){
        HashMap<Dish, Integer> dishNumbers=new HashMap<Dish, Integer>();
        for (Dish dish: dishes){
            dishNumbers.put(dish, dishNumbers.getOrDefault(dish,0)+1);
        }
        return dishNumbers.getOrDefault(dishToSearch, 0);
    }
}
