package com.project.distributed_online_chess.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GameMove {

    @Id
    private int moveId;
    private String timeLeft;
    private String move;

    public GameMove() {
    }

    public GameMove(int moveId, String timeLeft, String move) {
        this.moveId = moveId;
        this.timeLeft = timeLeft;
        this.move = move;
    }

    public int getMoveId() {
        return moveId;
    }

    public void setMoveId(int moveId) {
        this.moveId = moveId;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }
}
