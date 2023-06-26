package com.view;

import com.config.cConfig;

import java.util.Scanner;

public class cView {

    private static Scanner input = new Scanner(System.in);

    public static void register() {
        // Header
        System.out.println("\n=== BUAT AKUN ===");
        // Isi

        System.out.print("username : ");
        String regUsername = input.next();
        System.out.print("password : ");
        String regPass = input.next();

        if (cConfig.register(regUsername, regPass)) {
            System.out.println("user berhasil di tambahkan!!");
        } else {
            System.out.println("user gagal di tambahkan!!");
        }

    }

    public static void getAllDataCandidate() {
        // Header
        System.out.println("\n=============================================\n" +
                "\n====            DATA CANDIDATE           ====\n" +
                "\n=============================================\n");
        // Isi

        System.out.println(cConfig.getAllDataCandidate());

    }

    public static void getAllDataEvent() {
        // Header
        System.out.println("\n=============================================\n" +
                "\n====              DATA EVENT             ====\n" +
                "\n=============================================\n");
        // Isi

        System.out.println(cConfig.getAllDataEvent());

    }

    public static void getAllDataEventCandidate() {
        // Header
        System.out.println("\n=============================================\n" +
                "\n====       DATA CANDIDATE PER EVENT      ====\n" +
                "\n=============================================\n");
        // Isi

        System.out.println(cConfig.getAllDataEventCandidate());

    }

    public static void getAllDataUser() {
        // Header
        System.out.println("\n=============================================\n" +
                "\n====               DATA USER             ====\n" +
                "\n=============================================\n");
        // Isi

        System.out.println(cConfig.getAllDataUser());

    }

    public static void getAllDataVote() {
        // Header
        System.out.println("\n=============================================\n" +
                "\n====            DATA HASIL VOTE          ====\n" +
                "\n=============================================\n");
        // Isi

        System.out.println(cConfig.getAllDataVote());

    }

    public static void getAllDataDetail() {
        System.out.print("Nama : ");
        String name = input.next();

        System.out.println("\nHasil Data");
        System.out.println(cConfig.getAllDataDetail(name));

    }

    public static void insDataCandidate() {
        // Header
        System.out.println("\n=============================================\n" +
                "\n====         INPUT DATA CANDIDATE        ====\n" +
                "\n=============================================\n");
        // Isi

        System.out.print("Nama Kandidat : ");
        String namaCandidate = input.next();

        if (cConfig.insDataCandidate(namaCandidate)) {
            System.out.println("kandidat berhasil di tambahkan!!");
        } else {
            System.out.println("kandidat gagal di tambahkan!!");
        }

    }

    public static void insDataEvent() {
        // Header
        System.out.println("\n=============================================\n" +
                "\n====          INPUT DATA EVENT           ====\n" +
                "\n=============================================\n");
        // Isi

        System.out.print("Nama Event : ");
        String namaEvent = input.next();
        System.out.print("Start Event [yyyy-mm-dd] : ");
        String startEvent = input.next();
        System.out.print("End Event [yyyy-mm-dd] : ");
        String endEvent = input.next();

        if (cConfig.insDataEvent(namaEvent, startEvent, endEvent)) {
            System.out.println("Event berhasil di tambahkan!!");
        } else {
            System.out.println("Event gagal di tambahkan!!");
        }
    }

    public static void insDataUser() {
        // Header
        System.out.println("\n=============================================\n" +
                "\n====              BUAT AKUN              ====\n" +
                "\n=============================================\n");
        // Isi

        System.out.print("Username : ");
        String inUser = input.next();
        System.out.print("Password : ");
        String inPass = input.next();
        System.out.print("Role : ");
        String inRole = input.next();

        if (cConfig.insDataUser(inUser, inPass, inRole)) {
            System.out.println("user berhasil di tambahkan!!");
        } else {
            System.out.println("user gagal di tambahkan!!");
        }

    }

