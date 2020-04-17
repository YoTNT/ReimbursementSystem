package dev.jian.daotests;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.jian.daos.ReimbursementDAO;
import dev.jian.daos.ReimbursementDAOmaria;
import dev.jian.entities.Reimbursement;

public class ReimbursementDAOmariatests {
	
	public static ReimbursementDAO rmdao = new ReimbursementDAOmaria();

	@Test
	public void getAllReimbursement() {
		System.out.println(rmdao.getAllReimbursement());
	}

	
	@Test
	public void getReimbursementByid() {
		Reimbursement rm = new Reimbursement();
		rm.setrId(4);
		System.out.println(rmdao.getReimbursementById(rm));
	}
	
	@Test
	public void getReimbursementByRequesterId() {
		System.out.println(rmdao.getReimbursementByRequesterId(1));
		System.out.println(rmdao.getReimbursementByRequesterId(3));
	}
	
	@Test
	public void getReimbursementByStatus() {
		System.out.println(rmdao.getReimbursementByStatus("Pending"));
	}
	
	@Test
	public void createReimbursement() {
		Reimbursement rm = new Reimbursement();
		rm.setrId(999); // DUMMY
		rm.setAmount(2000);
		rm.setDescription("Flighting cost");
		rm.setDatetime("2020.4.13.16.51.00");
		rm.setRequesterId(1);
		rm.setStatus("Pending");
		
		System.out.println(rmdao.createReimbursement(rm));
	}
	
	@Test
	public void updateReimbursement() {
		Reimbursement rm = new Reimbursement();
		rm.setrId(1);
		rm.setAmount(2000);	// DUMMY
		rm.setDescription("Flighting cost");	// DUMMY
		rm.setDatetime("2020.4.13.16.51.00");	// DUMMY
		rm.setRequesterId(1);	// DUMMY
		rm.setStatus("Approved");
		
		System.out.println(rmdao.updateReimbursement(rm));
	}
}
