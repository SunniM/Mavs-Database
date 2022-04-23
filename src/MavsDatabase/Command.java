package MavsDatabase;


/**
 * Command
 */
public abstract class Command 
{
    //TODO: add necessary fields to this class
   
    public Command() {
        System.out.println("testing");
    }

    //An abstract method that must be overriden in subclasses of class Command
    public abstract void Execute(); 
}