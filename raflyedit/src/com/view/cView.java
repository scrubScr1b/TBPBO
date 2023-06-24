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
        getAllDataUser();
        System.out.println("Input ID user yang di ingin ubah :");
        String codeUser  = input.next();
        while(true) {
            System.out.print("\n===== PILIH YANG INGIN DI UBAH =====\n"
            + "1. Nama User\n"
            + "2. Password User\n"
            + "3. Role User\n"
            + "0. Exit\n"
            + "Pilih [1/2/3] :");
            Scanner input = new Scanner(System.in);
            String pilihan = input.next();
            if (pilihan.equalsIgnoreCase("0")) {
            break;
            }
                switch(pilihan) {
                    case "1":
                        System.out.print("Input Nama User Baru : " );
                        String dataBaru = input.next();
            
                        if (cConfig.upNameDataUser(dataBaru, codeUser) ){
                            System.out.println("Nama User Berhasil di Update!!");
                        } else {
                            System.out.println("Nama User Gagal di Update!!");
                        }
                     break;
                    case "2":
                        System.out.print("Input Password User Baru : " );
                        String passBaru = input.next();
            
                        if (cConfig.upPassDataUser(passBaru, codeUser) ){
                            System.out.println("Password User Berhasil di Update!!");
                        } else {
                            System.out.println("Password User Gagal di Update!!");
                        }
                    break;
                    case "3":
                        System.out.print("Input Role User Baru : " );
                        String roleBaru = input.next();
            
                        if (cConfig.upRoleDataUser(roleBaru, codeUser) ){
                            System.out.println("Password User Berhasil di Update!!");
                        } else {
                            System.out.println("Password User Gagal di Update!!");
                        }
                    break;
                    
                }
            }
        
        }

    public static void upDataEvent() {
            getAllDataEvent();
            System.out.println("Input ID Event yang di ingin ubah :");
            String codeUser  = input.next();
            while(true) {
                System.out.print("\n===== PILIH YANG INGIN DI UBAH =====\n"
                + "1. Nama Event\n"
                + "2. Start Event\n"
                + "3. End Event\n"
                + "4. Status Event\n"
                + "0. Exit\n"
                + "Pilih [1/2/3/4] :");
                Scanner input = new Scanner(System.in);
                String pilihan = input.next();
                if (pilihan.equalsIgnoreCase("0")) {
                break;
                }
                    switch(pilihan) {
                        case "1":
                            System.out.print("Input Nama Event Baru : " );
                            String nameEventNew = input.next();
                
                            if (cConfig.upNamaEvent(nameEventNew, codeUser) ){
                                System.out.println("Nama Event Berhasil di Update!!");
                            } else {
                                System.out.println("Nama Event Gagal di Update!!");
                            }
                         break;
                        case "2":
                            System.out.print("Input Start Event Baru : " );
                            String startEventNew = input.next();
                
                            if (cConfig.upStartEvent(startEventNew, codeUser) ){
                                System.out.println("Start Event Berhasil di Update!!");
                            } else {
                                System.out.println("Start Event Gagal di Update!!");
                            }
                        break;
                        case "3":
                            System.out.print("Input End Event Baru : " );
                            String endEventNew = input.next();
                
                            if (cConfig.upEndEvent(endEventNew, codeUser) ){
                                System.out.println("End Event Berhasil di Update!!");
                            } else {
                                System.out.println("End Event Gagal di Update!!");
                            }
                        break;
                        case "4":
                            System.out.print("Input Status Event Baru : " );
                            String StatusEventNew = input.next();
                
                            if (cConfig.upStatusEvent(StatusEventNew, codeUser) ){
                                System.out.println("Status Event Berhasil di Update!!");
                            } else {
                                System.out.println("Status Event Gagal di Update!!");
                            }
                        
                    }
                }
            
            }    

    public static void upDataCandidate() {
                getAllDataCandidate();
                System.out.println("Input ID Candidate yang di ingin ubah :");
                String codeUser  = input.next();
                while(true) {
                    System.out.print("\n===== PILIH YANG INGIN DI UBAH =====\n"
                    + "1. Nama Candidate\n"
                    + "2. Status Candidate\n"
                    + "0. Exit\n"
                    + "Pilih [1/2] :");
                    Scanner input = new Scanner(System.in);
                    String pilihan = input.next();
                    if (pilihan.equalsIgnoreCase("0")) {
                    break;
                    }
                        switch(pilihan) {
                            case "1":
                                System.out.print("Input Nama Candidate Baru : " );
                                String nameCandidateNew = input.next();
                    
                                if (cConfig.upNameCandidate(nameCandidateNew, codeUser) ){
                                    System.out.println("Nama Candidate Berhasil di Update!!");
                                } else {
                                    System.out.println("Nama Candidate Gagal di Update!!");
                                }
                             break;
                            case "2":
                                System.out.print("Input Password User Baru : " );
                                String statusCandidateNew = input.next();
                    
                                if (cConfig.upStatusCandidate(statusCandidateNew, codeUser) ){
                                    System.out.println("Password User Berhasil di Update!!");
                                } else {
                                    System.out.println("Password User Gagal di Update!!");
                                }
                            break;                            
                            }
        }
                
    }

    public static void delDataUser() {
        getAllDataUser();
        System.out.println("Input ID Candidate yang di ingin ubah :");
        String codeUser  = input.next();
        if (cConfig.delDataUser(codeUser) ){
            System.out.println("User Berhasil di Delete!!");
        } else if (codeUser.equalsIgnoreCase("0")) {
            System.out.println("Pilihan Salah!!");
        }else {
            System.out.println("User Gagal di Delete!!");
        }
    }

    public static void delDataCandidate() {
        getAllDataCandidate();
        System.out.println("Input ID Candidate yang di ingin ubah :");
        String codeUser  = input.next();
        if (cConfig.delDataCandidate(codeUser) ){
            System.out.println("User Berhasil di Delete!!");
        } else if (codeUser.equalsIgnoreCase("0")) {
            System.out.println("Pilihan Salah!!");
        } else {
            System.out.println("User Gagal di Delete!!");
        }
    }

    public static void delDataEvent() {
        getAllDataEvent();
        System.out.println("Input ID Event yang di ingin ubah :");
        String codeUser  = input.next();
        
        if (cConfig.delDataEvent(codeUser) ){
            System.out.println("User Berhasil di Delete!!");
        } else if (codeUser.equalsIgnoreCase("0")) {
            System.out.println("Pilihan Salah!!");
        }else {
            System.out.println("User Gagal di Delete!!");
        }
    }
    
}
