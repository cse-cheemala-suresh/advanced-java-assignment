package com.capgemini.hibernate_many_to_one_bidi;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DepartmentBidi")
public class DepartmentBidi {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	@OneToMany(mappedBy = "department")
	private List<StudentBidi> student;
	public DepartmentBidi() {
		super();
	}

	

	public DepartmentBidi(String name) {
		super();
		this.name = name;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<StudentBidi> getStudent() {
		return student;
	}

	public void setStudent(List<StudentBidi> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "DepartmentBidi [id=" + id + ", name=" + name + ", student=" + student + "]";
	}
}
