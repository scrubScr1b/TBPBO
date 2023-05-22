package com.view;
import com.config.cConfig;
import java.util.Scanner;

public class cView {

    private static Scanner input = new Scanner(System.in);

    public static void user() {
        // Header
        System.out.println("\n=== MASUK ===");
        // Isi
        
        System.out.print("username :" );
        String logUsername = input.next();
        System.out.print("password :" );
        String logPass = input.next();
        // System.out.println(cConfig.user(logUsername, logPass));

    }

    public static void register() {
        // Header
        System.out.println("\n=== BUAT AKUN ===");
        // Isi
        
        System.out.print("username : " );
        String regUsername = input.next();
        System.out.print("password : " );
        String regPass = input.next();

        if (cConfig.register(regUsername, regPass) ){
            System.out.println("user berhasil di tambahkan!!");
        } else {
            System.out.println("user gagal di tambahkan!!");
        }

    }

    public static void getAllDataCandidate() {
        // Header
        System.out.println("\n=== DATA KANDIDAT ===");
        // Isi
        
        System.out.println(cConfig.getAllDataCandidate());

    }

    public static void getAllDataEvent() {
        // Header
        System.out.println("\n=== DATA EVENT ===");
        // Isi
        
        System.out.println(cConfig.getAllDataEvent());

    }

    public static void getAllDataEventCandidate() {
        // Header
        System.out.println("\n=== DATA CANIDATE PER EVENT ===");
        // Isi
        
        System.out.println(cConfig.getAllDataEventCandidate());

    }

    public static void getAllDataUser() {
        // Header
        System.out.println("\n=== DATA USER ===");
        // Isi
        
        System.out.println(cConfig.getAllDataUser());

    }

    public static void getAllDataVote() {
        // Header
        System.out.println("\n=== DATA HASIL VOTE ===");
        // Isi
        
        System.out.println(cConfig.getAllDataVote());

    }

    public static void getAllDataDetail() {
        System.out.print("Nama : " );
        String name = input.next();

        System.out.println("\nHasil Data");
        System.out.println(cConfig.getAllDataDetail(name));

    }

    public static void insDataCandidate() {
        // Header
        System.out.println("\n=== INPUT DATA KANDIDAT ===");
        // Isi
        
        System.out.print("Nama Kandidat : " );
        String namaCandidate = input.next();

        if (cConfig.insDataCandidate(namaCandidate) ){
            System.out.println("kandidat berhasil di tambahkan!!");
        } else {
            System.out.println("kandidat gagal di tambahkan!!");
        }

    }

    public static void insDataEvent() {
        // Header
        System.out.println("\n=== INPUT DATA EVENT ===");
        // Isi
        
        System.out.print("Nama Event : " );
        String namaEvent = input.next();
        System.out.print("Start Event [yyyy-mm-dd] : " );
        String startEvent = input.next();
        System.out.print("End Event [yyyy-mm-dd] : " );
        String endEvent = input.next();

        if (cConfig.insDataEvent(namaEvent, startEvent, endEvent) ){
            System.out.println("Event berhasil di tambahkan!!");
        } else {
            System.out.println("Event gagal di tambahkan!!");
        }
    }

    public static void insDataUser() {
        // Header
        System.out.println("\n=== BUAT AKUN ===");
        // Isi
        
        System.out.print("Username : " );
        String inUser = input.next();
        System.out.print("Password : " );
        String inPass = input.next();
        System.out.print("Role : " );
        String inRole = input.next();

        if (cConfig.insDataUser(inUser, inPass, inRole) ){
            System.out.println("user berhasil di tambahkan!!");
        } else {
            System.out.println("user gagal di tambahkan!!");
        }

    }

    public static void upDataUser() {
        // Header
        System.out.println("\n=== UBAH DATA USER ===");
        // Isi
        System.out.print("Input Nama User Baru : " );
        String namaBaru = input.next();

        if (cConfig.insDataCandidate(namaBaru) ){
            System.out.println("Nama User Berhasil di Update!!");
        } else {
            System.out.println("Nama User Gagal di Update!!");
        }
    }

}
