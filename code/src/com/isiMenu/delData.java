package com.isiMenu;
import java.util.Scanner;
import com.view.cView;

public class delData {
    public static void delData() {
        while(true) {
            System.out.print("\n===== PILIH TABEL YANG INGIN DI DELETE =====\n"
            + "1. Delete Data User\n"
            + "2. Delete Data Candidate\n"
            + "3. Delete Data Event\n"
            + "0. Exit\n"
            + "Pilih [1/2/3] :");
            Scanner input = new Scanner(System.in);
            String pilihan = input.next();
            if (pilihan.equalsIgnoreCase("0")) {
            break;
            }
            switch(pilihan) {
            case"1":
            cView.delDataUser();
            break;
            case "2":
            cView.delDataCandidate();
            break;
            case "3":
            cView.delDataEvent();
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
 