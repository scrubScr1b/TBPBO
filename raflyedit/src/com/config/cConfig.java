package com.config;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class cConfig {
    // ini untuk mendefinisikan koneksi ke database akatsuki
    // private static final String koneksi = "com.mysql.jdbc.Driver"; 
    private static final String url = "jdbc:mysql://localhost:3306/dbvote";
    private static final String user = "root";
    private static final String pass = "";

    // ini untuk instansisasi object dari class yg sudah di import
    private static Connection connect ;
    private static Statement statement ;
    private static ResultSet resultData ;

    // Method static connection
    private static void connection(){ 
        try {
            // Regist Driver
            // Class.forName(koneksi);

            // buat koneksi db
            connect = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String user( String logUsername) {
        cConfig.connection();

        // nilai default var data
        String data = "Data Masih Kosong";

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // Querry MYSQL
            String query = "SELECT * FROM user where userId = " + "'" + logUsername+"'";

            // eksekusi querry
            resultData = statement.executeQuery(query);

            // set var data jadi null
            data = "";
            
            // looping pengisian variabel data
            while(resultData.next()){
                data = "Welcome " + resultData.getString("userId") + " " + resultData.getString("role");
            }

            // if (logUsername.equals(resultData.getString(2))){
            //     System.out.println("Sukses Login");
            // } else {
            //     System.out.println("Login Gagal");
            // }

                        
            // close statement and connection
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static boolean register( String regUsername, String regPass ) {
        cConfig.connection();
        
        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "INSERT INTO user VALUES (" + null + ", '" + regUsername + "', '" + regPass + "', '" + "user" + "', '" + "active" + "', " + "current_timestamp())" ;

            if(!statement.execute(query)){
                data = true;
            }
            


            // close statement dan koneksi
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public static String getAllDataCandidate() {
        cConfig.connection();

        // nilai default var data
        String data = "Data Masih Kosong";

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // Querry MYSQL
            String query = "SELECT codeCandidate, candidateId, createdAt FROM candidate";

            // eksekusi querry
            resultData = statement.executeQuery(query);

            // set var data jadi null
            data = "";
            
            // looping pengisian variabel data
            while(resultData.next()){
                data += "id :" + resultData.getString("codeCandidate") +" Nama Kandidat :" + resultData.getString("candidateID") + ", Tgl buat : " + resultData.getString("createdAt") + "\n"; 
            }

            // close statement and connection
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String getAllDataEvent() {
        cConfig.connection();

        // nilai default var data
        String data = "Data Masih Kosong";

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // Querry MYSQL
            String query = "SELECT codeEvent, eventId, eventDateStart, eventDateEnd, status, createdAt FROM event";

            // eksekusi querry
            resultData = statement.executeQuery(query);

            // set var data jadi null
            data = "";
            
            // looping pengisian variabel data
            while(resultData.next()){
                data += " id : " + resultData.getString("codeEvent") +" Nama Event : " + resultData.getString("eventId") + " Start " + resultData.getString("eventDateStart") + " sd " + resultData.getString("eventDateEnd") +" Status = " +resultData.getString("status") +" Created At "+resultData.getString("createdAt") + "\n" ; 
            }

            // close statement and connection
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String getAllDataEventCandidate() {
        cConfig.connection();

        // nilai default var data
        String data = "Data Masih Kosong";

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // Querry MYSQL
            String query = "SELECT eventcandidate.codeEventCandidate, eventcandidate.eventCandidateId, candidate.candidateId, event.eventId, eventcandidate.status FROM eventcandidate JOIN event ON eventcandidate.codeEvent = event.codeEvent JOIN candidate ON eventcandidate.codeCandidate = candidate.codeCandidate;";

            // eksekusi querry
            resultData = statement.executeQuery(query);

            // set var data jadi null
            data = "";
            
            // looping pengisian variabel data
            while(resultData.next()){
                data += "id : " + resultData.getString("codeEventCandidate") +" Pemilihan : " + resultData.getString("eventCandidateId") + " Nama Kandidat : " + resultData.getString("candidateId") + " Tempat Acara  : " + resultData.getString("eventId") +" Status : " +resultData.getString("status") +"\n" ; 
            }

            // close statement and connection
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String getAllDataUser() {
        cConfig.connection();

        // nilai default var data
        String data = "Data Masih Kosong";

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // Querry MYSQL
            String query = "SELECT codeUser, userId, pass, role, status, createdAt FROM user";

            // eksekusi querry
            resultData = statement.executeQuery(query);

            // set var data jadi null
            data = "";
            
            // looping pengisian variabel data
            while(resultData.next()){
                data += "id : " + resultData.getString("codeUser") +" Nama User : " + resultData.getString("userId") + " Pass User : " + resultData.getString("pass") + " Role : " + resultData.getString("role") +" Status : " +resultData.getString("status") +" Tgl buat "+resultData.getString("createdAt") + "\n" ; 
            }

            // close statement and connection
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String getAllDataVote() {
        cConfig.connection();

        // nilai default var data
        String data = "Data Masih Kosong";

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // Querry MYSQL
            String query = "SELECT vote.codeVote, candidate.candidateId, eventcandidate.eventCandidateId, user.userId, event.eventId, vote.dateVote FROM user JOIN vote ON user.codeUser = vote.codeUser JOIN eventcandidate ON vote.codeEventCandidate = eventcandidate.codeEventCandidate JOIN event ON eventCandidate.codeEvent = event.codeEvent JOIN candidate ON eventcandidate.codeCandidate = candidate.codeCandidate;";

            // eksekusi querry
            resultData = statement.executeQuery(query);

            // set var data jadi null
            data = "";

            // looping pengisian variabel data
            while(resultData.next()){
                // data +=  "Nama Kandidat : " + resultData.getString("candidateId") + "\nDipilih Sebagai : " + resultData.getString("eventCandidateId") + "\nOleh : " + resultData.getString("userId") +"\nDi Acara : " +resultData.getString("eventId") +"\nPada Tanggal "+resultData.getString("dateVote") +"\n===========================\n" ; 

                data +=  "id : " + resultData.getString("codeVote") +" Nama Kandidat : " + resultData.getString("candidateId") + ", Dipilih Sebagai : " + resultData.getString("eventCandidateId") + ", Oleh : " + resultData.getString("userId") +", Di Acara : " +resultData.getString("eventId") +", Pada Tanggal "+resultData.getString("dateVote") +"\n" ; 

            }

            // close statement and connection
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    
    public static String getAllDataDetail(String name) {
        cConfig.connection();

        String data = "Data tidak di temukan";

        try {

            statement = connect.createStatement();
            
            String query = "SELECT candidate.candidateId, eventcandidate.eventCandidateId, user.userId, event.eventId, vote.dateVote FROM user JOIN vote ON user.codeUser = vote.codeUser JOIN eventcandidate ON vote.codeEventCandidate = eventcandidate.codeEventCandidate JOIN event ON eventCandidate.codeEvent = event.codeEvent JOIN candidate ON eventcandidate.codeCandidate = candidate.codeCandidate WHERE eventId = '"+name+"' OR userId ='"+name+"' OR candidateId = '"+name+"' OR eventcandidateId ='"+name+"';";

            resultData = statement.executeQuery(query);

            data = "";

            int count = 0;
            while(resultData.next()) {
                data +=  "Nama Kandidat : " + resultData.getString("candidateId") + ", Dipilih Sebagai : " + resultData.getString("eventCandidateId") + ", Oleh : " + resultData.getString("userId") +", Di Acara : " +resultData.getString("eventId") +", Pada Tanggal "+resultData.getString("dateVote") +"\n" ; 
                count++;
            }

            if(count == 0) {
                data = "Data tidak ditemukan";
            }

            // close statement
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
        
    }

    public static boolean insDataCandidate( String namaCandidate ) {
        cConfig.connection();
        
        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "INSERT INTO candidate VALUES (" + null + ", '" + namaCandidate + "', '" + "active" + "', " + "current_timestamp())" ;

            if(!statement.execute(query)){
                data = true;
            }
            


            // close statement dan koneksi
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public static boolean insDataEvent( String namaEvent, String startEvent,String endEvent ) {
        cConfig.connection();
        
        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "INSERT INTO event VALUES (" + null + ", '" + namaEvent + "', '"+ startEvent + "', '" + endEvent + "', '"+ "active" + "', " + "current_timestamp())" ;

            if(!statement.execute(query)){
                data = true;
            }
            


            // close statement dan koneksi
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public static boolean insDataUser( String inUser, String inPass, String inRole ) {
        cConfig.connection();
        
        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "INSERT INTO user VALUES (" + null + ", '" + inUser + "', '" + inPass + "', '" + inRole + "', '" + "active" + "', " + "current_timestamp())" ;

            if(!statement.execute(query)){
                data = true;
            }
            


            // close statement dan koneksi
            statement.close();
            connect.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

}
