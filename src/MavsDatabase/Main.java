package MavsDatabase;


import java.sql.*;


public class Main {
    public static void main(String[] args) {

      Connection conn = Driver.newConnection();
      new MainPage(conn);

      
      
      //THIS IS THE BASIC STRUCTURE FOR WRITING QUERIES
      
      try {

        Statement myStatement = conn.createStatement();
        String s1,s2,s3;

        myStatement.executeQuery("SELECT number, Name, 2PT_FG, 3PT_FG, ASSISTS FROM players, offensive_stats WHERE number=PLAYER_NUM AND 3PT_FG IN( SELECT 3PT_FG FROM players, offensive_stats where number=player_num and assists in (select assists from players,offensive_stats where number=player_num order by assists desc) order by 2PT_FG desc) order by 3PT_FG desc limit 5;");


        ResultSet myResultSet = myStatement.getResultSet();
        while(myResultSet.next()){
          System.out.println(myResultSet.getString("number") + " "+ myResultSet.getString("name"));
        }
        
      } catch (Exception e) {
        e.printStackTrace();
      }
      
    }
}
