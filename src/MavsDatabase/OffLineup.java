package MavsDatabase;

import java.sql.*;
import java.sql.Connection;
import java.util.LinkedList;
import javax.swing.*;

public class OffLineup extends Command {

    public OffLineup(Connection connection) {
        super(connection);
        //TODO Auto-generated constructor stub
    }


    public ResultSet makeQuery() {
        try {
            Statement myStatement = conn.createStatement();
            myStatement.executeQuery("select * from defensive_stats");
            ResultSet myResultSet = myStatement.getResultSet();
            return myResultSet;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public void createAndShowGUI() {

        JFrame frame = new JFrame("Defensive Statistics");
        String[] column = { "PLAYER_NUM", "STEALS", "BLOCKS", "DEFENSIVE_RDB" };
        JTable jt = new JTable(getData(column, makeQuery()), column);
        jt.setBounds(30, 40, 1000, 3000);
        JScrollPane sp = new JScrollPane(jt);
        frame.add(sp);
        frame.setSize(1000, 400);
        frame.setVisible(true);

        // JTable table = new JTable(resultSet.getMetaData();
    }

    public String[][] getData(String[] column, ResultSet resultSet) {

        LinkedList<LinkedList<String>> list = new LinkedList<>();
        LinkedList<String> row;
        try {
            while (resultSet.next()) {
                row = new LinkedList<>();
                for (String string : column) {
                    // resultSet.getArray(string);
                    row.add(resultSet.getString(string));
                }
                list.add(row);
            }
        } catch (Exception e) {
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
        createAndShowGUI();
    }

}
