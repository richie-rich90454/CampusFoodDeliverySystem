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

}
