package com.config;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

import com.page.menu;

import java.sql.ResultSet;

public class cConfig {
    // ini untuk mendefinisikan koneksi ke database akatsuki
    private static final String koneksi = "com.mysql.jdbc.Driver"; 
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
            // TODO: handle exception
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
            // while(resultData.next()){
            //     data = "Welcome " + resultData.getString("userId") + " " + resultData.getString("role");
            // }

            if (logUsername.equals(resultData.getString(2))){
                System.out.println("Sukses Login");
            } else {
                System.out.println("Login Gagal");
            }

                        
            // close statement and connection
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return data;
    }


    public static String getAllData() {
        cConfig.connection();

        // nilai default var data
        String data = "Data Masih Kosong";

        try {

            // buat object statement yang ambil dari koneksi
            statement = connect.createStatement();

            // Querry MYSQL
            String query = "SELECT candidateId, createdAt FROM candidate";

            // eksekusi querry
            resultData = statement.executeQuery(query);

            // set var data jadi null
            data = "";
            
            // looping pengisian variabel data
            while(resultData.next()){
                data += "candidateID :" + resultData.getString("candidateID") + ", Created At : " + resultData.getString("createdAt") + "\n"; 
            }

            // close statement and connection
            statement.close();
            connect.close();
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return data;
    }




}
