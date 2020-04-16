package dev.jian.daos;

import java.util.List;

import dev.jian.entities.Manager;

public interface ManagerDAO {

	Manager getManagerById(Manager manager);
	List<Manager> getAllManager();
	Manager getManagerByName(String name);
	
}
