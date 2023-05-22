package com.isiMenu;
import java.util.Scanner;

public class updateData {
    public static void updateData() {
        while(true) {
            System.out.print("\n===== PILIH TABEL YANG INGIN DI UBAH =====\n"
            + "1. Data Candidate\n"
            + "2. Data Event\n"
            + "3. Data User\n"
            + "4. Data Event Candidate\n"
            + "5. Data Vote\n"
            + "0. Exit\n"
            + "Pilih [1/2/3/4/5] :");
            Scanner input = new Scanner(System.in);
            String pilihan = input.next();
            if (pilihan.equalsIgnoreCase("0")) {
            break;
            }
            switch(pilihan) {
            case"1":
            
            break;
            case "2":
            
            break;
            case "3":
            
            break;
            case"4":
            
            break;
            case"5":
            
            break;
            case "0":
            System.out.println("Exit");
            break;            
            default:
            System.out.println("Pilihan Salah!!!");
            break;
            }
        }
    }
}
 