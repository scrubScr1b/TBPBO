package com.isiMenu;
import java.util.Scanner;
import com.view.cView;

public class allData {
    public static void allData() {
        while(true) {
            System.out.print("\n=============================================\n"+
            "\n====            PILIHAN DATA             ====\n" +
            "\n=============================================\n"
            + "1. Lihat Semua Data Candidate\n"
            + "2. Lihat Semua Data Event\n"
            + "3. Lihat Semua Data Event Candidate\n"
            + "4. Lihat Semua Data User\n"
            + "5. Lihat Semua Data Vote\n"
            + "6. Lihat Hasil Vote\n"
            + "7. Lihat Hasil Vote PerEvent\n"
            + "8. Lihat Hasil Pilkatsuk \n"
            + "0. Exit\n"
            + "Pilih [1/2/3/4/5/6/7] :");
            Scanner input = new Scanner(System.in);
            String pilihan = input.next();
            if (pilihan.equalsIgnoreCase("0")) {
            break;
            }
            switch(pilihan) {
        case"1":
            cView.getAllDataCandidate();
            break;
        case "2":
            cView.getAllDataEvent();
            break;
        case "3":
            cView.getAllDataEventCandidate();
            break;
        case "4":
            cView.getAllDataUser();
            break;
        case "5":
            cView.getAllDataVote();
            break;
        case "6":
           cView.getAllResultVote();
           break;
        case "7":
           cView.getAllResultPerEvent();
            break;
        case "8":
           pilkatsuk.hasilPilkatsuk();
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
 