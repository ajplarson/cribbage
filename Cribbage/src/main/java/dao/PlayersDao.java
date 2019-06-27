package dao;

import dto.Player;
import java.util.List;

/**
 *
 * @author jackelder
 */
public interface PlayersDao {
    
    public List<Player> getAllPlayers();
    
    public Player createPlayer();
    
    public Player getPlayer();
    
    public Player updatePlayer();
    
    public Player deletePlayer();
    
}
