package com.M15.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.M15.dto.Player;

@Repository
@Transactional
public interface IPlayerDao extends MongoRepository<Player, String> {

	public List<Player> findByUsernameContains(String userName);

}