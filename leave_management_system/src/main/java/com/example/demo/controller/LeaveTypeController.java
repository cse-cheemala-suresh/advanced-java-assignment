package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.LeaveType;
import com.example.demo.service.LeaveTypeService;

@Controller
public class LeaveTypeController {
	private LeaveTypeService leaveTypeService;

	public LeaveTypeController(LeaveTypeService leaveTypeService) {
		super();
		this.leaveTypeService = leaveTypeService;
	}
	
	@GetMapping("/viewLeaveType")
	public String leaveTypeDetails(Model model) {
		List<LeaveType> leaveTypes = leaveTypeService.fecthLeaveType();
		model.addAttribute("leaveTypeList", leaveTypes);
		System.out.println(leaveTypes);
		return "viewLeaveType";
	}
	
	@GetMapping("/addLeaveType")
	public String showAddForm(Model model) {
		model.addAttribute("leaveTypeForm", new LeaveType());
		return "addLeaveType";
	}
	
	@PostMapping("/saveLeaveType")
	public String saveLeaveType(LeaveType leaveType) {
		leaveTypeService.saveLeaveType(leaveType);
		return "redirect:/viewLeaveType";
	}
	
	@GetMapping("/updateLeaveType/{id}")
	public String updateLeavetype(@PathVariable Long id, Model model) {
		LeaveType leaveType = leaveTypeService.getLeaveTypeById(id);
		model.addAttribute("leaveTypeForm", leaveType);
		return "addLeaveType";
	}
	
	@GetMapping("/deleteLeaveType/{id}")
	public String deleteLeavType(@PathVariable Long id) {
		leaveTypeService.deleteLeaveType(id);
		return "redirect:/viewLeaveType";
	}
}
