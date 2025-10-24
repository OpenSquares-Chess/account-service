package com.project.distributed_online_chess.dao;

import com.project.distributed_online_chess.entities.GameMove;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameMoveRepository extends MongoRepository<GameMove, String> {
}
