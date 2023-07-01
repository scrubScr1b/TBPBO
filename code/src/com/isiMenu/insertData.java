package com.isiMenu;
import java.util.Scanner;
import com.view.cView;

public class insertData {
    public static void insertData() {
        while(true) {
            System.out.print("\n===== PILIH TABEL YANG INGIN DI INPUT =====\n"
            + "1. Input Data Candidate\n"
            + "2. Input Data Event\n"
            + "3. Input Data User\n"
            + "0. Exit\n"
            + "Pilih [1/2/3/4/5] :");
            Scanner input = new Scanner(System.in);
            String pilihan = input.next();
            if (pilihan.equalsIgnoreCase("0")) {
            break;
            }
            switch(pilihan) {
            case"1":
            cView.insDataCandidate();
            break;
            case "2":
            cView.insDataEvent();
            break;
            case "3":
            cView.insDataUser();
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
 