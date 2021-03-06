package dev.jian.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dev.jian.daos.ReimbursementDAO;
import dev.jian.daos.ReimbursementDAOmaria;
import dev.jian.entities.Employee;
import dev.jian.entities.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService{

	private ReimbursementDAO reimbursementdao = new ReimbursementDAOmaria();
	
	@Override
	public Reimbursement submitReimbursement(Reimbursement reimbursement) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		String datetime = dtf.format(now);
		reimbursement.setDatetime(datetime);	//Default
		reimbursement.setStatus("Pending");		//Default
		
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

	@Override
	public List<Reimbursement> getReimbursementsByEmployee(Employee employee) {
		
		int requesterId = employee.geteId();
		return reimbursementdao.getReimbursementByRequesterId(requesterId);
	}

	@Override
	public List<Reimbursement> getReimbursementsByStatus(String status) {
		return reimbursementdao.getReimbursementByStatus(status);
	}

}
