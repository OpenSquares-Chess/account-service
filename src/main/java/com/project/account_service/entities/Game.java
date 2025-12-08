package com.project.account_service.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document (collection = "games")
public class Game {

    @Id
    private String gameId;
    private String playerOneId;
    private String playerTwoId;
    private int playerOneRating;
    private int playerTwoRating;
    private String date;
    private String pgn;
    private String result;

    public Game(String gameId, String playerOneId, String playerTwoId, int playerOneRating, int playerTwoRating, String date, String pgn, String result) {
        this.gameId = gameId;
        this.playerOneId = playerOneId;
        this.playerTwoId = playerTwoId;
        this.playerOneRating = playerOneRating;
        this.playerTwoRating = playerTwoRating;
        this.date = date;
        this.pgn = pgn;
        this.result = result;
    }

    public String getGameId() {
        return gameId;
    }
    public void setGameId(String gameId) {this.gameId = gameId;}

    public String getPlayerOneId() {return playerOneId;}
    public void setPlayerOneId(String playerOneId) {this.playerOneId = playerOneId;}

    public String getPlayerTwoId() {return playerTwoId;}
    public void setPlayerTwoId(String playerTwoId) {this.playerTwoId = playerTwoId;}

    public int getPlayerOneRating() {return playerOneRating;}
    public void setPlayerOneRating(int playerOneRating) {this.playerOneRating = playerOneRating;}

    public int getPlayerTwoRating() {return playerTwoRating;}
    public void setPlayerTwoRating(int playerTwoRating) {this.playerTwoRating = playerTwoRating;}

    public String getDate() {return date;}
    public void setDate(String date) {this.date = date;}

    public String getPgn() {return pgn;}
    public void setPgn(String pgn) {this.pgn = pgn;}

    public String getResult() {return result;}
    public void setResult(String result) {this.result = result;}

}
