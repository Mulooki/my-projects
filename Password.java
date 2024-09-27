import java.util.Scanner;

public class Password {
    public static void main(String[] args){
        Scanner Scanner = new Scanner(System.in);
        String correctpassword="sam425";
        int attempts = 4;
        while (attempts > 0){
            System.out.println("Enter your password:");
            String input = Scanner.nextLine();
            if (input.equals(correctpassword)){
                System.out.println("success! correct password");
            }else {
                attempts--;
                System.out.println("incorrect password.attemps remaining: " + attempts);}
             if( attempts ==0){
                System.out.println("Account blocked: " + attempts);}
            Scanner.close();
        }
    }
    
}
