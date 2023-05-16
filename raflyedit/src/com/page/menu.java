package com.page;
import java.util.Scanner;
import com.view.cView;

public class menu {
    public static void menu() {
            while(true) {
            
            System.out.print("\n===== MENU =====\n"
            + "1. Lihat Semua Data Candidate\n"
            + "2. Lihat Semua Data Event\n"
            + "3. Lihat Semua Data Event Candidate\n"
            + "4. Lihat Semua Data User\n"
            + "5. Lihat Semua Data Vote\n"
            + "0. Exit\n"
            + "Pilih [1/2/3/4/5] :");
            
            Scanner input = new Scanner(System.in);
            String pilihan = input.next();

            if ( pilihan.equalsIgnoreCase("0")) {
                System.out.println("Terimakasih!!");
                break;
            }

            switch (pilihan) {
                case "1":
                    cView.getAllData();
                    break;
                case "2":
                    System.out.println("Lihat Semua Data Event");
                    break;
                case "3":
                    System.out.println("Lihat Semua Data Event Candidate");
                    break;
                case "4":
                    System.out.println("Lihat Semua Data User");
                    break;
                case "5":
                    System.out.println("Lihat Semua Data Vote");
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
 