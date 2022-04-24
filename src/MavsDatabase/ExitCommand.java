package MavsDatabase;

import java.sql.Connection;

public class ExitCommand extends Command {

    public ExitCommand(Connection connection) {
        super(connection);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void Execute() {
        // TODO Auto-generated method stub
        System.exit(0);

    }

    
}
