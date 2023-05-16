package com.view;
import com.config.cConfig;
import java.util.Scanner;

public class cView {

    private static Scanner input = new Scanner(System.in);

    public static void user() {
        // Header
        System.out.println("\n=== LOGIN ===");
        // Isi
        
        System.out.print("username :" );
        String logUsername = input.nextLine();
        System.out.print("password :" );
        String logPass = input.next();
        System.out.println(cConfig.user(logUsername));

    }

    public static void getAllData() {
        // Header
        System.out.println("\n=== DATA CANDIDATE ===");
        // Isi
        
        System.out.println(cConfig.getAllData());

    }
    
}
