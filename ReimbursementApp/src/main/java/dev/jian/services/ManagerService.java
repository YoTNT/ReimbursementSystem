package dev.jian.services;

import dev.jian.entities.Manager;
import dev.jian.exceptions.ManagerNotExistException;
import dev.jian.exceptions.UnmatchPasswordException;

public interface ManagerService {

	public Manager managerLogin(Manager manager) throws ManagerNotExistException, UnmatchPasswordException;
}
