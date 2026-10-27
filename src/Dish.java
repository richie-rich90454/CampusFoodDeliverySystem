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
        if (dish==null){
            return false;
        }
        if (this.name.equals(dish.name)&&this.price==dish.price){
            return true;
        }
        return false;
    }
    @Override
    public boolean equals(Object dish){
        //reference: https://www.geeksforgeeks.org/java/writer-getclass-method-in-java-with-examples/
        if (dish==null){
            return false;
        }
        boolean isCorrectClass=dish.getClass().equals(Dish.class);
        Dish disToCompare=(Dish)dish;
        if (isCorrectClass&&this.equals(disToCompare)){
            return true;
        }
        return false;
    }
}
