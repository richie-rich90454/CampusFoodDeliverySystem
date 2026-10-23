import java.util.ArrayList;

public class Order{
    public String orderID;
    public ArrayList<Dish> dishes;
    public double total;
    public Customer customer;
    public Order(String orderID, ArrayList<Dish> dishes, Customer customer){
        this.orderID=orderID;
        this.dishes=dishes;
        this.total=0;
        for (Dish dish: dishes){
            total+=dish.getPrice();
        }
        this.customer=new Customer(customer.getName(), customer.getUserID(), customer.getEmail(), customer.getRoomNumber());
    }
}
