package com.config;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import com.entity.userEntity;


import java.sql.ResultSet;
import java.sql.SQLException;

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
    private DataSource dataSource;

    // Method static connection
    public static void connection(){ 
        try {
            // Regist Driver
            // Class.forName(koneksi);

            // buat koneksi db
            connect = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public cConfig(){ 
        try {
            // Regist Driver
            // Class.forName(koneksi);

            // buat koneksi db
            connect = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String LoginValidate(String userid, String password, String role) {
        cConfig.connection();
        
       
        // Validasi input tidak boleh kosong
        if (userid.equals("")|| password.equals("")) {
            return "userid and password cannot be empty!";
        }

        userEntity user = new userEntity();
        user.setUserId(userid);
        user.setPassword(password);
        user.setRole(role);

        // Validasi user exists pada DB
        if (!CheckUserExists(user.getUserid())) {
            return "userid is not exists, please try again.";
        }
    
        // Validasi userid & password valid
        if (!UserPasswordValid(user)) {
            return "userid and password is not valid, please try again";
        }

        // Validasi role
        if (!roleValidation(user)) {
            return "role is not valid, please try again";
        }
        return "";
    }

    public cConfig (DataSource dataSource) {
    this.dataSource = dataSource;
    }

    public static boolean CheckUserExists(String userid) {
    String sql = "SELECT * FROM user WHERE userId = ? ";
    cConfig.connection();

    try (
        PreparedStatement stmt = connect.prepareStatement(sql);
    ) {
        stmt.setString(1,userid);
        ResultSet resultSet = stmt.executeQuery();

        if (resultSet.next()) {
            // User Valid
            resultSet.close();
            return true;
        } else {
            resultSet.close();
            return false;
        }
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }
}

    public static boolean UserPasswordValid(userEntity user) {
    String sql = "SELECT * FROM user WHERE userId = ? and pass = ?";
    cConfig.connection();
    try (
        PreparedStatement stmt = connect.prepareStatement(sql);
    ) {
        stmt.setString(1,user.getUserid());
        stmt.setString(2,user.getPassword());
        ResultSet resultSet = stmt.executeQuery();

        if (resultSet.next()) {
            // User Valid
            resultSet.close();
            return true;
        } else {
            resultSet.close();
            return false;
        }
        } catch (SQLException ex) {
        throw new RuntimeException(ex);
        }
    }

    public static boolean roleValidation(userEntity user) {
    String sql = "SELECT * FROM user WHERE userId = ? and pass = ? and role = ?";
    cConfig.connection();
    try (
        PreparedStatement stmt = connect.prepareStatement(sql);
    ) {
        stmt.setString(1,user.getUserid());
        stmt.setString(2,user.getPassword());
        stmt.setString(3,user.getRole());
        ResultSet resultSet = stmt.executeQuery();

        if (resultSet.next()) {
            // User Valid
            resultSet.close();
            return true;
        } else {
            resultSet.close();
            return false;
        }
        } catch (SQLException ex) {
        throw new RuntimeException(ex);
        }
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
                data += "ID :" + resultData.getString("codeCandidate") +" Nama Kandidat :" + resultData.getString("candidateID") + ", Tgl buat : " + resultData.getString("createdAt") +" Status :" + resultData.getString("status") +"\n"; 
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
                data += " ID : " + resultData.getString("codeEvent") +" Nama Event : " + resultData.getString("eventId") + " Start " + resultData.getString("eventDateStart") + " sd " + resultData.getString("eventDateEnd") +" Status = " +resultData.getString("status") +" Created At "+resultData.getString("createdAt") + "\n" ; 
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
                data += "ID : " + resultData.getString("codeEventCandidate") +" Pemilihan : " + resultData.getString("eventCandidateId") + " Nama Kandidat : " + resultData.getString("candidateId") + " Tempat Acara  : " + resultData.getString("eventId") +" Status : " +resultData.getString("status") +"\n" ; 
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
                data += "ID : " + resultData.getString("codeUser") +" Nama User : " + resultData.getString("userId") + " Pass User : " + resultData.getString("pass") + " Role : " + resultData.getString("role") +" Status : " +resultData.getString("status") +" Tgl buat "+resultData.getString("createdAt") + "\n" ; 
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

                data +=  "ID : " + resultData.getString("codeVote") +" Nama Kandidat : " + resultData.getString("candidateId") + ", Dipilih Sebagai : " + resultData.getString("eventCandidateId") + ", Oleh : " + resultData.getString("userId") +", Di Acara : " +resultData.getString("eventId") +", Pada Tanggal "+resultData.getString("dateVote") +"\n" ; 

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

    public static String getAllResultVote() {
        cConfig.connection();

        // nilai default var data
        String data = "Data Masih Kosong";

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // Querry MYSQL
            String query = "SELECT candidate.candidateId, eventcandidate.eventCandidateId, COUNT(*) cnt FROM user JOIN vote ON user.codeUser = vote.codeUser JOIN eventcandidate ON vote.codeEventCandidate = eventcandidate.codeEventCandidate JOIN event ON eventCandidate.codeEvent = event.codeEvent JOIN candidate ON eventcandidate.codeCandidate = candidate.codeCandidate GROUP BY 1,2 ORDER BY cnt DESC";

            // eksekusi querry
            resultData = statement.executeQuery(query);

            // set var data jadi null
            data = "";

            // looping pengisian variabel data
            while(resultData.next()){

                data +=  " Nama Kandidat : " + resultData.getString("candidateId") + ", Dipilih Sebanyak : " + resultData.getString("cnt") +", Sebagai : " + resultData.getString("eventCandidateId") +"\n"; 

            }

            // close statement and connection
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String getAllResultPerEvent() {
        cConfig.connection();

        // nilai default var data
        String data = "Data Masih Kosong";

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // Querry MYSQL
            String query = "SELECT candidate.candidateId, eventcandidate.eventCandidateId,event.eventId, COUNT(*) cnt FROM user JOIN vote ON user.codeUser = vote.codeUser JOIN eventcandidate ON vote.codeEventCandidate = eventcandidate.codeEventCandidate JOIN event ON eventCandidate.codeEvent = event.codeEvent JOIN candidate ON eventcandidate.codeCandidate = candidate.codeCandidate GROUP BY 1,2,3 ORDER BY cnt DESC";

            // eksekusi querry
            resultData = statement.executeQuery(query);

            // set var data jadi null
            data = "";

            // looping pengisian variabel data
            while(resultData.next()){

                data +=  " Nama Kandidat : " + resultData.getString("candidateId") + ", Dipilih Sebanyak : " + resultData.getString("cnt") +", Sebagai : " + resultData.getString("eventCandidateId") +", Di Event : " + resultData.getString("eventId") + "\n"; 

            }

            // close statement and connection
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
    
    public static String pemenangPilkatsukKetua() {
        cConfig.connection();

        // nilai default var data
        String data = "Data Masih Kosong";

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // Querry MYSQL
            String query1 = "SELECT candidate.candidateId, eventcandidate.eventCandidateId, COUNT(*) cnt FROM user JOIN vote ON user.codeUser = vote.codeUser JOIN eventcandidate ON vote.codeEventCandidate = eventcandidate.codeEventCandidate JOIN event ON eventCandidate.codeEvent = event.codeEvent JOIN candidate ON eventcandidate.codeCandidate = candidate.codeCandidate WHERE eventcandidate.eventCandidateId = 'Ketua' GROUP BY 1,2 ORDER BY cnt DESC limit 1";

            // eksekusi querry
            resultData = statement.executeQuery(query1);

            // set var data jadi null
            data = "";
            
            resultData.next() ;
            data +=  "Ketua : " + resultData.getString("candidateId");


            // close statement and connection
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String pemenangPilkatsukWakil() {
        cConfig.connection();

        // nilai default var data
        String data = "Data Masih Kosong";

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // Querry MYSQL
            String query1 = "SELECT candidate.candidateId, eventcandidate.eventCandidateId, COUNT(*) cnt FROM user JOIN vote ON user.codeUser = vote.codeUser JOIN eventcandidate ON vote.codeEventCandidate = eventcandidate.codeEventCandidate JOIN event ON eventCandidate.codeEvent = event.codeEvent JOIN candidate ON eventcandidate.codeCandidate = candidate.codeCandidate WHERE eventcandidate.eventCandidateId = 'Wakil' GROUP BY 1,2 ORDER BY cnt DESC limit 1";

            // eksekusi querry
            resultData = statement.executeQuery(query1);

            // set var data jadi null
            data = "";
            
            resultData.next() ;
            data +=  "Wakil : " + resultData.getString("candidateId");


            // close statement and connection
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String hasilPilkatsukPerEventKetua() {
        cConfig.connection();

        // nilai default var data
        String data = "Data Masih Kosong";

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // Querry MYSQL
            String query = "SELECT event.eventId, candidate.candidateId, eventcandidate.eventCandidateId, COUNT(*) cnt FROM user JOIN vote ON user.codeUser = vote.codeUser JOIN eventcandidate ON vote.codeEventCandidate = eventcandidate.codeEventCandidate JOIN event ON eventCandidate.codeEvent = event.codeEvent JOIN candidate ON eventcandidate.codeCandidate = candidate.codeCandidate WHERE eventcandidate.eventCandidateId = 'KETUA' GROUP BY 1,2,3 ORDER BY cnt DESC";

            // eksekusi querry
            resultData = statement.executeQuery(query);

            // set var data jadi null
            data = "";

            // looping pengisian variabel data
            while(resultData.next()){

                data +=  "Desa : " + resultData.getString("eventId") + ", Memilih : " + resultData.getString("candidateId") + ", Sebanyak : " + resultData.getString("cnt") + "\n"; 

            }

            // close statement and connection
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String hasilPilkatsukPerEventWakil() {
        cConfig.connection();

        // nilai default var data
        String data = "Data Masih Kosong";

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // Querry MYSQL
            String query = "SELECT event.eventId, candidate.candidateId, eventcandidate.eventCandidateId, COUNT(*) cnt FROM user JOIN vote ON user.codeUser = vote.codeUser JOIN eventcandidate ON vote.codeEventCandidate = eventcandidate.codeEventCandidate JOIN event ON eventCandidate.codeEvent = event.codeEvent JOIN candidate ON eventcandidate.codeCandidate = candidate.codeCandidate WHERE eventcandidate.eventCandidateId = 'WAKIL' GROUP BY 1,2,3 ORDER BY cnt DESC";

            // eksekusi querry
            resultData = statement.executeQuery(query);

            // set var data jadi null
            data = "";

            // looping pengisian variabel data
            while(resultData.next()){

                data +=  "Desa : " + resultData.getString("eventId") + ", Memilih : " + resultData.getString("candidateId") + ", Sebanyak : " + resultData.getString("cnt") + "\n"; 

            }

            // close statement and connection
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String lihatDesa() {
        cConfig.connection();

        // nilai default var data
        String data = "Data Masih Kosong";

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // Querry MYSQL
            String query1 = "SELECT * from event";

            // eksekusi querry
            resultData = statement.executeQuery(query1);

            // set var data jadi null
            data = "";
            
            // looping pengisian variabel data
            while(resultData.next()){
                data +=  resultData.getString("codeEvent") + "." + resultData.getString("eventId") + "\n";

            }


            // close statement and connection
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String lihatKandidat() {
        cConfig.connection();

        // nilai default var data
        String data = "Data Masih Kosong";

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // Querry MYSQL
            String query1 = "SELECT * from candidate";

            // eksekusi querry
            resultData = statement.executeQuery(query1);

            // set var data jadi null
            data = "";
            
            // looping pengisian variabel data
            while(resultData.next()){
                data +=  resultData.getString("codeCandidate") + "." + resultData.getString("candidateId") + "\n";

            }
            // close statement and connection
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static String lihatDesaVoter() {
        cConfig.connection();

        // nilai default var data
        String data = "Data Masih Kosong";

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // Querry MYSQL
            String query1 = "SELECT * from event";

            // eksekusi querry
            resultData = statement.executeQuery(query1);

            // set var data jadi null
            data = "";
            
            // looping pengisian variabel data
            while(resultData.next()){
                data +=  resultData.getString("codeEvent") + "." + resultData.getString("eventId") + "\n";

            }


            // close statement and connection
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public static boolean ngeVoteKetua( String ketua, String lihatDesaVoter) {
        cConfig.connection();
        
        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "INSERT INTO `eventcandidate` (`codeEventCandidate`,`eventCandidateId`, `codeEvent`, `codeCandidate`, `status`) VALUES (NULL, 'Ketua', '"+lihatDesaVoter+"', '"+ketua+"', 'active');" ;

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

    public static boolean ngeVoteWakil(String wakil, String lihatDesaVoter ) {
        cConfig.connection();
        
        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "INSERT INTO `eventcandidate` (`codeEventCandidate`,`eventCandidateId`, `codeEvent`, `codeCandidate`, `status`) VALUES (NULL, 'Wakil', '"+lihatDesaVoter+"', '"+wakil+"', 'active');" ;

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

    public static boolean voteKetua(String tiketId) {
        cConfig.connection();

        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "INSERT INTO vote (codeEventCandidate, codeUser) VALUES ((SELECT MAX(codeEventCandidate) FROM eventcandidate)-1,'"+tiketId+"');" ;

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

    public static boolean voteWakil(String tiketId) {
        cConfig.connection();

        boolean data = false ;

        try {

            statement = connect.createStatement();

            String query = "INSERT INTO vote (codeEventCandidate, codeUser) VALUES ((SELECT MAX(codeEventCandidate) FROM eventcandidate),'"+tiketId+"');" ;

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

    public static String ticketId(String userid) {
        cConfig.connection();

        String data = "Data tidak di temukan";

        try {

            statement = connect.createStatement();
            
            String query = "SELECT * FROM user Where userId = '"+userid+"'";

            resultData = statement.executeQuery(query);

            data = "";

            while(resultData.next()) {
                data +=  "Tiket Voting kamu adalah : " + resultData.getString("codeUser") ; 
            }

            // close statement
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;

        
    }
    

}
