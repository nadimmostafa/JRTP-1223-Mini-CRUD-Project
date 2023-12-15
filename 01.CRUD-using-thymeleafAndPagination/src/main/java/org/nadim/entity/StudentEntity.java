package org.nadim.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="std_tab")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	@Column(name="s_id")
	private Integer studentId;
	
	@Column(name="s_name")
	private String studentName;
	
	private String email;
	
	@Column(name="s_gender")
	private String studentGender;
	
	@Column(name="s_dept")
	private String studentDept;
	
	@Column(name="s_fee_per_Month")
	private Double admissionFeePerMonth;
	
	@Column(name="s_total_fee")
	private Double  yearlyFee;
	
}
