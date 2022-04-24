package MavsDatabase;

import java.lang.reflect.Constructor;
import java.sql.Connection;

/**
 * Command
 */
public abstract class Command 
{
    Connection conn;
   
    public Command(Connection connection) {
        this.conn = connection;
    }
    public static Command CreateCommandDynamically(String commandClassName, Connection connection)
    {
        Class<?>    concreteCommandClass    = null;
        Command     command                 = null;
        String      packageName             = "MavsDatabase"; 

        try 
        {
            concreteCommandClass = Class.forName(packageName + "." + commandClassName);
            Constructor<?> con = concreteCommandClass.getConstructor(Connection.class);
            command = (Command)con.newInstance(connection);
        } 
        catch (final Exception e) 
        {
            e.printStackTrace();
        }

        return command;
    }
    //An abstract method that must be overriden in subclasses of class Command
    public abstract void Execute();
    public abstract void Execute(String playerNum);

}