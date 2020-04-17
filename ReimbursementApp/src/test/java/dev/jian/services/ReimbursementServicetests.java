package dev.jian.services;

import static org.junit.Assert.*;

import org.junit.Test;

import dev.jian.entities.Reimbursement;

public class ReimbursementServicetests {

	public static ReimbursementService rmserv = new ReimbursementServiceImpl();
	
	@Test
	public void submitReimbursement() {
		Reimbursement rm1 = new Reimbursement();
		rm1.setrId(0);
		rm1.setAmount(1000);
		rm1.setDescription("Testing in JUNIT");
		rm1.setRequesterId(1);
		rm1.setStatus("Pending");
		
		rmserv.submitReimbursement(rm1);
	}

	@Test
	public void approveReimbursement() {
		Reimbursement rm2 = new Reimbursement();
		rm2.setrId(4);
		rm2.setAmount(1000);	// DUMMY
		rm2.setDescription("Testing in JUNIT");	// DUMMY
		rm2.setRequesterId(1);	// DUMMY
		rm2.setStatus("Pending");	// DUMMY
		
		rmserv.approveReimbursement(rm2);
	}
	
	@Test
	public void denyReimbursement() {
		Reimbursement rm3 = new Reimbursement();
		rm3.setrId(4);
		rm3.setAmount(1000);	// DUMMY
		rm3.setDescription("Testing in JUNIT");	// DUMMY
		rm3.setRequesterId(1);	// DUMMY
		rm3.setStatus("Pending");	// DUMMY
		
		rmserv.denyReimbursement(rm3);
	}
}