    public static void upDataUser() {
        getAllDataUser();
        System.out.print("Input ID user yang di ingin ubah :");
        String codeUser = input.next();
        while (true) {
            System.out.print("\n=============================================\n" +
                    "\n====    PILIH DATA YANG INGIN DI UBAH    ====\n" +
                    "\n=============================================\n"
                    + "1. Nama User\n"
                    + "2. Password User\n"
                    + "3. Role User\n"
                    + "4. Status User\n"
                    + "0. Exit\n"
                    + "Pilih [1/2/3/4] :");
            Scanner input = new Scanner(System.in);
            String pilihan = input.next();
            if (pilihan.equalsIgnoreCase("0")) {
                break;
            }
            switch (pilihan) {
                case "1":
                    System.out.print("Input Nama User Baru : ");
                    String dataBaru = input.next();

                    if (cConfig.upNameDataUser(dataBaru, codeUser)) {
                        System.out.println("Nama User Berhasil di Update!!");
                    } else {
                        System.out.println("Nama User Gagal di Update!!");
                    }
                    break;
                case "2":
                    System.out.print("Input Password User Baru : ");
                    String passBaru = input.next();

                    if (cConfig.upPassDataUser(passBaru, codeUser)) {
                        System.out.println("Password User Berhasil di Update!!");
                    } else {
                        System.out.println("Password User Gagal di Update!!");
                    }
                    break;
                case "3":
                    System.out.print("Input Role User Baru : ");
                    String roleBaru = input.next();

                    if (cConfig.upRoleDataUser(roleBaru, codeUser)) {
                        System.out.println("Role User Berhasil di Update!!");
                    } else {
                        System.out.println("Role User Gagal di Update!!");
                    }
                    break;
                case "4":
                    System.out.print("Input Status User Baru : ");
                    String statusBaru = input.next();

                    if (cConfig.upStatusDataUser(statusBaru, codeUser)) {
                        System.out.println("Status User Berhasil di Update!!");
                    } else {
                        System.out.println("Status User Gagal di Update!!");
                    }
                    break;

            }
        }

    }

