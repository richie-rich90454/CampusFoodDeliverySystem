public class Customer{
    private String name;
    private String userID;
    private String email;
    private Order order;
    private int roomNumber;
    public Customer(String name, String userID, String email, int roomNumber){
        this.name=name;
        this.userID=userID;
        this.email=email;
        this.order=null;
        this.roomNumber=roomNumber;
    }
    public String getName(){
        return name;
    }
    public String getUserID(){
        return userID;
    }
    public String getEmail(){
        return email;
    }
    public Order getOrder(){
        return order;
    }
    public int getRoomNumber(){
        return roomNumber;
    }
    public void printWelcomeMessage(){
        System.out.println("Welcome, "+name+"! Your food goes to "+roomNumber);
    }
}
