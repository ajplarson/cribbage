package controller;

import CribbageGame.Game;
import dao.PlayersDao;
import ui.View;

/**
 *
 * @author jackelder
 */
public class Controller {
    private View view;
    private PlayersDao dao;
    
    public Controller(View view, PlayersDao dao){
        this.view = view;
        this.dao = dao;
    } 
    
    public void run(){
        Game game = new Game();
        game.playComputerComputerGame();
    }
    
    
}
