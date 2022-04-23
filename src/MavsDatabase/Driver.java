package MavsDatabase;


import java.sql.*;

public class Driver {

    public static void main(String[] args) {
        
        String user = "user";
        String password = "password";
        try {

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dallas_mavs", user, password);

            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from players");

            while(resultSet.next()) {

                System.out.println(resultSet.getString("number"));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}