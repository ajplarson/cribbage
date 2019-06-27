package ui;

import dto.Player;
import java.util.List;

/**
 *
 * @author jackelder
 */
public class View {
    private UserIOConsole io;
    
    public View(UserIOConsole io){
        this.io = io;
    }
    
    public void displayWelcome(){
        io.print("=== Let's Play Cribbage! ===");
    }
    
    public int printMenuAndGetSelection() {
        io.print("===== GAME TYPE =====");
        io.print("1. Human vs. Human");
        io.print("2. Human vs. Computer");
        io.print("3. Computer vs. Computer");
        io.print("4. Exit");
        return io.readInt("Please select from the above choices.", 1, 4);
    }


    public void displayPlayerList(List<Player> playerList) {
        for (Player currentPlayer : playerList) {
            io.print("_________________________");
            io.print("Player: ");
            io.print(currentPlayer.getName());
            io.print("Wins: " + currentPlayer.getWins());
            io.print("Losses: " + currentPlayer.getLosses());
            io.print("Date created: " + currentPlayer.getDateCreated().toString());
            io.print("Last game player: " + currentPlayer.getLastGame().toString());
            io.print("_________________________");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayPlayerInformationBanner() {
        io.print("===== PlayerInformation =====");
    }

    public void displayPlayer(Player player) {
        io.print("_________________________");
        io.print("Player: ");
        io.print(player.getName());
        io.print("Wins: " + player.getWins());
        io.print("Losses: " + player.getLosses());
        io.print("Date created: " + player.getDateCreated().toString());
        io.print("Last game player: " + player.getLastGame().toString());
        io.print("_________________________");
        io.readString("Please hit enter to continue.");
    }

    //exit message
    public void displayExitBanner() {
        io.print("________");
        io.print("GOOD BYE");
        io.print("________");
    }

    //error handling
    public void displayUnknownCommand() {
        io.print("Unknown Command");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
