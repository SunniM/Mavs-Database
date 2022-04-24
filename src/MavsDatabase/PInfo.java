package MavsDatabase;

import java.sql.*;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PInfo extends Command {
    
    public PInfo(Connection connection) {
        super(connection);
    }

    public ResultSet makeQuery() {
        try {
            int temp = 7;
            Statement myStatement = conn.createStatement();
            myStatement.executeQuery("select * from players");
            ResultSet myResultSet = myStatement.getResultSet();
            return myResultSet;            
          } catch (Exception e) {
            e.printStackTrace();
          }
          return null;
    
    }


    public  void createAndShowGUI() {

        JFrame frame = new JFrame("Player Information");
        String[] column = {"number", "name", "age","height", "weight", "games_played", "years_played","minutes_played","personal_fouls"};

        JTable jt = new JTable(getData(column,makeQuery()), column);
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
    
}
