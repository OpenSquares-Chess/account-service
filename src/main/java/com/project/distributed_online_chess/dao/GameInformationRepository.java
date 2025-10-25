package com.project.distributed_online_chess.dao;

import com.project.distributed_online_chess.entities.GameInformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameInformationRepository extends MongoRepository<GameInformation, String> {

}
