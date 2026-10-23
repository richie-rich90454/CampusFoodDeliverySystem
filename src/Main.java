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

    }
}