package com.isiMenu;
import java.util.Scanner;
import com.view.cView;

public class updateData {
    public static void updateData() {
        while(true) {
            System.out.print("\n===== PILIH TABEL YANG INGIN DI UBAH =====\n"
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
            while(true) {
                System.out.print("\n===== INPUT ID USER YANG INGIN DI UBAH =====\n"
                + "Input ID :");
                String idUser = input.next();
                if (idUser.equalsIgnoreCase("0")) {
                break;
                }
                switch(idUser) {
                case"1":
                    while(true) {
                    System.out.println("\n===== PILIH OPSI YANG INGIN DI UBAH =====\n"
                    +"1.Nama User\n"
                    +"2.Password User\n"
                    +"3.Role User\n"
                    + "Pilih [1/2/3] :");
                    String upDataUser = input.next();
                    if (idUser.equalsIgnoreCase("0")) {
                        break;
                        }
                        switch(upDataUser) {
                            case"1":
                            cView.upDataUser();
                        }
                    
                break;
                }               
                break;
                case "2":
                
                break;
                case "3":
                
                break;
                case "0":
                System.out.println("Exit");
                break;            
                default:
                System.out.println("Pilihan Salah!!!");
                break;
                }
            }
            break;
            case "2":
            
            break;
            case "3":
            
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
 