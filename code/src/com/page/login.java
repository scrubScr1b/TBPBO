package com.page;
import java.util.Scanner;

import com.config.cConfig;
import com.view.cView;

public class login {

    public static void ShowLoginPage() {
        
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("\n=============================================\n"+
            "\n====                LOGIN                ====\n" +
            "\n=============================================\n");

        System.out.print("USER ID :");
        String userid = inputScanner.nextLine();

        System.out.print("PASSWORD :");
        String pass = inputScanner.nextLine();

        cConfig LoginUsecase = new cConfig();
        String sValidate = LoginUsecase.LoginValidate(userid, pass);

        if (sValidate.equals("")) {
            System.out.println();
            System.out.println("LOGIN SUCCESS !!!");
            menu.menuUser();
        } else {
            System.out.println();
            System.out.println("LOGIN FAILED - " +sValidate);
            welcome.main(null);
        }
        // close scanner tp kayanya gausah
        // inputScanner.close();

    }
    
}