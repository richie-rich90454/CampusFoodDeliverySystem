import java.util.ArrayList;

public class Restaurant {
    private String name;
    private boolean isOpen;
    private String category;
    private ArrayList<Dish> dishes;
    private int soldTimes;
    public Restaurant(String name, boolean isOpen, String category, ArrayList<Dish> dishes, int soldTimes) {
        this.name=name;
        this.isOpen=isOpen;
        this.category=category;
        this.dishes=dishes;
        this.soldTimes=soldTimes;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public boolean isOpen(){
        return isOpen;
    }
    public void setOpen(boolean open){
        isOpen=open;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category=category;
    }
    public ArrayList<Dish> getDishes(){
        return dishes;
    }
    public void setDishes(ArrayList<Dish> dishes){
        this.dishes=dishes;
    }
    public void addDish(Dish dish){
        dishes.add(dish);
    }
    public void removeDish(Dish dish){
        dishes.remove(dish);
    }
    public int getSoldTimes(){
        return soldTimes;
    }
    public void setSoldTimes(int soldTimes){
        this.soldTimes=soldTimes;
    }
    public String toString(){
        String openStatus="CLOSED";
        if (isOpen){
            openStatus="OPEN";
        }
        String numberOfOrders="new - no orders yet";
        if (soldTimes>0){
            numberOfOrders=soldTimes+" order(s)";
        }
        return name+" | "+category+" | "+openStatus+" | "+numberOfOrders+" | "+dishes.size()+" dish(es)";
    }
    public String getMenu(){
        String menuString=name+" menu: \n";
        for (int i=1;i<=dishes.size();i++){
            menuString+=i+". "+dishes.get(i-1).getName()+"\t$"+dishes.get(i-1).getPrice()+"\n";
        }
        return menuString;
    }
}
