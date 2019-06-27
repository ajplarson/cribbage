/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author ajplarson
 */
public class Player {
    private String name;
    private int wins;
    private int losses;
    private boolean isHuman;
    private LocalDate dateCreated;
    private LocalDateTime lastGame;

    public Player(String name, boolean isHuman) {
        this.name = name;
        this.isHuman = isHuman;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public boolean isIsHuman() {
        return isHuman;
    }

    public void setIsHuman(boolean isHuman) {
        this.isHuman = isHuman;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getLastGame() {
        return lastGame;
    }

    public void setLastGame(LocalDateTime lastGame) {
        this.lastGame = lastGame;
    }
    
    
    
    
    
    
}
