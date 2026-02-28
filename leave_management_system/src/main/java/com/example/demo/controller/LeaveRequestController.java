package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Employee;
import com.example.demo.model.LeaveRequest;
import com.example.demo.model.LeaveType;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.LeaveRequestService;
import com.example.demo.service.LeaveTypeService;

@Controller
public class LeaveRequestController {
	private LeaveRequestService leaveRequestService;
	private EmployeeService employeeService;
	private LeaveTypeService leaveTypeService;

	public LeaveRequestController(LeaveRequestService leaveRequestService, 
			EmployeeService employeeService, LeaveTypeService leaveTypeService) {
		super();
		this.leaveRequestService = leaveRequestService;
		this.employeeService = employeeService;
		this.leaveTypeService = leaveTypeService;
	}
	
	@GetMapping("/leaveRequest")
	public String leaveRequestDetails(Model model) {
		List<LeaveRequest> leaveRequests = leaveRequestService.fecthLeaveRequest();
		model.addAttribute("leaveRequests", leaveRequests);
		return "leaveRequest";
	}
	
	@GetMapping("/addLeaveRequest")
	public String showAddForm(Model model) {
		model.addAttribute("leaveRequest", new LeaveRequest());
		model.addAttribute("employees", employeeService.fetchEmployee());
	    model.addAttribute("leaveTypes", leaveTypeService.fecthLeaveType());
		return "addLeaveRequest";
	}
	
	@PostMapping("/saveLeaveRequest")
	public String saveLeaveRequest(LeaveRequest leaveRequest) {
		Employee employee = employeeService.getEmployeeId(leaveRequest.getEmployeeId());
	    LeaveType leaveType = leaveTypeService.getLeaveTypeById(leaveRequest.getLeaveTypeId());
	    leaveRequest.setEmployee(employee);
	    leaveRequest.setLeaveType(leaveType);
		leaveRequest.setStatus("PENDING");
		leaveRequestService.saveLeaveRequest(leaveRequest);
		leaveRequestService.processLeaveRequest(leaveRequest.getRequestId());
		return "redirect:/leaveRequest";
	}
	
	@GetMapping("/updateLeaveRequest/{id}")
	public String updateLeaveRequest(@PathVariable Long id, Model model) {
		LeaveRequest leaveRequest = leaveRequestService.getLeaveRequestById(id);
		model.addAttribute("leaveRequest", leaveRequest);
		return "addLeaveRequest";
	}
	
	@GetMapping("/deletLeaveRequest/{id}")
	public String deleteLeaveRequest(@PathVariable Long id) {
		leaveRequestService.deleteById(id);
		return "redirect:/leaveRequest";
	}
}
