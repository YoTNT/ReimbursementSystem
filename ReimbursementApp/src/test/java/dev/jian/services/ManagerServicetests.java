package dev.jian.services;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.jian.entities.Manager;

public class ManagerServicetests {
	
	public static ManagerService manserv = new ManagerServiceImpl();
	
	@Test
	public void managerLogin() {
		
		Manager man1 = new Manager();
		man1.setUsername("jianq");
		man1.setPassword("3314");
		
		System.out.println(manserv.managerLogin(man1));
		
	}

}
