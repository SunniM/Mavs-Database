package MavsDatabase;


import java.sql.*;


public class Main {
    public static void main(String[] args) {

      Connection conn = Driver.newConnection();
      new MainPage();

      
      /* 
      THIS IS THE BASIC STRUCTURE FOR WRITING QUERIES
      
      try {
        Statement myStatement = conn.createStatement();
        myStatement.executeQuery("select * from players");
        ResultSet myResultSet = myStatement.getResultSet();
        while(myResultSet.next()){
          System.out.println(myResultSet.getString("number") + " "+ myResultSet.getString("name"));
        }
        
      } catch (Exception e) {
        e.printStackTrace();
      }

      */

    }
}
