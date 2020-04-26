package dev.jian.services;

import java.util.List;

import dev.jian.entities.Employee;
import dev.jian.entities.Reimbursement;

public interface ReimbursementService {

	public Reimbursement submitReimbursement(Reimbursement reimbursement);
	public Reimbursement approveReimbursement(Reimbursement reimbursement);
	public Reimbursement denyReimbursement(Reimbursement reimbursement);
	
	public List<Reimbursement> getReimbursementsByEmployee(Employee employee);
	public List<Reimbursement> getReimbursementsByStatus(String status);
}
