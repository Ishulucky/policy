package com.insurance.Insurance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.insurance.Insurance.Repository.InsuranceRepository;
import com.insurance.Insurance.model.InsurancePolicy;

@Controller
public class InsuranceController {
	@Autowired
	private InsuranceRepository insuRepository;

	// To get into PolicyHomePage
	@GetMapping("/link")
	public String getAllLinks() {
		return "Links";
	}

	//To view Policies
	@GetMapping("/getpolicy")
	public String getAllPolicy(Model m) {
		List<InsurancePolicy> p = insuRepository.listAllPolicy();
		m.addAttribute("policies", p);
		return "ViewPolicy";
	}



	// To view schedule at insurance side
	@GetMapping("/getpolicySchedule")
	public String getAllPolicySchedule(Model m) {
		m.addAttribute("schedules", insuRepository.listAllPolicySchedules());
		return "ViewSchedule";
	}

	// To view Policy for Policy Approval
	@GetMapping("/updatepolicy")
	public String updateFormStatus(Model m) {
		List<InsurancePolicy> p = insuRepository.listAllPolicy();
		m.addAttribute("policies", p);
		return "StatusApproval";
	}

	//To Update Status of a particular policy
	@GetMapping("/UpdatestatusPolicy")
	public String updatedStatusPolicy(@ModelAttribute("policy") InsurancePolicy policy) {
		insuRepository.updateNewPolicy(policy);

		return "redirect:/getpolicy";
	}

	//To get no of months that a particular policy has not been paid 
	@GetMapping("/nonPaymentStatus")
	public String getNonPaymentStatus(@RequestParam("iplcId") int id, Model m) {
		int p = insuRepository.listNonStatusPayments(id);
		m.addAttribute("policies", p);
		return "ViewNonPaymentStatus";

	}

	//To get into distinct policy id page for checking non status payment checking
	@GetMapping("/StatusPaymentById")
	public String getDistinctIplcIds(Model model) {
		List<Integer> distinctIplcIds = insuRepository.findDistinctIds();
		model.addAttribute("distinctIplcIds", distinctIplcIds);
		return "StatusById";
	}

	//To get distinct policy id for get particular schedule
	@GetMapping("/ScheduleById")
	public String getScheduleDistinctIplcIds(Model model) {
		List<Integer> distinctIplcIds = insuRepository.findDistinctIds();
		model.addAttribute("distinctIplcIds", distinctIplcIds);
		return "ViewScheduleById";
	}

	// to get particular Schedule of particular policy id
	@GetMapping("/getpolicyScheduleById")
	public String getAllPolicyScheduleById(@RequestParam("iplcId") int id, Model m) {
		m.addAttribute("schedules", insuRepository.listAllPolicySchedulesById(id));
		return "ViewScheduleByIds";
	}

}
