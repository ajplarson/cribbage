package ui;

/**
 *
 * @author jackelder
 */
public class View {
    private UserIOConsole io;
    
    public View(UserIOConsole io){
        this.io = io;
    }
    
    public void displayWelcome() {
        io.print("Let's cribbage");
    }
    
    
}
