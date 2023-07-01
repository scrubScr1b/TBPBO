package com.isiMenu;

import java.util.Scanner;

import com.view.cView;

public class pilkatsuk {
    public static void hasilPilkatsuk() {
            while(true) {
            
            System.out.print("\n=============================================\n"+
            "\n===             HASIL PILKATSUK           ===\n" +
            "\n=============================================\n"
            + "1. Lihat Pemenang Pilkatsuk \n"
            + "2. Lihat Pemenang Pilkatsuk Per Desa \n"
            + "0. Exit\n"
            + "Pilih [1/2] :");
            
            Scanner input = new Scanner(System.in);
            String pilihan = input.next();

            if ( pilihan.equalsIgnoreCase("0")) {
                break;
            }

            switch (pilihan) {
                case "1":
                    cView.pemenangPilkatsuk();              
                    break;
                case "2":
                    cView.pemenangPilkatsukPerDesa(); 
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
