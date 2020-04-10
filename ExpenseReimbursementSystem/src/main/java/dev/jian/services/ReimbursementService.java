package dev.jian.services;

import dev.jian.entities.Reimbursement;

public interface ReimbursementService {

	public Reimbursement submitReimbursement(Reimbursement reimbursement);
	public Reimbursement approveReimbursement(Reimbursement reimbursement);
	public Reimbursement denyReimbursement(Reimbursement reimbursement);
}
