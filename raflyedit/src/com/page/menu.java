package com.page;
import java.util.Scanner;
import com.isiMenu.allData;
import com.isiMenu.insertData;
import com.isiMenu.updateData;
import com.view.cView;

public class menu {
    public static void read() {
            while(true) {
            
            System.out.print("\n======= MENU =======\n"
            + "1. Lihat Semua Data \n"
            + "2. Lihat Detail Data \n"
            + "3. Input Data Master\n"
            + "4. Ubah Data \n"
            + "0. Exit\n"
            + "Pilih [1/2] :");
            
            Scanner input = new Scanner(System.in);
            String pilihan = input.next();

            if ( pilihan.equalsIgnoreCase("0")) {
                break;
            }

            switch (pilihan) {
                case "1":
                    allData.allData();                    
                    break;
                case "2":
                    System.out.println("Input Keyword");
                    cView.getAllDataDetail();
                    break;
                case "3":
                    insertData.insertData();
                    break;
                case "4":
                    updateData.updateData();
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
 