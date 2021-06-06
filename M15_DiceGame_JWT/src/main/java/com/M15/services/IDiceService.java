package com.M15.services;

import java.util.List;

import com.M15.dto.Dice;
import com.M15.dto.Player;

public interface IDiceService {

	public Dice rollDices(Player player);
	
	public Dice rollDicesById(String playerId);

	public List<Dice> findAllDices();
	
	public void deleteById(String id);
	
	public List<Dice> findDicesByPlayerId(String playerId) throws Exception;

}