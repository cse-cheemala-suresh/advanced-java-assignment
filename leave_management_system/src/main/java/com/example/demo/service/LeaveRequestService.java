package com.example.demo.service;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.LeaveRequest;
import com.example.demo.repository.LeaveRequestRepository;

@Service
public class LeaveRequestService {
	private LeaveRequestRepository leaveRequestRepository;

	public LeaveRequestService(LeaveRequestRepository leaveRequestRepository) {
		super();
		this.leaveRequestRepository = leaveRequestRepository;
	}
	
	public List<LeaveRequest> fecthLeaveRequest(){
		return leaveRequestRepository.findAll();
	}
	
	public void saveLeaveRequest(LeaveRequest leaveRequest) {
		leaveRequestRepository.save(leaveRequest);
	}
	
	public void processLeaveRequest(Long requestId) {
		LeaveRequest leaveRequest = leaveRequestRepository.findById(requestId)
				.orElseThrow(() -> new RuntimeException("Leave Request Not Found"));
		long appliedDays = ChronoUnit.DAYS.between(leaveRequest.getStartDate(), leaveRequest.getEndDate()) + 1;
		
		int maxAllowedDays = leaveRequest.getLeaveType().getMaxAllowedDays();
		
		if(maxAllowedDays >= appliedDays) {
			leaveRequest.setStatus("APPROVED");
		}else {
			leaveRequest.setStatus("REJECTED");
		}
		
		leaveRequestRepository.save(leaveRequest);
	}
	
	public LeaveRequest getLeaveRequestById(Long id) {
		return leaveRequestRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Leave Request Not Found"));
	}
	
	public void deleteById(Long id) {
		leaveRequestRepository.deleteById(id);
	}
}
