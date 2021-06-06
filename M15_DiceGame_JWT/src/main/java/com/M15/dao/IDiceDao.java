package com.M15.dao;

import javax.transaction.Transactional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.M15.dto.Dice;

@Repository
@Transactional
public interface IDiceDao extends MongoRepository<Dice, String> {

}