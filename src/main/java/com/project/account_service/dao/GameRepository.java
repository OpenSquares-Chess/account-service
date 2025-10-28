package com.project.account_service.dao;

import com.project.account_service.entities.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface GameRepository extends MongoRepository<Game, String> {
    @Query("{ $or:  [ { 'playerOneId': ?0 }, { 'playerTwoId' :  ?0} ] }")
    Page<Game> findByUserId(String user_id, Pageable pageable);
}
