public class Dish{
    private String name;
    private double price;
    public Dish(String name, double price){
        this.name=name;
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public boolean equals(Dish dish){
        if (this.name.equals(dish.name)&&this.price==dish.price){
            return true;
        }
        return false;
    }
}
