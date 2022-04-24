package MavsDatabase;


import java.sql.*;

public class Driver {

    public static Connection newConnection(){
        
        String user = "user";
        String password = "password";
        String ip;

        // IP address depends on location of server. Ask Sunni which ip to use.

        //ip = "localhost"; //use only if hosting mysql server
        //ip = "10.177.183.196";
        //ip = " 10.8.66.31"; 
        ip = "172.20.10.2";

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://"+ip+":3306/dallas_mavs", user, password);
            return conn;

        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}