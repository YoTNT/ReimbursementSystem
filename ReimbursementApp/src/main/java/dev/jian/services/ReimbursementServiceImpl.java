package dev.jian.services;

import dev.jian.daos.ReimbursementDAO;
import dev.jian.daos.ReimbursementDAOmaria;
import dev.jian.entities.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService{

	private ReimbursementDAO reimbursementdao = new ReimbursementDAOmaria();
	
	@Override
	public Reimbursement submitReimbursement(Reimbursement reimbursement) {
		return reimbursementdao.createReimbursement(reimbursement);
	}

	@Override
	public Reimbursement approveReimbursement(Reimbursement reimbursement) {
		String status = "Approved";
		reimbursement.setStatus(status);
		return reimbursementdao.updateReimbursement(reimbursement);
	}

	@Override
	public Reimbursement denyReimbursement(Reimbursement reimbursement) {
		String status = "Denied";
		reimbursement.setStatus(status);
		return reimbursementdao.updateReimbursement(reimbursement);
	}

}