    public static void upDataEvent() {
        getAllDataEvent();
        System.out.print("Input ID Event yang di ingin ubah :");
        String codeUser = input.next();
        while (true) {
            System.out.print("\n=============================================\n" +
                    "\n====    PILIH DATA YANG INGIN DI UBAH    ====\n" +
                    "\n=============================================\n"
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
            switch (pilihan) {
                case "1":
                    System.out.print("Input Nama Event Baru : ");
                    String nameEventNew = input.next();

                    if (cConfig.upNamaEvent(nameEventNew, codeUser)) {
                        System.out.println("Nama Event Berhasil di Update!!");
                    } else {
                        System.out.println("Nama Event Gagal di Update!!");
                    }
                    break;
                case "2":
                    System.out.print("Input Start Event Baru : ");
                    String startEventNew = input.next();

                    if (cConfig.upStartEvent(startEventNew, codeUser)) {
                        System.out.println("Start Event Berhasil di Update!!");
                    } else {
                        System.out.println("Start Event Gagal di Update!!");
                    }
                    break;
                case "3":
                    System.out.print("Input End Event Baru : ");
                    String endEventNew = input.next();

                    if (cConfig.upEndEvent(endEventNew, codeUser)) {
                        System.out.println("End Event Berhasil di Update!!");
                    } else {
                        System.out.println("End Event Gagal di Update!!");
                    }
                    break;
                case "4":
                    System.out.print("Input Status Event Baru : ");
                    String StatusEventNew = input.next();

                    if (cConfig.upStatusEvent(StatusEventNew, codeUser)) {
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
        String codeUser = input.next();
        while (true) {
            System.out.print("\n=============================================\n" +
                    "\n====    PILIH DATA YANG INGIN DI UBAH    ====\n" +
                    "\n=============================================\n"
                    + "1. Nama Candidate\n"
                    + "2. Status Candidate\n"
                    + "0. Exit\n"
                    + "Pilih [1/2] :");
            Scanner input = new Scanner(System.in);
            String pilihan = input.next();
            if (pilihan.equalsIgnoreCase("0")) {
                break;
            }
            switch (pilihan) {
                case "1":
                    System.out.print("Input Nama Candidate Baru : ");
                    String nameCandidateNew = input.next();

                    if (cConfig.upNameCandidate(nameCandidateNew, codeUser)) {
                        System.out.println("Nama Candidate Berhasil di Update!!");
                    } else {
                        System.out.println("Nama Candidate Gagal di Update!!");
                    }
                    break;
                case "2":
                    System.out.print("Input Password User Baru : ");
                    String statusCandidateNew = input.next();

                    if (cConfig.upStatusCandidate(statusCandidateNew, codeUser)) {
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
        System.out.print("Input ID Candidate yang di ingin ubah :");
        String codeUser = input.next();
        if ( codeUser.equalsIgnoreCase("0")) {
            System.out.println("Pilihan Salah !!");
        }else if (cConfig.delDataUser(codeUser)) {
            System.out.println("User Berhasil di Delete!!");
        } else if (codeUser.equalsIgnoreCase("0")) {
            System.out.println("Pilihan Salah!!");
        } else {
            System.out.println("User Gagal di Delete!!");
        }
    }

    public static void delDataCandidate() {
        getAllDataCandidate();
        System.out.print("Input ID Candidate yang di ingin ubah :");
        String codeUser = input.next();
        if ( codeUser.equalsIgnoreCase("0")) {
            System.out.println("Pilihan Salah !!");
        }else if (cConfig.delDataCandidate(codeUser)) {
            System.out.println("User Berhasil di Delete!!");
        } else if (codeUser.equalsIgnoreCase("0")) {
            System.out.println("Pilihan Salah!!");
        } else {
            System.out.println("User Gagal di Delete!!");
        }
    }

    public static void delDataEvent() {
        getAllDataEvent();
        System.out.print("Input ID Event yang di ingin ubah :");
        String codeUser = input.next();
        if ( codeUser.equalsIgnoreCase("0")) {
            System.out.println("Pilihan Salah !!");
        }else if (cConfig.delDataEvent(codeUser)) {
            System.out.println("User Berhasil di Delete!!");
        } else if (codeUser.equalsIgnoreCase("0")) {
            System.out.println("Pilihan Salah!!");
        } else {
            System.out.println("User Gagal di Delete!!");
        }
    }

    public static void getAllResultVote() {
        // Header
        System.out.println("\n=============================================\n" +
                "\n====            DATA HASIL VOTE          ====\n" +
                "\n=============================================\n");
        // Isi

        System.out.println(cConfig.getAllResultVote());

    }

    public static void getAllResultPerEvent() {
        // Header
        System.out.println("\n=============================================\n" +
                "\n====       DATA HASIL VOTE PER EVENT      ====\n" +
                "\n=============================================\n");
        // Isi

        System.out.println(cConfig.getAllResultPerEvent());

    }

    public static void pemenangPilkatsuk() {
        // Header
        System.out.println(
                "\nDengan Pemilihan Voting yang sudah berjalan maka hasil dari Pilkatsuk adalah sebagai berikut :");
        // Isi

        System.out.println(cConfig.pemenangPilkatsukKetua());
        System.out.println(cConfig.pemenangPilkatsukWakil());

    }

    public static void pemenangPilkatsukPerDesa() {
        // Header
        System.out.println(
                "\nHasil Pilkatsuk Perdesa adalah sebagai berikut : \n");
        // Isi
        System.out.println("Hasil Ketua :");
        System.out.println(cConfig.hasilPilkatsukPerEventKetua());
        System.out.println("Hasil Wakil :");
        System.out.println(cConfig.hasilPilkatsukPerEventWakil());

    }

    public static void lihatKandidat() {
        // Header
        System.out.println("\n=============================================\n" +
                "\n====               KANDIDAT               ====\n" +
                "\n=============================================\n");
        // Isi
        System.out.println("List Kandidat :");
        System.out.println(cConfig.lihatKandidat());

    }

    public static void lihatDesa() {
        // Header
        System.out.println("\n=============================================\n" +
                "\n====                DESA                  ====\n" +
                "\n=============================================\n");
        // Isi
        System.out.println("List Desa :");
        System.out.println(cConfig.lihatDesa());

    }

    public static void lihatDesaVoter() {

        

        // Header
        System.out.println("\n=============================================\n" +
                "\n====                DESA                  ====\n" +
                "\n=============================================\n");
        // Isi

        System.out.println(cConfig.lihatDesa());
        System.out.println();
        System.out.print("Pilih Acara : ");
        String lihatDesaVoter = input.next();
        if ( lihatDesaVoter.equalsIgnoreCase("0")) {
            System.out.println("Pilihan Salah !! Vote kamu tidak akan tersimpan !!");
        }
        System.out.println("\n=============================================\n" +
                "\n====               VOTING                 ====\n" +
                "\n=============================================\n");

        System.out.println("List Kandidat :");
        System.out.println(cConfig.lihatKandidat());
        System.out.print("Pilih Calon Kandidat sebagai Ketua Akatsuki : ");
        String ketua = input.next();
        if ( ketua.equalsIgnoreCase("0")) {
            System.out.println("Pilihan Salah !! Vote kamu tidak akan tersimpan !!");
        } else if (cConfig.ngeVoteKetua(ketua, lihatDesaVoter)) {}
        
        System.out.print("Pilih Calon Kandidat sebagai Wakil Ketua Akatsuki : ");
        String wakil = input.next();
        if ( wakil.equalsIgnoreCase("0")) {
            System.out.println("Pilihan Salah !! Vote kamu tidak akan tersimpan !!");
        } else if (cConfig.ngeVoteWakil(wakil, lihatDesaVoter)) {}

        System.out.print("Apakah data yang di Voting sudah benar? [Y/N] : ");
        String jwb = input.next();

        switch (jwb) {
            case "Y":
                System.out.print("Input id tiket vote anda untuk menkonfirmasi hasil voting : ");
                String tiketId = input.next();
                cConfig.voteKetua(tiketId);
                cConfig.voteWakil(tiketId);
                System.out.println("!! Vote Sudah Tersimpan !!");
                break;
            case "N":
                System.out.println("!! Vote Tidak Tersimpan !!");

                break;

        }

    }

}
