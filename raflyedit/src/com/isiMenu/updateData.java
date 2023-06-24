package com.isiMenu;
import java.util.Scanner;
import com.view.cView;

public class updateData {
    public static void updateData() {
        while(true) {
            System.out.print("\n===== PILIH DATA YANG INGIN DI UBAH =====\n"
            + "1. Data User\n"
            + "2. Data Event\n"
            + "3. Data Candidate\n"
            + "0. Exit\n"
            + "Pilih [1/2/3/4/5] :");
            Scanner input = new Scanner(System.in);
            String pilihan = input.next();
            if (pilihan.equalsIgnoreCase("0")) {
            break;
            }
            switch(pilihan) {
            case"1":
                cView.upDataUser();
            break;
            case "2":
                cView.upDataEvent();
            break;
            case "3":
                cView.upDataCandidate();
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
 