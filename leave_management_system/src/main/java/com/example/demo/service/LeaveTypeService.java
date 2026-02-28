package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.model.LeaveType;
import com.example.demo.repository.LeaveTypeRepository;

@Service
public class LeaveTypeService {
	private LeaveTypeRepository leaveTypeRepository;

	public LeaveTypeService(LeaveTypeRepository leaveTypeRepository) {
		super();
		this.leaveTypeRepository = leaveTypeRepository;
	}
	
	public List<LeaveType> fecthLeaveType(){
		return leaveTypeRepository.findAll();
	}
	
	public void saveLeaveType(LeaveType leaveType) {
		leaveTypeRepository.save(leaveType);
	}
	
	public LeaveType getLeaveTypeById(Long id) {
		return leaveTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Leave Type Not Found"));
	}
	
	public void deleteLeaveType(Long id) {
		leaveTypeRepository.deleteById(id);
	}
}
