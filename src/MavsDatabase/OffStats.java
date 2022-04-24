package MavsDatabase;

import java.sql.*;
import java.util.LinkedList;
import javax.swing.*;

public class OffStats extends Command{

    String playerNum = null;

    public OffStats(Connection connection) {
        super(connection);
    }
    public ResultSet makeQuery() {
        try {
            Statement myStatement = conn.createStatement();
            myStatement.executeQuery("select * from offensive_stats, players where number=player_num");
            ResultSet myResultSet = myStatement.getResultSet();
            return myResultSet;            
          } catch (Exception e) {
            e.printStackTrace();
          }
          return null;
    
    }

    public ResultSet makeQuery(String number) {

        try {
            Statement myStatement = conn.createStatement();
            myStatement.executeQuery("select * from offensive_stats, players where number=player_num and number="+number);
            ResultSet myResultSet = myStatement.getResultSet();
            return myResultSet;            
          } catch (Exception e) {
            e.printStackTrace();
          }
          return null;
    
    }


    public  void createAndShowGUI() {

        JFrame frame = new JFrame("Offensive Statistics");
        String[] column = {"NAME","PLAYER_NUM","POINTS", "TURNOVERS", "2PT_FGA", "2PT_FG", "3PT_FGA", "3PT_FG", "FTA", "FREETHROW", "OFFENSIVE_RBD", "ASSISTS",};

        ResultSet rSet;
        if(playerNum==null)
            rSet=makeQuery();
        else
            rSet=makeQuery(playerNum);
        JTable jt = new JTable(getData(column,rSet), column);
        jt.setBounds(30,40,1000,3000);
        JScrollPane sp=new JScrollPane(jt);
        frame.add(sp);
        frame.setSize(1000,400);
        frame.setVisible(true); 
        

        //JTable table = new JTable(resultSet.getMetaData();
    }

    public String[][] getData(String[] column, ResultSet resultSet) {

        LinkedList<LinkedList<String>> list = new LinkedList<>();
        LinkedList<String> row;
        try {
            while(resultSet.next()){
                row = new LinkedList<>();
                for (String string : column) {
                    //resultSet.getArray(string);
                    row.add(resultSet.getString(string));
                }
                list.add(row);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        for (String string : column) {
            string = string.toUpperCase();
        }
        return list.stream().map(l -> l.stream().toArray(String[]::new)).toArray(String[][]::new);
    }
    

    @Override
    public void Execute() {
        createAndShowGUI();
    }

    @Override
    public void Execute(String playerNum) {
        this.playerNum=playerNum;
        createAndShowGUI();
    }
    
}