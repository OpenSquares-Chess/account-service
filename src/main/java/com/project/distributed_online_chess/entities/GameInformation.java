package com.project.distributed_online_chess.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class GameInformation {

    @Id
    private int gameId;
    private String playerWhiteId;
    private String playerBlackId;
    private String rating;
    private String date;

    private List<GameMove> gameMoves;

    public GameInformation() {
    }

    public GameInformation(int gameId, String playerWhiteId, String playerBlackId, String rating, String date, List<GameMove> gameMoves) {
        this.gameId = gameId;
        this.playerWhiteId = playerWhiteId;
        this.playerBlackId = playerBlackId;
        this.rating = rating;
        this.date = date;
        this.gameMoves = gameMoves;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getPlayerWhiteId() {
        return playerWhiteId;
    }

    public void setPlayerWhiteId(String playerWhiteId) {
        this.playerWhiteId = playerWhiteId;
    }

    public String getPlayerBlackId() {
        return playerBlackId;
    }

    public void setPlayerBlackId(String playerBlackId) {
        this.playerBlackId = playerBlackId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<GameMove> getGameMoves() {
        return gameMoves;
    }

    public void setGameMoves(List<GameMove> gameMoves) {
        this.gameMoves = gameMoves;
    }
}
