//package com.insurance.Insurance.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.insurance.Insurance.Repository.InsuranceRepository;
//import com.insurance.Insurance.model.InsurancePolicy;
//import com.insurance.Insurance.model.InsurancePolicySchedule;
//
//@RestController
//
//public class InsuranceRestController {
//
//	@Autowired
//	private InsuranceRepository insuranceRepository;
//
//	@GetMapping("/policy")
//	public List<InsurancePolicy> getAllPolicy() {
//		return insuranceRepository.ListAllPolicy();
//	}
//
//	@GetMapping("/policySchedule")
//	public List<InsurancePolicySchedule> getAllPolicySchedule() {
//		return insuranceRepository.ListAllPolicySchedules();
//	}
//
//	@GetMapping("/policySchedule/{id}")
//	public List<InsurancePolicySchedule> listAllPolicySchedules(@PathVariable Integer id) {
//		return insuranceRepository.ListAllPolicySchedulesById(id);
//	}
//
////	@PostMapping(value = "/createpolicy")
////	public ResponseEntity<Object> createPolicy(@RequestBody InsurancePolicy u) {
////		insuranceRepository.createNewPolicy(u);
////		return new ResponseEntity<>("Employee is created successfully", HttpStatus.CREATED);
////	}
////
////	@PutMapping("/updatepolicy")
////	public ResponseEntity<Object> updatePolicy(@RequestBody InsurancePolicy p) {
////		int result = insuranceRepository.createNewPolicy(p);
////		if (result > 0) {
////			return new ResponseEntity<>("Package is updated successfully", HttpStatus.OK);
////		} else {
////			return new ResponseEntity<>("Package update failed", HttpStatus.NOT_FOUND);
////		}
////	}
//
//}
