package org.nadim.utils;

import java.util.Arrays;

import org.nadim.entity.StudentEntity;
import org.springframework.ui.Model;

public interface StudentUtils {
	
	// Send department data  dynamically to UI
	public static void deptList(Model model) {
		model.addAttribute("list",Arrays.asList("CSE","BBA","EEE","Pharmacy","LLB"));
	}
	
	// total admission fee calculation
	
	public static void intiAdmissionFeeCal(StudentEntity std) {
		Double fee = std.getAdmissionFeePerMonth();
		Double totalFee  = fee*12;
		std.setYearlyFee(totalFee);
	}
}
