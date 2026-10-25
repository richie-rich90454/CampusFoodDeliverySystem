import java.util.Scanner;

public class InputOutput {
    public static Scanner input=new Scanner(System.in);
    public static String validEmailInput(){
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
    public static String safeStringInput(){
        boolean isValid=false;
        String stringInput=input.nextLine();
        while (!isValid){
            if (!stringInput.trim().equals("")){
                isValid=true;
            }
            else {
                System.out.print("Please enter a valid String input: ");
                stringInput=input.nextLine();
            }
        }
        return stringInput;
    }
    public static int safeIntInput(){
        boolean isValid=false;
        int intInput=0;
        while (!isValid){
            String stringInput=input.nextLine();
            try{
                intInput=Integer.parseInt(stringInput);
                isValid=true;
            }
            catch (NumberFormatException exception){
                System.out.print("Please enter a valid integer input: ");
            }
        }
        return intInput;
    }
    public static int safeIntInput(int min, int max){
        boolean isValid=false;
        int intInput=0;
        while (!isValid){
            String stringInput=input.nextLine();
            try{
                intInput=Integer.parseInt(stringInput);
                isValid=(intInput>=min&&intInput<=max);
            }
            catch (NumberFormatException exception){
                System.out.print("Please enter a valid integer input: ");
            }
        }
        return intInput;
    }
    public static boolean safeBooleanInput(){
        boolean isValid=false;
        boolean booleanInput=false;
        while (!isValid){
            String stringInput=input.nextLine();
            try{
                booleanInput=Boolean.parseBoolean(stringInput);
            }
            catch (NumberFormatException exception){
                System.out.print("Please enter a valid boolean input: ");
            }
        }
        return booleanInput;
    }
}
