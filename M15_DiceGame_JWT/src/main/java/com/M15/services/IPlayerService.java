package com.M15.services;

import java.util.List;

import com.M15.dto.Player;

public interface IPlayerService {

	public Player savePlayer(Player player);

	public Player findPlayerById(String id);

	public List<Player> findAllPlayers();

	public void sortBySuccesRate(List<Player> players);

	public void deletePlayer(String id) throws Exception;
	
	public List<Player> saveAll();

}