package com.insurance.Insurance.contracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.insurance.Insurance.model.InsurancePolicy;
import com.insurance.Insurance.model.InsurancePolicyRowMapper;
import com.insurance.Insurance.model.InsurancePolicySchedule;
import com.insurance.Insurance.model.InsurancePolicyScheduleRowMapper;

@Repository
public class InsuranceDAoImplement implements InsuranceDAO {
	private final JdbcTemplate jdbctemplate;

	@Autowired
	public InsuranceDAoImplement(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	//To Get all Insurance Policies
	@Override
	public List<InsurancePolicy> getAllPolicies() {
		String sql = "SELECT * FROM InsurancePolicies1";
		return jdbctemplate.query(sql, new InsurancePolicyRowMapper());
	}

	//To get all Insurance Schedules
	@Override
	public List<InsurancePolicySchedule> getAllSchedule() {
		String sql = "SELECT * FROM InsurancePolicySchedule";
		return jdbctemplate.query(sql, new InsurancePolicyScheduleRowMapper());
	}

	//To get Insurance Schedules of particular Id
	@Override
	public List<InsurancePolicySchedule> getAllScheduleById(int id) {
		String sql = "select * from InsurancePolicySchedule where iplc_id=?";
		return jdbctemplate.query(sql, new InsurancePolicyScheduleRowMapper(), new Object[] { id });
	}

	
	//To Update Status either approval/rejected for a particular Id
	@Override
	public int updateStatus(InsurancePolicy e) {
		return jdbctemplate.update("UPDATE InsurancePolicies1 SET iplc_status = ? WHERE iplc_id = ?", e.getIplc_status(),
				e.getIplc_id());

	}



	//Used for check for non payment policy payment
	@Override
	public int getNonPaymentStatus(int id) {
		try {
			String sql = "SELECT COUNT(*) FROM InsurancePolicySchedule WHERE CURRENT_DATE >= iplc_date AND iplc_paid_date IS NULL AND iplc_id = ?";
			return jdbctemplate.queryForObject(sql, Integer.class, id);
		} catch (EmptyResultDataAccessException e) {
			// Handle the case where no results are found
			return 0; // or throw an exception or handle it as needed
		}
	}

	//Used for  getting distinct policy id from Schedules
	@Override
	public List<Integer> findDistinctIplcIds() {
		String sql = "SELECT DISTINCT iplc_id FROM InsurancePolicySchedule";
		return jdbctemplate.queryForList(sql, Integer.class);
	}

}
