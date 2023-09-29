package com.insurance.Insurance.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.insurance.Insurance.contracts.InsuranceDAO;
import com.insurance.Insurance.model.InsurancePolicy;
import com.insurance.Insurance.model.InsurancePolicySchedule;

@Repository
public class InsuranceRepository {
	@Autowired
	private InsuranceDAO insuranceDAO;
	

	//To get all policy list
	public List<InsurancePolicy> listAllPolicy() {
		List<InsurancePolicy> pack = insuranceDAO.getAllPolicies();
		return pack;
	}

	//To get List of all Schedules
	public List<InsurancePolicySchedule> listAllPolicySchedules() {
		List<InsurancePolicySchedule> s = insuranceDAO.getAllSchedule();
		return s;
	}

	//To get list of all Schedules for a particular id
	public List<InsurancePolicySchedule> listAllPolicySchedulesById(int id) {
		List<InsurancePolicySchedule> s = insuranceDAO.getAllScheduleById(id);
		return s;
	}

    // to Update Status for a particular policy for policy Approval
	public int updateNewPolicy(InsurancePolicy u) {
		return insuranceDAO.updateStatus(u);
	}

//To get number of months a particular id does not paid the policy 
	public int listNonStatusPayments(int id) {
		return insuranceDAO.getNonPaymentStatus(id);
	}

	// to get distinct policy id
	public List<Integer> findDistinctIds() {
		return insuranceDAO.findDistinctIplcIds();
	}

}
