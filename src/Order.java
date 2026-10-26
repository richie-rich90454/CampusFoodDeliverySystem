import java.util.ArrayList;
import java.util.HashMap;

public class Order{
    public String orderID;
    public ArrayList<Dish> dishes;
    public double total;
    public Customer customer;
    public String restaurantName;
    public Order(String orderID, ArrayList<Dish> dishes, Customer customer, Restaurant restaurant){
        this.orderID=orderID;
        this.dishes=dishes;
        this.total=0;
        for (Dish dish: dishes){
            total+=dish.getPrice();
        }
        if (total<25){
            total+=2.5;
        }
        this.customer=new Customer(customer.getName(), customer.getUserID(), customer.getEmail(), customer.getRoomNumber());
        restaurant.setSoldTimes(restaurant.getSoldTimes()+1);
        this.restaurantName=restaurant.getName();
    }
    public String toString(){
        String returnString="Order: "+orderID+"\n";
        returnString+="Customer: "+customer.getName()+"\n";
        returnString+="Customer Email: "+customer.getEmail()+"\n";
        returnString+="Restaurant: "+restaurantName+"\n";
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
        returnString+="Total: $"+total+" (Note: if your order is above $25, you are not required to pay the $2.5 delivery fee)\n";
        return returnString;
    }
    public String getOrderID(){
        return orderID;
    }
}
