package dev.jian.services;

import java.util.ArrayList;
import java.util.List;

import dev.jian.daos.ManagerDAO;
import dev.jian.daos.ManagerDAOmaria;
import dev.jian.entities.Manager;
import dev.jian.exceptions.ManagerNotExistException;
import dev.jian.exceptions.UnmatchPasswordException;

public class ManagerServiceImpl implements ManagerService{

	private ManagerDAO mandao = new ManagerDAOmaria();
	
	@Override
	public Manager managerLogin(Manager manager) throws ManagerNotExistException, UnmatchPasswordException {
		
		boolean managerExist = false;
		boolean passwordCorrect = false;
		
		List<Manager> managers = new ArrayList<Manager>(mandao.getAllManager());
		Manager result = new Manager();
		
		for(Manager m : managers) {
			
			if(m.getUsername().equals(manager.getUsername())) {
				managerExist = true;
				if(m.getPassword().equals(manager.getPassword())) {
					passwordCorrect = true;
					
					result.setmId(m.getmId());
					result.setName(m.getName());
					result.setUsername(m.getUsername());
					result.setPassword(m.getPassword());
					
					return result;
				}
			}
		}
		
		if(!managerExist)
			throw new ManagerNotExistException();
		if(managerExist && !passwordCorrect)
			throw new UnmatchPasswordException();
		
		return null;
	}

	
	
}
