package dev.jian.daotests;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.jian.daos.ManagerDAO;
import dev.jian.daos.ManagerDAOmaria;
import dev.jian.entities.Manager;

public class ManagerDAOmariatests {
	
	public static ManagerDAO mgdao = new ManagerDAOmaria();

	@Test
	public void getManagerById() {
		Manager m1 = new Manager();
		m1.setmId(2);
		System.out.println(mgdao.getManagerById(m1));
	}
	
	@Test
	public void getAllManager() {
		System.out.println(mgdao.getAllManager());
	}

	@Test
	public void getManagerByName() {
		String name = "Pecho Kivi";
		System.out.println(mgdao.getManagerByName(name));
	}
	
}
