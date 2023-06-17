package com.config;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

import com.page.menu;

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
    private static ResultSet resultDataCek ;

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

    public static String user( String logUsername, String logPass) {
        cConfig.connection();

        // nilai default var data
        String data = "WRONG USERNAME & PASSWORD";

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // Querry MYSQL
            String query = "Select * from user where userId='"+logUsername+"' and pass="+logPass;
            String queryCek = "SELECT * FROM user";

            // eksekusi querry
            resultData = statement.executeQuery(query);
            resultDataCek = statement.executeQuery(queryCek);

            // set var data jadi null
            data = "";
            
            // looping pengisian variabel data
            // while(resultData.next()){
            //     data = "Welcome " + resultData.getString("userId") + " " + resultData.getString("role");
            // }         

            // if(resultData.next()) {
            //     data = "Welcome " + resultData.getString("userId") + " " + resultData.getString("role");
            //     menu.read();
            // } else{
            //     System.out.println("Wrong Username & Password");
            // }

            while(resultDataCek.next()) {
                String cekUser = resultDataCek.getString("userId");
                String cekPass = resultDataCek.getString("pass");

                if((logUsername.equals(cekUser))&&(logPass.equals(cekPass)))
                // if((logUsername.equals("rafly"))&&(logPass.equals("123")))
                {
                    System.out.println("WELCOME BRADER IT WORKS");
                } else {
                    System.out.println("wrong blokk");
                    break;
                }
                break;
            }

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
            String query = "SELECT * FROM candidate";

            // eksekusi querry
            resultData = statement.executeQuery(query);

            // set var data jadi null
            data = "";
            
            // looping pengisian variabel data
            while(resultData.next()){
                data += "id :" + resultData.getString("codeCandidate") +" Nama Kandidat :" + resultData.getString("candidateID") + ", Tgl buat : " + resultData.getString("createdAt") +" Status :" + resultData.getString("status") +"\n"; 
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

    public static boolean upNameDataUser(String namaBaru, String codeUser ) {
        cConfig.connection();
        
        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "UPDATE `user` SET userId ='"+namaBaru+"' WHERE codeUser ="+codeUser+";"  ;

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

    public static boolean upPassDataUser(String passBaru, String codeUser ) {
        cConfig.connection();
        
        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "UPDATE `user` SET pass ='"+passBaru+"' WHERE codeUser ="+codeUser+";"  ;

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

    public static boolean upRoleDataUser(String roleBaru, String codeUser ) {
        cConfig.connection();
        
        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "UPDATE `user` SET role ='"+roleBaru+"' WHERE codeUser ="+codeUser+";"  ;

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

    public static boolean upStatusDataUser(String statusBaru, String codeUser ) {
        cConfig.connection();
        
        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "UPDATE `user` SET status ='"+statusBaru+"' WHERE codeUser ="+codeUser+";"  ;

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

    public static boolean upNamaEvent(String nameEventNew, String codeEvent ) {
        cConfig.connection();
        
        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "UPDATE event SET eventId ='"+nameEventNew+"' WHERE codeEvent  ="+codeEvent+";"  ;

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

    public static boolean upStartEvent(String startEventNew, String codeEvent ) {
        cConfig.connection();
        
        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "UPDATE event SET eventDateStart ='"+startEventNew+"' WHERE codeEvent  ="+codeEvent;

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

    public static boolean upEndEvent(String endEventNew, String codeEvent ) {
        cConfig.connection();
        
        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "UPDATE event SET eventDateEnd ='"+endEventNew+"' WHERE codeEvent  ="+codeEvent;

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

    public static boolean upStatusEvent(String StatusEventNew, String codeEvent ) {
        cConfig.connection();
        
        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "UPDATE event SET status ='"+StatusEventNew+"' WHERE codeEvent  ="+codeEvent+";"  ;

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

    public static boolean upNameCandidate(String nameCandidateNew, String codeUser ) {
        cConfig.connection();
        
        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "UPDATE `candidate` SET candidateId ='"+nameCandidateNew+"' WHERE codeCandidate ="+codeUser+";"  ;

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
    
    public static boolean upStatusCandidate(String statusCandidateNew, String codeUser ) {
        cConfig.connection();
        
        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "UPDATE `candidate` SET status ='"+statusCandidateNew+"' WHERE codeCandidate ="+codeUser+";"  ;

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

    public static boolean delDataUser(String codeUser ) {
        cConfig.connection();
        
        boolean data = false ;

        try {
            statement = connect.createStatement();

            String query = "DELETE FROM user WHERE codeUser="+codeUser  ;

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
    
    public static boolean delDataCandidate(String codeUser ) {
        cConfig.connection();
        
        boolean data = false ;

        try {
            statement = connect.createStatement();

            String query = "DELETE FROM candidate WHERE codeCandidate="+codeUser  ;

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
    
    public static boolean delDataEvent(String codeUser ) {
        cConfig.connection();
        
        boolean data = false ;

        try {
            statement = connect.createStatement();

            String query = "DELETE FROM event WHERE codeEvent="+codeUser  ;

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
