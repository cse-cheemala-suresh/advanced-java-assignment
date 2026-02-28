package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "leave_type")
@Data
@NoArgsConstructor
public class LeaveType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "leave_id")
	private Long leaveId;
	
	@Column(name = "leave_name")
	private String leaveName;
	
	@Column(name = "max_allowed_days")
	private int maxAllowedDays;

	public LeaveType(String leaveName, int maxAllowedDays) {
		super();
		this.leaveName = leaveName;
		this.maxAllowedDays = maxAllowedDays;
	}
	
}
