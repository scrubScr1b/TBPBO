package exception.app.application;

import exception.app.exception.DBErrorException;


public class DatabaseApp {
    static final String DB_URL="jdbc:mysql://localhost:3306/tugas";
    static final String USER = "root";
    static final String PASS = "wkwkland24";
    static final String Querry = "Select * From user";

    public static void ConnectDB(String user, String pass) {
        if(user.isEmpty() || pass.isEmpty()) {
            throw new DBErrorException("Fail connect to database");
        }

        System.out.println("Succes connect to database");
    }
    
}
