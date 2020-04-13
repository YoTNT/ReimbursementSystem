package dev.jian.daos;

import java.util.List;

import dev.jian.entities.Reimbursement;

public interface ReimbursementDAO {

	Reimbursement getReimbursementById(Reimbursement reimbursement);
	List<Reimbursement> getReimbursementByRequesterId(int id);
	List<Reimbursement> getReimbursementByStatus(String status);
	List<Reimbursement> getAllReimbursement();
	
	Reimbursement createReimbursement(Reimbursement reimbursement);
	Reimbursement updateReimbursement(Reimbursement reimbursement);
}
