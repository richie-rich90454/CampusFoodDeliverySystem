import java.util.Scanner;

public class InputOutput {
    public static String validEmailInput(){
        Scanner input=new Scanner(System.in);
        boolean isValid=false;
        String email="";
        while (!isValid){
            System.out.print("Please enter your email: ");
            email=input.nextLine();
            if (email.contains("@")){
                if (email.substring(email.indexOf("@")).contains(".")){
                    isValid=true;
                }
            }
        }
        return email;
    }
}
