package com.page;
import java.util.Scanner;
import com.view.cView;

public class login {

    public static void main(String[] args) {
        while(true) {
            
            System.out.print("\n===== WELCOME =====\n"
            + "1. Login\n"
            + "2. Register\n"
            + "0. Exit App\n"
            + "Pilih [1/2] :");
            
            Scanner input = new Scanner(System.in);
            String pilihan = input.next();

            if ( pilihan.equalsIgnoreCase("0")) {
                System.out.println("Terimakasih!!");
                break;
            }

            switch (pilihan) {
                case "1":
                    cView.user();
                    menu.read();
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
            // input.close();
        }
    }
    
}
