package com.page;

import java.util.Scanner;

import com.view.cView;

public class welcome {

    public static void main(String[] args) {
        while(true) {
            
            System.out.print( "\n=============================================\n"+
            "\n==== WELCOME TO OUR VOTING CONSOLE APPS =====\n" +
            "\n=============================================\n"
            + "1. Login Page\n"
            + "2. Create Account\n"
            + "0. Exit App\n"
            + "Pilih [1/2] :");
            
            Scanner input = new Scanner(System.in);
            String pilihan = input.nextLine();

            if ( pilihan.equalsIgnoreCase("0")) {
                System.out.println("Terimakasih!!");
                break;
            }

            switch (pilihan) {
                case "1":
                    login.ShowLoginPage();
                    break;
                case "2":
                    cView.register();
                    break;
                case "0":
                    System.out.println("Exit App");
                    break;            
                default:
                    System.out.println("Pilihan Salah!!!");
                    break;
            }
            
            // Close Scanner
            input.close();
        }
    }
    
}
