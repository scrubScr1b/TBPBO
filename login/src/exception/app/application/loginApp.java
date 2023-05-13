package exception.app.application;

import java.util.Scanner;

import exception.app.data.LoginRequest;
import exception.app.exception.MyCustomException;
import exception.app.utils.ValidationUtils;

public class loginApp {
    
    public static void main(String[] args) {

        // Connect to Database 
        DatabaseApp.ConnectDB("rafly", "1234");

        Scanner inputScanner = new Scanner(System.in);
        
        try {
            System.out.println(" ====== LOGIN FORM ====== ");
            System.out.println("Input Username");
            String username = inputScanner.nextLine();

            System.out.println("Input Password");
            String password = inputScanner.nextLine();

            // Validasi Login
            LoginRequest request = new LoginRequest();
            request.username = username;
            request.password = password;

            ValidationUtils.LoginValidate(request);

            System.out.println("=== LOGIN SUCCESFULL === ");
            System.out.println("======================== ");

            HomepageApp.HomePage();           

            

        }catch (MyCustomException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } finally {
            inputScanner.close();
        }
        
    }
    
    
}
