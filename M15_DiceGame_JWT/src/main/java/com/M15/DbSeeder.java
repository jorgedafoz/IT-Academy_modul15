package com.M15;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.M15.dao.IDiceDao;
import com.M15.dao.IPlayerDao;
import com.M15.dto.Dice;
import com.M15.dto.Player;

@Component
public class DbSeeder implements CommandLineRunner {
	private IPlayerDao iPlayerDao;
	private IDiceDao iDiceDao;

	public DbSeeder(IPlayerDao iPlayerDao, IDiceDao iDiceDao) {
		this.iPlayerDao = iPlayerDao;
		this.iDiceDao = iDiceDao;
	}

	@Override
	public void run(String... args) throws Exception {
		// drop existing data
		iPlayerDao.deleteAll();
		iDiceDao.deleteAll();
		// create data
		Player paul = new Player("1","Paul", "bass");
		paul.setRole(com.M15.security.DiceGameRoles.AUTHOR);
		Player john = new Player("2","John", "guitar");
		john.setRole(com.M15.security.DiceGameRoles.ADMIN);
		iPlayerDao.save(paul);
		iPlayerDao.save(john);
		iDiceDao.save(new Dice("1"));
		iDiceDao.save(new Dice("1"));
		iDiceDao.save(new Dice("1"));
		iDiceDao.save(new Dice("1"));
		iDiceDao.save(new Dice("1"));
		iDiceDao.save(new Dice("1"));

		iPlayerDao.save(new Player("3", "George", "baseguitar"));
		iDiceDao.save(new Dice("3"));
		iDiceDao.save(new Dice("3"));
		iDiceDao.save(new Dice("3"));
		iDiceDao.save(new Dice("3"));
		iDiceDao.save(new Dice("3"));
		iDiceDao.save(new Dice("3"));

		iPlayerDao.save(new Player("4", "Ringo", "drums"));
		iDiceDao.save(new Dice("4"));
		iDiceDao.save(new Dice("4"));
		iDiceDao.save(new Dice("4"));
		iDiceDao.save(new Dice("4"));
		iDiceDao.save(new Dice("4"));
		iDiceDao.save(new Dice("4"));
	}
}