package CribbageGame;

public class Game {
    private int playerOneScore;
    private int playerTwoScore;
    private boolean playerOneIsDealer; //true if player1 is dealer, false if player2 is dealer
    private final int WIN_SCORE = 30;
    
    public Game(){
        
    }
    
    public void playComputerComputerGame(){
        
        playerOneIsDealer = true;
        
        while(playerOneScore < WIN_SCORE && playerTwoScore < WIN_SCORE){
            Round round = new Round();
            round.run();
            if(playerOneIsDealer){
                playerOneScore += round.getDealerScore();
                playerTwoScore += round.getPonyScore();
            }else{
                playerOneScore += round.getPonyScore();
                playerTwoScore += round.getDealerScore();
            }
            System.out.println("===========\nPlayer One is Dealer? "+playerOneIsDealer);
            System.out.println("Player One Score: "+playerOneScore);
            System.out.println("Player Two Score: "+playerTwoScore);
            playerOneIsDealer = !playerOneIsDealer;
        }
    } 
}
